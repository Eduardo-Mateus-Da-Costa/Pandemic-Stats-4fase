package br.edu.unoesc.pandemicstats.springboot.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pandemicstats.springboot.model.*;
import br.edu.unoesc.pandemicstats.springboot.repository.*;
import br.edu.unoesc.pandemicstats.springboot.responses.*;
import br.edu.unoesc.pandemicstats.springboot.schemmas.*;
import br.edu.unoesc.pandemicstats.springboot.utils.*;

/**
 * @author Eduardo Mateus Da Costa
 * @since 30/10/2021
 * @version 8.0
 * @see br.edu.unoesc.pandemicstats.springboot.model
 * @see br.edu.unoesc.pandemicstats.springboot.repository
 * @see br.edu.unoesc.pandemicstats.springboot.responses
 * @see br.edu.unoesc.pandemicstats.springboot.schemmas
 * @see br.edu.unoesc.pandemicstats.springboot.utils
 */
@RestController
public class GreetingsController {

	@Autowired
	CidadeRepository cidRep;
	@Autowired
	ComorbidadeRepository comRep;
	@Autowired
	EmpresaRepository empRep;
	@Autowired
	EstadoRepository estRep;
	@Autowired
	MedicoRepository medRep;
	@Autowired
	MonitoramentoPacienteRepository monPacRep;
	@Autowired
	PacienteComorbidadeRepository pacComRep;
	@Autowired
	PacienteRepository pacRep;
	@Autowired
	PaisRepository paiRep;
	@Autowired
	SintomaRepository sinRep;
	@Autowired
	TesteCovidRepository tesCovRep;
	@Autowired
	UsuarioRepository usuRep;
	@Autowired
	VacinaRepository vacRep;
	@Autowired
	SolicitacaoRepository solRep;
	
	@Autowired
	EmailSender emaSend;
	
	
	/**
	 * @param Usuario usuusu
	 * @return RespUsu
	 * @see Usuario
	 * @see RespUsu
	 * @see PermisSCH
	 * @see UsuarioRepository
	 */
	@RequestMapping(value="postUsu")
	@ResponseBody
	public ResponseEntity<RespUsu> postUsu(@RequestBody Usuario usuusu) {
		try {
			Usuario usuario = new Usuario();
			usuario = usuRep.findByCPF(usuusu.getCpfusu());
			if (usuario != null) {
				RespUsu respusu = new RespUsu();
				respusu.RespValUsu(null, 503, null);
				return new ResponseEntity<RespUsu>(respusu, HttpStatus.CONFLICT);
			} else {
				usuRep.save(usuusu);
				emaSend.Enviar(usuusu.getEmausu(), "Seja bem vindo ao PandemicStats", "Seja bem vindo ao PandemicStats"); 
				usuRep.createDBUser(usuusu.getEmausu(), usuusu.getSenusu());
				usuRep.grantDBUser(usuusu.getEmausu());
				usuario = usuRep.findByCPF(usuusu.getCpfusu());
				PermisSCH permissoes = getPermis(usuario.getCpfusu());
				RespUsu respusu = new RespUsu();
				respusu.RespValUsu(usuario, 0, permissoes);
				return new ResponseEntity<RespUsu>(respusu, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			RespUsu respusu = new RespUsu();
			respusu.RespValUsu(null, 500, null);
			return new ResponseEntity<RespUsu>(respusu, HttpStatus.CONFLICT);
		}
	}

	/**
	 * @param Usuario usuusu
	 * @return RespUsu
	 * @see CompleteUsu
	 * @see RespUsu
	 * @see Usuario
	 * @see UsuarioRepository
	 */
	@PatchMapping(value = "patchUsu")
	@ResponseBody
	public ResponseEntity<RespUsu> patchUsu(@RequestBody Usuario usuusu) {
		try {
			Usuario usuario = usuRep.findByCPF(usuusu.getCpfusu());
			if (usuario == null)
			{
				RespUsu respusu = new RespUsu();
				respusu.RespValUsu(null, 506, null);
				return new ResponseEntity<RespUsu>(respusu, HttpStatus.BAD_REQUEST);
			}
			if(usuusu.getEmausu() != usuario.getEmausu())
			{
				usuRep.alterUserEmail(usuario.getEmausu(), usuusu.getEmausu());
			}
			if(usuusu.getSenusu() != usuario.getSenusu())
			{
				usuRep.alterUserPassword(usuario.getEmausu(), usuusu.getSenusu());
			}
			//Adicionar método de verificação de cnpj da empresa
			CompleteUsu.complete(usuusu, usuario);
			usuRep.save(usuario);
			
			PermisSCH permissoes = getPermis(usuario.getCpfusu());
			RespUsu respusu = new RespUsu();
			respusu.RespValUsu(usuario, 0, permissoes);
			return new ResponseEntity<RespUsu>(respusu, HttpStatus.OK);
		} catch (Exception e) {
			RespUsu respusu = new RespUsu();
			respusu.RespValUsu(null, 500, null);
			return new ResponseEntity<RespUsu>(respusu, HttpStatus.CONFLICT);
		}
	}
	
	
	/**
	 * @param ReqUsuSCH requsu
	 * @return String
	 * @see Empresa
	 * @see ReqUsuSCH
	 * @see Usuario
	 * @see UsuarioRepository
	 * @see EmpresaRepository
	 */
	@DeleteMapping(value = "deleteUsu")
	@ResponseBody
	public ResponseEntity<String> deleteUsu(@RequestBody ReqUsuSCH requsu) {
		try {
			Usuario usuario = usuRep.findByCPF(requsu.getCpfusu());
			if (usuario == null)
			{
				return new ResponseEntity<String>("Usuário não cadastrado", HttpStatus.BAD_REQUEST);
			}
			Empresa empresa = empRep.findByCpfusu(requsu.getCpfusu());
			if (empresa != null) {
				usuRep.setCnpjempNull(empresa.getCnpjemp());
			}
			usuRep.dropUser(usuario.getEmausu());
			usuRep.deleteByCPF(requsu.getCpfusu());
			return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Erro na deleção", HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * @param ReqUsuSCH requsu
	 * @return RespUsu
	 * @see Usuario
	 * @see PermisSCH
	 * @see RespUsu
	 * @see UsuarioRepository
	 */
	@PostMapping(value = "getUsu")
	@ResponseBody
	public ResponseEntity<RespUsu> getUsu(@RequestBody ReqUsuSCH requsu) {
		Usuario usuario = usuRep.findByCPF(requsu.getCpfusu());
		if (usuario == null)
		{
			RespUsu respusu = new RespUsu();
			respusu.RespValUsu(null, 506, null);
			return new ResponseEntity<RespUsu>(respusu, HttpStatus.BAD_REQUEST);
		}
		PermisSCH permissoes = getPermis(usuario.getCpfusu());
		RespUsu respusu = new RespUsu();
		respusu.RespValUsu(usuario, 0, permissoes);
		return new ResponseEntity<RespUsu>(respusu, HttpStatus.OK);
	}

	/**
	 * @param ReqLoginSCH reqlogin
	 * @return RespUsu
	 * @see PermisSCH
	 * @see Usuario
	 * @see ReqLoginSCH
	 * @see RespUsu
	 * @see UsuarioRepository
	 */
	@PostMapping(value = "postLogin")
	@ResponseBody
	public ResponseEntity<RespUsu> login(@RequestBody ReqLoginSCH reqlogin) {
		Usuario usuario = new Usuario();
		usuario = usuRep.findByEmail(reqlogin.getEmail());
		if (usuario == null) {
			RespUsu respusu = new RespUsu();
			respusu.RespValUsu(null, 505, null);
			return new ResponseEntity<RespUsu>(respusu, HttpStatus.CONFLICT);
		} else {
			if (usuario.getSenusu().equals(reqlogin.getSenha())) {
				PermisSCH permissoes = getPermis(usuario.getCpfusu());
				RespUsu respusu = new RespUsu();
				respusu.RespValUsu(usuario, 0, permissoes);
				return new ResponseEntity<RespUsu>(respusu, HttpStatus.ACCEPTED);
			} else {
				RespUsu respusu = new RespUsu();
				respusu.RespValUsu(null, 504, null);
				return new ResponseEntity<RespUsu>(respusu, HttpStatus.UNAUTHORIZED);
			}
		}
	}

	/**
	 * @param Empresa empemp
	 * @return RespEmp
	 * @see Empresa
	 * @see RespEmp
	 * @see Usuario
	 * @see EmpresaRepository
	 * @see UsuarioRepository
	 */
	@PostMapping(value = "postEmp")
	@ResponseBody
	public ResponseEntity<RespEmp> postEmp(@RequestBody Empresa empemp) {
		try {
			Usuario usuario = empemp.getCpfusu();
			usuario = usuRep.findByCPF(usuario.getCpfusu());
			if (usuario == null)
			{
				RespEmp respemp = new RespEmp();
				respemp.RespValEmp(null, 506);
				return new ResponseEntity<RespEmp>(respemp, HttpStatus.BAD_REQUEST);
			}
			Empresa empresa = new Empresa();
			empresa = empRep.findByCnpjemp(empemp.getCnpjemp());
			if (empresa != null) {
				RespEmp respemp = new RespEmp();
				respemp.RespValEmp(null, 503);
				return new ResponseEntity<RespEmp>(respemp, HttpStatus.CONFLICT);
			} else {
				empRep.save(empemp);
				empRep.grantDBEmpresa(usuario.getEmausu());
				RespEmp respemp = new RespEmp();
				empresa = empRep.findByCnpjemp(empemp.getCnpjemp());
				respemp.RespValEmp(empresa, 0);
				return new ResponseEntity<RespEmp>(respemp, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			RespEmp respemp = new RespEmp();
			respemp.RespValEmp(null, 500);
			return new ResponseEntity<RespEmp>(respemp, HttpStatus.CONFLICT);
		}
	}

	/**
	 * @param Empresa empemp
	 * @return RespEmp
	 * @see Empresa
	 * @see RespEmp
	 * @see Usuario
	 * @see CompleteEmp
	 * @see EmpresaRepository
	 */
	@PatchMapping(value = "patchEmp")
	@ResponseBody
	public ResponseEntity<RespEmp> patchEmp(@RequestBody Empresa empemp) {
		try {
			Empresa empresa = empRep.findByCnpjemp(empemp.getCnpjemp());
			Usuario usuario1 = empresa.getCpfusu();
			Usuario usuario2 = empemp.getCpfusu(); //Adicionar verificação do novo dono
			if(usuario1.getCpfusu() != usuario2.getCpfusu())
			{
				Empresa emp = empRep.findByCpfusu(usuario1.getCpfusu());
				if (emp == null)
				{
					empRep.revokeEmpresa(usuario1.getEmausu(), "g_empresa");
				}
				empRep.grantDBEmpresa(usuario2.getEmausu());
			}
			CompleteEmp.complete(empemp, empresa);
			empRep.save(empresa);
			RespEmp respemp = new RespEmp();
			respemp.RespValEmp(empresa, 0);
			return new ResponseEntity<RespEmp>(respemp, HttpStatus.OK);
		} catch (Exception e) {
			RespEmp respemp = new RespEmp();
			respemp.RespValEmp(null, 500);
			return new ResponseEntity<RespEmp>(respemp, HttpStatus.CONFLICT);
		}
	}

	/**
	 * @param ReqEmpSCH reqemp
	 * @return String
	 * @see ReqEmpSCH
	 * @see Empresa
	 * @see EmpresaRepository
	 * @see Usuario
	 * @see UsuarioRepository
	 */
	@DeleteMapping(value = "deleteEmp")
	@ResponseBody
	public ResponseEntity<String> deleteEmp(@RequestBody ReqEmpSCH reqemp) {
		try {
			Empresa empresa = empRep.findByCnpjemp(reqemp.getCnpjemp());
			if (empresa == null)
			{
				return new ResponseEntity<String>("Empresa não cadastrada", HttpStatus.BAD_REQUEST);
			}
			usuRep.setCnpjempNull(reqemp.getCnpjemp());
			empRep.deleteById(reqemp.getCnpjemp());
			Usuario usuario = empresa.getCpfusu();
			usuario = usuRep.findByCPF(usuario.getCpfusu());
			Empresa emp = empRep.findByCpfusu(usuario.getCpfusu());
			if (emp == null)
			{
				empRep.revokeEmpresa(usuario.getEmausu(), "g_empresa");
			}
			return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro na deleção", HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * @param ReqEmpSCH reqemp
	 * @return ShowEmpSCH
	 * @see ShowEmpSCH
	 * @see ReqEmpSCH
	 * @see Empresa
	 * @see EmpresaRepository
	 */
	@PostMapping(value = "getEmp")
	@ResponseBody
	public ResponseEntity<?> getEmp(@RequestBody ReqEmpSCH reqemp) {
		Empresa empresa = empRep.findByCnpjemp(reqemp.getCnpjemp());
		if (empresa == null)
		{
			return new ResponseEntity<String>("Empresa não cadastrada", HttpStatus.BAD_REQUEST);
		}
		ShowEmpSCH showemp = new ShowEmpSCH();
		showemp.Convert(empresa);
		return new ResponseEntity<ShowEmpSCH>(showemp, HttpStatus.OK);
	}
	/**
	 * @param Medico medmed
	 * @return RespMed
	 * @see Medico
	 * @see RespMed
	 * @see Usuario
	 * @see UsuarioRepository
	 * @see MedicoRepository
	 */
	@PostMapping(value = "postMed")
	@ResponseBody
	public ResponseEntity<RespMed> postMed(@RequestBody Medico medmed) {
		Medico medico = new Medico();
		System.out.println(medmed);
		medico = medRep.findByCRM(medmed.getCrmmed());
		if (medico != null) {
			RespMed respmed = new RespMed();
			respmed.RespValMed(null, 501);
			return new ResponseEntity<RespMed>(respmed, HttpStatus.CONFLICT);
		} else {
			Usuario usuario = medmed.getCpfusu();
			usuario = usuRep.findByCPF(usuario.getCpfusu());
			if (usuario == null)
			{
				RespMed respmed = new RespMed();
				respmed.RespValMed(null, 506);
				return new ResponseEntity<RespMed>(respmed, HttpStatus.CONFLICT);
			}
			medRep.save(medmed);
			medRep.grantDBMedico(usuario.getEmausu());
			RespMed respmed = new RespMed();
			respmed.RespValMed(medmed, 0);
			return new ResponseEntity<RespMed>(respmed, HttpStatus.CREATED);
		}
	}

	/**
	 * @param ReqMedSCH reqmed
	 * @return String
	 * @see Medico
	 * @see ReqMedSCH
	 * @see MedicoRepository
	 * @see Usuario
	 * @see UsuarioRepository
	 */
	@DeleteMapping(value = "deleteMed")
	@ResponseBody
	public ResponseEntity<String> deleteMed(@RequestBody ReqMedSCH reqmed) {
		try {
			Medico medico= medRep.findByCRM(reqmed.getCrmmed());
			if (medico == null)
			{
				return new ResponseEntity<String>("Médico não encontrado", HttpStatus.BAD_REQUEST);
			}
			Usuario usuario = medico.getCpfusu();
			usuario = usuRep.findByCPF(usuario.getCpfusu());
			medRep.revokeMedico(usuario.getEmausu(), "g_medico");
			vacRep.setCrmNull(medico.getCrmmed());
			medRep.deleteById(medico.getCrmmed());
			return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro na deleção", HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * @param ReqMedSCH reqmed
	 * @return ShowMedSCH
	 * @see ShowMedSCH
	 * @see ReqMedSCH
	 * @see Medico
	 * @see MedicoRepository
	 */
	@PostMapping(value = "getMed")
	@ResponseBody
	public ResponseEntity<?> getMed(@RequestBody ReqMedSCH reqmed) {
		Medico medico = medRep.findByCRM(reqmed.getCrmmed());
		if (medico == null)
		{
			return new ResponseEntity<String>("Médico não encontrado", HttpStatus.BAD_REQUEST);
		}
		ShowMedSCH showmed = new ShowMedSCH();
		showmed.Convert(medico);
		return new ResponseEntity<ShowMedSCH>(showmed, HttpStatus.OK);
	}


	/**
	 * @param ReqCidSCH reqcid
	 * @return ShowCidSCH
	 * @see Cidade
	 * @see ReqCidSCH
	 * @see ShowCidSCH
	 * @see CidadeRepository
	 */
	@PostMapping(value = "getCid")
	@ResponseBody
	public ResponseEntity<?> getCid(@RequestBody ReqCidSCH reqcid) {
		Cidade cidade = cidRep.findByCodcid(reqcid.getCodcid());
		if (cidade == null)
		{
			return new ResponseEntity<String>("Cidade não encontrada", HttpStatus.BAD_REQUEST);
		}
		ShowCidSCH showcid = new ShowCidSCH();
		showcid.Convert(cidade);
		return new ResponseEntity<ShowCidSCH>(showcid, HttpStatus.OK);
	}

	/**
	 * 
	 * @param ReqCidSCH reqcid
	 * @return List<ShowCidSCH>
	 * @see Cidade
	 * @see CidadeRepository
	 * @see ShowCidSCH
	 * @see java.util.List
	 */
	@PostMapping(value = "getEstCids")
	@ResponseBody
	public ResponseEntity<?> getCids(@RequestBody ReqCidSCH reqcid) {
		Estado estado = estRep.findByCodest(reqcid.getCodest());
		if (estado == null)
		{
			return new ResponseEntity<String>("Estado não encontrado", HttpStatus.BAD_REQUEST);
		}
		List<Cidade> cidades = cidRep.findByCodest(reqcid.getCodest());
		List<ShowCidSCH> listshowcid = new ArrayList<ShowCidSCH>();
		for (Cidade ctmp : cidades) {
			ShowCidSCH sctmp = new ShowCidSCH();
			sctmp.Convert(ctmp);
			listshowcid.add(sctmp);
		}
		return new ResponseEntity<List<ShowCidSCH>>(listshowcid, HttpStatus.OK);
	}

	/**
	 * @return List<Comorbidade>
	 * @see Comorbidade
	 * @see ComorbidadeRepository
	 * @see java.util.List
	 */
	@GetMapping(value = "getComs")
	@ResponseBody
	public ResponseEntity<List<Comorbidade>> getComs() {
		List<Comorbidade> comorbidades = comRep.findAllComs();
		return new ResponseEntity<List<Comorbidade>>(comorbidades, HttpStatus.OK);
	}

	/**
	 * @param ReqEstSCH reqest
	 * @return ShowEstSCH
	 * @see ShowEstSCH
	 * @see ReqEstSCH 
	 * @see Estado
	 * @see EstadoRepository
	 */
	@PostMapping(value = "getEst")
	@ResponseBody
	public ResponseEntity<?> getEst(@RequestBody ReqEstSCH reqest) {
		Estado estado = estRep.findByCodest(reqest.getCodest());
		if (estado == null)
		{
			return new ResponseEntity<String>("Estado não encontrado", HttpStatus.BAD_REQUEST);
		}
		ShowEstSCH showest = new ShowEstSCH();
		showest.Convert(estado);
		return new ResponseEntity<ShowEstSCH>(showest, HttpStatus.OK);
	}

	/**
	 * @param ReqEstSCH reqest
	 * @return List<ShowEstSCH>
	 * @see ShowEstSCH
	 * @see ReqEstSCH 
	 * @see Estado
	 * @see EstadoRepository
	 * @see java.util.List
	 */
	@PostMapping(value = "getEsts")
	@ResponseBody
	public ResponseEntity<?> getEsts(@RequestBody ReqEstSCH reqest) {
		Pais pais = paiRep.findByCodpai(reqest.getCodpai());
		if (pais == null)
		{
			return new ResponseEntity<String>("Pais não encontrado", HttpStatus.BAD_REQUEST);
		}
		List<Estado> estados = estRep.findByCodpai(reqest.getCodpai());
		List<ShowEstSCH> listshowest = new ArrayList<ShowEstSCH>();
		for (Estado etmp : estados) {
			ShowEstSCH setmp = new ShowEstSCH();
			setmp.Convert(etmp);
			listshowest.add(setmp);
		}
		return new ResponseEntity<List<ShowEstSCH>>(listshowest, HttpStatus.OK);
	}


	/**
	 * @param MonitoramentoPaciente monpac
	 * @return RespMonPac
	 * @see RespMonPac
	 * @see MonitoramentoPaciente
	 * @see MonitoramentoPacienteRepository
	 */
	@PostMapping(value = "postMonPac")
	@ResponseBody
	public ResponseEntity<RespMonPac> postMomPac(@RequestBody MonitoramentoPaciente monpac) {
		try {
			char intsin = monpac.getIntsin();
			if ((intsin == 'P') || (intsin == 'M') || (intsin == 'C') || (intsin == 'S')) {
				Paciente paciente = monpac.getCodpac();
				paciente = pacRep.findByCodpac(paciente.getCodpac());
				if (paciente == null)
				{
					RespMonPac respmonpac = new RespMonPac();
					respmonpac.RespValMomPac(null, 506);
					return new ResponseEntity<RespMonPac>(respmonpac, HttpStatus.BAD_REQUEST);
				}
				monPacRep.save(monpac);
				RespMonPac respmonpac = new RespMonPac();
				respmonpac.RespValMomPac(monpac, 0);
				return new ResponseEntity<RespMonPac>(respmonpac, HttpStatus.OK);
			} else {
				RespMonPac respmonpac = new RespMonPac();
				respmonpac.RespValMomPac(monpac, 501);
				return new ResponseEntity<RespMonPac>(respmonpac, HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			RespMonPac respmonpac = new RespMonPac();
			respmonpac.RespValMomPac(monpac, 500);
			return new ResponseEntity<RespMonPac>(respmonpac, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * @param ReqMonPacSCH reqmompac
	 * @return List<ShowMonPacSCH>
	 * @see MonitoramentoPaciente
	 * @see MonitoramentoPacienteRepository
	 * @see ShowMonPac
	 * @see java.util.List
	 */
	@PostMapping(value = "getMonsPac")
	@ResponseBody
	public ResponseEntity<?> getMonsPac(@RequestBody ReqMonPacSCH reqmompac) {
		Paciente paciente = pacRep.findByCodpac(reqmompac.getCodpac());
		if (paciente == null)
		{
			return new ResponseEntity<String>("Paciente não encontrado", HttpStatus.BAD_REQUEST);
		}
		List<MonitoramentoPaciente> monitoramentos = monPacRep.findByCodpac(reqmompac.getCodpac());
		List<ShowMonPacSCH> showmonspac = new ArrayList<ShowMonPacSCH>();
		for (MonitoramentoPaciente mptmp : monitoramentos) {
			ShowMonPacSCH smptmp = new ShowMonPacSCH();
			smptmp.Convert(mptmp);
			showmonspac.add(smptmp);
		}
		return new ResponseEntity<List<ShowMonPacSCH>>(showmonspac, HttpStatus.OK);
	}


	/**
	 * @param Paciente pacpac
	 * @return RespPac
	 * @see RespPac
	 * @see Paciente
	 * @see PacienteRepository
	 * @see Usuario
	 * @see CompletePac
	 */
	@PostMapping(value = "postORpatchPac")
	@ResponseBody
	public ResponseEntity<RespPac> postPac(@RequestBody Paciente pacpac) {
		try {
			if ((pacpac.getGrurispac() == 'S') || (pacpac.getGrurispac() == 'N')) {
				if ((pacpac.getSitpac().equals("INTERNADO")) || (pacpac.getSitpac().equals("ISOLAMENTO"))
						|| (pacpac.getSitpac().equals("BEM"))) {
					if ((pacpac.getPespac() < 0) || (pacpac.getPespac() > 500)) {
						RespPac resppac = new RespPac();
						resppac.RespValPac(null, 503);
						return new ResponseEntity<RespPac>(resppac, HttpStatus.CONFLICT);
					} else {
						Paciente paciente = new Paciente();
						Usuario usuario = pacpac.getCpfusu();
						usuario = usuRep.findByCPF(usuario.getCpfusu());
						if (usuario == null)
						{
							RespPac resppac = new RespPac();
							resppac.RespValPac(null, 506);
							return new ResponseEntity<RespPac>(resppac, HttpStatus.BAD_REQUEST);
						}
						paciente = pacRep.findByCpfusu(usuario.getCpfusu());
						if (paciente == null) {
							pacRep.save(pacpac);
							pacRep.grantDBPaciente(usuario.getEmausu());
							RespPac resppac = new RespPac();
							resppac.RespValPac(pacpac, 0);
							return new ResponseEntity<RespPac>(resppac, HttpStatus.OK);
						} else {
							CompletePac.complete(pacpac, paciente);
							pacRep.save(paciente);
							RespPac resppac = new RespPac();
							resppac.RespValPac(paciente, 0);
							return new ResponseEntity<RespPac>(resppac, HttpStatus.OK);
						}
					}
				} else {
					RespPac resppac = new RespPac();
					resppac.RespValPac(null, 502);
					return new ResponseEntity<RespPac>(resppac, HttpStatus.CONFLICT);
				}
			} else {
				RespPac resppac = new RespPac();
				resppac.RespValPac(null, 501);
				return new ResponseEntity<RespPac>(resppac, HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			RespPac resppac = new RespPac();
			resppac.RespValPac(null, 500);
			return new ResponseEntity<RespPac>(resppac, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * @param ReqPacSCH reqpac
	 * @return ShowPacSCH
	 * @see ShowPacSCH
	 * @see ReqPacSCH 
	 * @see Paciente
	 * @see PacienteRepository
	 */
	@PostMapping(value = "getPac")
	@ResponseBody
	public ResponseEntity<?> getPac(@RequestBody ReqPacSCH reqpac) {
		Paciente paciente = pacRep.findByCpfusu(reqpac.getCpfusu());
		if (paciente == null)
		{
			return new ResponseEntity<String>("Paciente não encontrado", HttpStatus.BAD_REQUEST);
		}
		ShowPacSCH showpac = new ShowPacSCH();
		showpac.Convert(paciente);
		return new ResponseEntity<ShowPacSCH>(showpac, HttpStatus.OK);
	}


	/**
	 * @param PacienteComorbidade paccompaccom
	 * @return String
	 * @see Paciente
	 * @see Comorbidade 
	 * @see PacienteComorbidade
	 * @see PacienteComorbidadeRepository
	 */
	@PostMapping(value = "postPacCom")
	@ResponseBody
	public ResponseEntity<String> postPacCom(@RequestBody PacienteComorbidade paccompaccom) {
		Paciente paciente = paccompaccom.getCodpac();
		paciente = pacRep.findByCodpac(paciente.getCodpac());
		if (paciente == null)
		{
			return new ResponseEntity<String>("Paciente não encontrado", HttpStatus.BAD_REQUEST);
		}
		Comorbidade comorbidade = paccompaccom.getCodcom();
		PacienteComorbidade paccom = pacComRep.findByCodpacANDCodcom(paciente.getCodpac(), comorbidade.getCodcom());
		if (paccom != null) {
			return new ResponseEntity<String>("Ja estava cadastrado", HttpStatus.OK);
		} else {
			pacComRep.save(paccompaccom);
			return new ResponseEntity<String>("Salvo", HttpStatus.CREATED);
		}
	}


	/**
	 * @param Solicitacao solicitacao
	 * @return String
	 * @see SolicitacaoRepository
	 * @see Solicitacao
	 */
	@PostMapping(value = "postSol")
	@ResponseBody
	public ResponseEntity<String> postSol(@RequestBody Solicitacao solicitacao) {
		Usuario usuario = solicitacao.getCpfusu();
		usuario = usuRep.findByCPF(usuario.getCpfusu());
		if (usuario == null)
		{
			return new ResponseEntity<String>("Usuario não cadastrado", HttpStatus.BAD_REQUEST);
		}
		
		if (solicitacao.getDessol() == null) {
			return new ResponseEntity<String>("Solicitacao vazia", HttpStatus.BAD_REQUEST);
		} else {
			solRep.save(solicitacao);
			return new ResponseEntity<String>("Salva", HttpStatus.OK);
		}
	}


	/**
	 * @param TesteCovid teste
	 * @return RespTesCov
	 * @see RespTesCov
	 * @see TesteCovid
	 * @see TesteCovidRepository
	 */
	@PostMapping(value = "postTesCov")
	@ResponseBody
	public ResponseEntity<?> postTesCov(@RequestBody TesteCovid teste) {
		Paciente paciente = teste.getCodpac();
		paciente = pacRep.findByCodpac(paciente.getCodpac());
		if (paciente == null)
		{
			return new ResponseEntity<String>("Paciente não encontrado", HttpStatus.BAD_REQUEST);
		}
		
		if (teste.getDattes() == null) {
			teste.setDattes(new java.sql.Date(new java.util.Date().getTime()));
		}
		if ((teste.getCovpactes() == 'P') || (teste.getCovpactes() == 'N')) {
			tesCovRep.save(teste);
			RespTesCov resptescov = new RespTesCov();
			resptescov.RespValTesCov(teste, 0);
			return new ResponseEntity<RespTesCov>(resptescov, HttpStatus.CREATED);
		} else {
			RespTesCov resptescov = new RespTesCov();
			resptescov.RespValTesCov(null, 501);
			return new ResponseEntity<RespTesCov>(resptescov, HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * @param ReqTesCovSCH reqteste
	 * @return List<ShowTesCovSCH>
	 * @see ReqTesCovSCH
	 * @see ShowTesCovSCH
	 * @see TesteCovid
	 * @see java.util.List
	 */
	@GetMapping(value = "getTests")
	@ResponseBody
	public ResponseEntity<?> getTests(@RequestBody ReqTesCovSCH reqteste)
	{
		Paciente paciente = pacRep.findByCodpac(reqteste.getCodpac());
		if (paciente == null)
		{
			return new ResponseEntity<String>("Paciente não encontrado", HttpStatus.BAD_REQUEST);
		}
		List<TesteCovid> testes = tesCovRep.findByCodpac(reqteste.getCodpac());
		List<ShowTesCovSCH> showtests = new ArrayList<ShowTesCovSCH>();
		for(TesteCovid teste : testes)
		{
			ShowTesCovSCH showtesttmp = new ShowTesCovSCH();
			showtesttmp.Convert(teste);
			showtests.add(showtesttmp);
		}
		return new ResponseEntity<List<ShowTesCovSCH>>(showtests, HttpStatus.OK);
	}


	/**
	 * @param Vacina vacvac
	 * @return RespVac
	 * @see RespVac
	 * @see Vacina
	 * @see VacinaRepository
	 * @see Paciente
	 * @see Medico
	 * @see MedicoRepository
	 */
	@PostMapping(value = "postVac")
	@ResponseBody
	public ResponseEntity<?> postVac(@RequestBody Vacina vacvac) {
		try {
			if (vacvac.getDatvac() == null) {
				vacvac.setDatvac(new java.sql.Date(new java.util.Date().getTime()));
			}
			
			int verificador1 = 0;
			int verificador2 = 0;
			Paciente paciente = vacvac.getCodpac();
			paciente = pacRep.findByCodpac(paciente.getCodpac());
			if (paciente == null)
			{
				return new ResponseEntity<String>("Paciente não encontrado", HttpStatus.BAD_REQUEST);
			}
			List<Vacina> vacinas = vacRep.findByCodpac(paciente.getCodpac());
			for(Vacina vactmp : vacinas)
			{
				if(vactmp.getDosvac() == 1)
				{
					verificador1++;
				}
				else if (vactmp.getDosvac() == 2)
				{
					verificador2++;
				}
			}
			if(((verificador2 == 1)&&(vacvac.getDosvac() == 2))||((verificador1 == 1)&&(vacvac.getDosvac() == 1)))
			{
				RespVac respvac = new RespVac();
				respvac.RespValVac(null, 502);
				return new ResponseEntity<RespVac>(respvac, HttpStatus.BAD_REQUEST);
			}
			
			Medico medicovac = vacvac.getCrmmed();
			Medico medico = medRep.findByCRM(medicovac.getCrmmed());
			if (medico == null) 
			{
				return new ResponseEntity<String>("Médico não encontrado", HttpStatus.BAD_REQUEST);
			}
			vacRep.save(vacvac);
			RespVac respvac = new RespVac();
			respvac.RespValVac(vacvac, 0);
			return new ResponseEntity<RespVac>(respvac, HttpStatus.CREATED);
		} catch (Exception e) {
			RespVac respvac = new RespVac();
			respvac.RespValVac(null, 501);
			return new ResponseEntity<RespVac>(respvac, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	/**
	 * @param ReqVacSCH reqvac
	 * @return List<ShowVacSCH>
	 * @see ReqVacSCH
	 * @see ShowVacSCH
	 * @see java.util.List
	 */
	@GetMapping(value = "getVacs")
	@ResponseBody
	public ResponseEntity<?> getVacs(@RequestBody ReqVacSCH reqvac)
	{
		Paciente paciente = pacRep.findByCodpac(reqvac.getCodpac());
		if (paciente == null)
		{
			return new ResponseEntity<String>("Paciente não encontrado", HttpStatus.BAD_REQUEST);
		}
		List<Vacina> vacinas = vacRep.findByCodpac(reqvac.getCodpac());
		List<ShowVacSCH> showvacs = new ArrayList<ShowVacSCH>();
		for(Vacina vacina : vacinas)
		{
			ShowVacSCH showvactmp = new ShowVacSCH();
			showvactmp.Convert(vacina);
			showvacs.add(showvactmp);
		}
		return new ResponseEntity<List<ShowVacSCH>>(showvacs, HttpStatus.OK);
	}
	

	/**
	 * @return List<Pais>
	 * @see Pais
	 * @see PaisRepository
	 * @see java.util.List
	 */
	@GetMapping(value = "getPaises")
	@ResponseBody
	public ResponseEntity<List<Pais>> getPaises()
	{
		List<Pais> paises = paiRep.findAll();
		return new ResponseEntity<List<Pais>>(paises, HttpStatus.OK);
	}
	

	/**
	 * @return List<Sintoma>
	 * @see Sintomas
	 * @see SintomasRepository
	 * @see java.util.List
	 */
	@GetMapping(value = "getSints")
	@ResponseBody
	public ResponseEntity<List<Sintoma>> getSints()
	{
		List<Sintoma> sintomas = sinRep.findAll();
		return new ResponseEntity<List<Sintoma>>(sintomas, HttpStatus.OK);
	}


	/**
	 * @param long reqfunc
	 * @return List<CidadeCovidSCH>
	 * @see CidadeCovidSCH
	 * @see CidadeRepository
	 */
	@GetMapping(value = "medgetCidCov")
	@ResponseBody
	public ResponseEntity<?> medgetCidCov(@RequestBody long reqfunc)
	{
		Cidade cidade = cidRep.findByCodcid(reqfunc);
		if (cidade == null)
		{
			return new ResponseEntity<String>("Cidade não encontrada", HttpStatus.OK);
		}
		List<Map<String, Object>> lista = medRep.funcCidCov(reqfunc);
		return new ResponseEntity<List<Map<String, Object>>>(lista, HttpStatus.OK);
	}
	
	/**
	 * @param long reqfunc
	 * @return List<EmpresaCovidSCH>
	 * @see EmpresaCovidSCH
	 * @see EmpresaRepository
	 * @see java.util.List
	 */
	@GetMapping(value = "medgetEmpCov")
	@ResponseBody
	public ResponseEntity<?> medgetEmpCov(@RequestBody long reqfunc)
	{
		Empresa empresa = empRep.findByCnpjemp(reqfunc);
		if (empresa == null)
		{
			return new ResponseEntity<String>("Empresa não encontrada", HttpStatus.OK);
		}
		List<Map<String, Object>> lista = empRep.funcEmpCov(reqfunc);
		return new ResponseEntity<List<Map<String, Object>>>(lista, HttpStatus.OK);
	}
	
	/**
	 * @param long reqfunc
	 * @return Long
	 * @see MedicoRepository
	 */
	@GetMapping(value = "medGetPdose")
	@ResponseBody
	public ResponseEntity<?> medGetPdose(@RequestBody long reqfunc)
	{
		Cidade cidade = cidRep.findByCodcid(reqfunc);
		if (cidade == null)
		{
			return new ResponseEntity<String>("Cidade não encontrada", HttpStatus.OK);
		}
		long casos = medRep.PDoseCidade(reqfunc);
		return new ResponseEntity<Long>(casos, HttpStatus.OK);
	}
	
	/**
	 * @param long reqfunc
	 * @return Long
	 * @see MedicoRepository
	 */
	@GetMapping(value = "medGetSdose")
	@ResponseBody
	public ResponseEntity<?> medGetSdose(@RequestBody long reqfunc)
	{
		Cidade cidade = cidRep.findByCodcid(reqfunc);
		if (cidade == null)
		{
			return new ResponseEntity<String>("Cidade não encontrada", HttpStatus.OK);
		}
		long casos = medRep.SDoseCidade(reqfunc);
		System.out.println(casos);
		return new ResponseEntity<Long>(casos, HttpStatus.OK);
	}
	
	/**
	 * @param long reqfunc
	 * @return List<EmpresaCovidSCH>
	 * @see EmpresaCovidSCH
	 * @see EmpresaRepository
	 * @see java.util.List
	 */
	@GetMapping(value = "empgetEmpCov")
	@ResponseBody
	public ResponseEntity<?> empgetEmpCov(@RequestBody long reqfunc)
	{
		Empresa empresa = empRep.findByCnpjemp(reqfunc);
		if (empresa == null)
		{
			return new ResponseEntity<String>("Empresa não encontrada", HttpStatus.BAD_REQUEST);
		}
		List<Map<String, Object>> lista = empRep.funcEmpCov(reqfunc);
		return new ResponseEntity<List<Map<String, Object>>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "getVw1")
	@ResponseBody
	public ResponseEntity<?> getVw1()
	{
		try
		{
			List<Map<String, Object>> lista = medRep.selectVw1();
			return new ResponseEntity<List<Map<String, Object>>>(lista, HttpStatus.OK);
		}catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<String>("Deu erro", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "getVw2")
	@ResponseBody
	public ResponseEntity<?> getVw2()
	{
		try
		{
			List<Map<String, Object>> lista = medRep.selectVw2();
			return new ResponseEntity<List<Map<String, Object>>>(lista, HttpStatus.OK);
		}catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<String>("Deu erro", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "getVw3")
	@ResponseBody
	public ResponseEntity<?> getVw3()
	{
		try
		{
			List<Map<String, Object>> lista = medRep.selectVw3();
			return new ResponseEntity<List<Map<String, Object>>>(lista, HttpStatus.OK);
		}catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<String>("Deu erro", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "getVw4")
	@ResponseBody
	public ResponseEntity<?> getVw4()
	{
		try
		{
			List<Map<String, Object>> lista = medRep.selectVw4();
			return new ResponseEntity<List<Map<String, Object>>>(lista, HttpStatus.OK);
		}catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<String>("Deu erro", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * @param long cpfusu
	 * @return PermisSCH
	 * @see Paciente
	 * @see Medico
	 * @see Empresa
	 * @see PacienteRepository
	 * @see MedicoRepository
	 * @see EmpresaRepository
	 */
	public PermisSCH getPermis(long cpfusu)
	{
		Paciente paciente = pacRep.findByCpfusu(cpfusu);
		Empresa empresa = empRep.findByCpfusu(cpfusu);
		Medico medico = medRep.findByCPF(cpfusu);
		PermisSCH permissao = new PermisSCH();
		if(paciente != null)
		{
			permissao.setPaciente(true);
		}
		else
		{
			permissao.setPaciente(false);
		}
		if(empresa != null)
		{
			permissao.setEmpresa(true);
		}
		else
		{
			permissao.setEmpresa(false);
		}
		if(medico != null)
		{
			permissao.setMedico(true);
		}
		else
		{
			permissao.setMedico(false);
		}
		
		return permissao;
	}
	
}
