package br.edu.unoesc.pandemicstats.springboot.controllers;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pandemicstats.springboot.model.Cidade;
import br.edu.unoesc.pandemicstats.springboot.model.Comorbidade;
import br.edu.unoesc.pandemicstats.springboot.model.Empresa;
import br.edu.unoesc.pandemicstats.springboot.model.Endereco;
import br.edu.unoesc.pandemicstats.springboot.model.Estado;
import br.edu.unoesc.pandemicstats.springboot.model.Medico;
import br.edu.unoesc.pandemicstats.springboot.model.MonitoramentoPaciente;
import br.edu.unoesc.pandemicstats.springboot.model.Usuario;
import br.edu.unoesc.pandemicstats.springboot.repository.CidadeRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.ComorbidadeRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.EmpresaRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.EnderecoRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.EstadoRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.MedicoRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.MonitoramentoPacienteRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.PacienteRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.PacienteComorbidadeRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.PaisRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.SintomaRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.SolicitacaoRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.Test_covidRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.UsuarioRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.VacinaRepository;
import br.edu.unoesc.pandemicstats.springboot.responses.RespEmp;
import br.edu.unoesc.pandemicstats.springboot.responses.RespEnd;
import br.edu.unoesc.pandemicstats.springboot.responses.RespMed;
import br.edu.unoesc.pandemicstats.springboot.responses.RespMonPac;
import br.edu.unoesc.pandemicstats.springboot.responses.RespUsu;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ReqLoginSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ReqCidSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ReqComSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ReqEmpSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ReqEndSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ReqEstSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ReqMedSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ReqMonPacSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ReqUsuSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowCidSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowEmpSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowEndSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowEstSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowMedSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowMonPacSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowUsuSCH;
import br.edu.unoesc.pandemicstats.springboot.utils.CompleteEmp;
import br.edu.unoesc.pandemicstats.springboot.utils.CompleteEnd;
import br.edu.unoesc.pandemicstats.springboot.utils.CompleteUsu;
/**
 *
 * A sample greetings controller to return greeting text
 */


@RestController
public class GreetingsController {
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
	
	@Autowired
	CidadeRepository cidRep;
	@Autowired
	ComorbidadeRepository comRep;
	@Autowired
	EmpresaRepository empRep;
	@Autowired
	EnderecoRepository endRep;
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
	Test_covidRepository tesCovRep;
	@Autowired
	UsuarioRepository usuRep;
	@Autowired
	VacinaRepository vacRep;
	@Autowired
	SolicitacaoRepository solRep;
    
//Endpoints de usuário
    @PostMapping(value = "postUsu")
    @ResponseBody
    public ResponseEntity<RespUsu> postUsu(@RequestBody Usuario usuusu)
    {
    	try {
    		Usuario usuario = new Usuario();
    		usuario = usuRep.findByCPF(usuusu.getCpfusu());
    		if(usuario != null)
    		{
    			RespUsu respusu = new RespUsu();
    			respusu.RespValUsu(null, 503);
    			return new ResponseEntity<RespUsu>(respusu, HttpStatus.CONFLICT);
    		}
    		else
    		{
    			usuRep.save(usuusu);
    			RespUsu respusu = new RespUsu();
    			respusu.RespValUsu(usuusu, 0);
    			return new ResponseEntity<RespUsu>(respusu, HttpStatus.CREATED);
    		}
		} catch (Exception e) {
			RespUsu respusu = new RespUsu();
			respusu.RespValUsu(null, 500);
			return new ResponseEntity<RespUsu>(respusu, HttpStatus.CONFLICT);
		}
    }
    
    @PatchMapping(value = "patchUsu")
    @ResponseBody
    public ResponseEntity<RespUsu> patchUsu(@RequestBody Usuario requsu)
    {
    	try {
    		Usuario usuario = usuRep.findByCPF(requsu.getCpfusu());
    		CompleteUsu.complete(requsu, usuario);
    		usuRep.save(requsu);
    		RespUsu respusu = new RespUsu();
    		respusu.RespValUsu(requsu, 0);
    		return new ResponseEntity<RespUsu>(respusu, HttpStatus.OK);
    	}catch(Exception e)
    	{
    		RespUsu respusu = new RespUsu();
    		respusu.RespValUsu(null, 500);
    		return new ResponseEntity<RespUsu>(respusu, HttpStatus.CONFLICT);
    	}
    }
    
    
    @DeleteMapping(value = "deleteUsu")
    @ResponseBody
    public ResponseEntity<String> deleteUsu(@RequestBody ReqUsuSCH requsu)
    {
    	try {
    		Usuario usuario = new Usuario();
    		if(requsu.getEmausu() != null)
    		{
    			usuario = usuRep.findByEmail(requsu.getEmausu());
    		}
    		else
    		{
    			usuario = usuRep.findByCPF(requsu.getCpfusu());
    		}
    		
    		Empresa empresa = empRep.findByCpfusu(usuario.getCpfusu());
    		if(empresa !=null)
    		{
    			usuRep.setCnpjempNull(empresa.getCnpjemp());
    		}
    		
    		Endereco endereco = endRep.findByCPF(usuario.getCpfusu());
    		endRep.deleteById(endereco.getCodend());
    		
    		usuRep.deleteById(usuario.getCpfusu());
    		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
    	}catch(Exception e)
    	{
    		return new ResponseEntity<String>("Erro na deleção", HttpStatus.NOT_FOUND);
    	}
    }
    
    @GetMapping(value = "getUsu")
    @ResponseBody
    public ResponseEntity<ShowUsuSCH>getUsu(@RequestBody ReqUsuSCH requsu)
    {
    	Usuario usuario = new Usuario();
    	if (requsu.getEmausu() != null)
    	{
    		usuario = usuRep.findByEmail(requsu.getEmausu());
    	}
    	else
    	{
    		usuario = usuRep.findByCPF(requsu.getCpfusu());
    	}
    	ShowUsuSCH showusu = new ShowUsuSCH();
    	showusu.Convert(usuario);
    	return new ResponseEntity<ShowUsuSCH>(showusu, HttpStatus.OK);
    }
    
    @GetMapping(value = "login")
    @ResponseBody
    public ResponseEntity<RespUsu> login(@RequestBody ReqLoginSCH reqlogin)
    {
    	Usuario usuario = new Usuario();
    	usuario = usuRep.findByEmail(reqlogin.getEmail());
    	if(usuario == null)
    	{
    		RespUsu respusu = new RespUsu();
    		respusu.RespValUsu(null, 505);
    		return new ResponseEntity<RespUsu>(respusu, HttpStatus.CONFLICT);
    	}
    	else
    	{
    		if (usuario.getSenusu().equals(reqlogin.getSenha()))
    		{
    			RespUsu respusu = new RespUsu();
        		respusu.RespValUsu(usuario, 0);
        		return new ResponseEntity<RespUsu>(respusu, HttpStatus.ACCEPTED);
    		}
    		else
    		{
    			RespUsu respusu = new RespUsu();
        		respusu.RespValUsu(null, 504);
        		System.out.println(usuario.getSenusu());
            	System.out.println(reqlogin.toString());
        		return new ResponseEntity<RespUsu>(respusu, HttpStatus.UNAUTHORIZED);
    		}
    	}
    }
    
//Endpoints de empresa
    @PostMapping(value = "postEmp")
    @ResponseBody
    public ResponseEntity<RespEmp> postEmp(@RequestBody Empresa empemp)
    {
    	try {
    		Empresa empresa = new Empresa();
    		empresa = empRep.findByCNPJ(empemp.getCnpjemp());
    		if(empresa != null)
    		{
    			RespEmp respemp = new RespEmp();
    			respemp.RespValEmp(null, 503);
    			return new ResponseEntity<RespEmp>(respemp, HttpStatus.CONFLICT);
    		}
    		else
    		{
    			empRep.save(empemp);
    			RespEmp respemp = new RespEmp();
    			respemp.RespValEmp(empemp, 0);
    			return new ResponseEntity<RespEmp>(respemp, HttpStatus.CREATED);
    		}
		} catch (Exception e) {
			RespEmp respemp = new RespEmp();
			respemp.RespValEmp(null, 500);
			return new ResponseEntity<RespEmp>(respemp, HttpStatus.CONFLICT);
		}
    }
    
    @PatchMapping(value = "patchEmp")
    @ResponseBody
    public ResponseEntity<RespEmp> patchEmp(@RequestBody Empresa empemp)
    {
    	try {
    		Empresa empresa = empRep.findByCNPJ(empemp.getCnpjemp());
    		CompleteEmp.complete(empemp, empresa);
    		empRep.save(empemp);
    		RespEmp respemp = new RespEmp();
    		respemp.RespValEmp(empemp, 0);
    		return new ResponseEntity<RespEmp>(respemp, HttpStatus.OK);
    	}catch(Exception e)
    	{
    		RespEmp respemp = new RespEmp();
    		respemp.RespValEmp(null, 500);
    		return new ResponseEntity<RespEmp>(respemp, HttpStatus.CONFLICT);
    	}
    }
    
    @DeleteMapping(value = "deleteEmp")
    @ResponseBody
    public ResponseEntity<String> deleteEmp(@RequestBody ReqEmpSCH reqemp)
    {
    	try {
    		usuRep.setCnpjempNull(reqemp.getCnpjemp());
    		empRep.deleteById(reqemp.getCnpjemp());
    		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
    	}catch(Exception e)
    	{
    		return new ResponseEntity<String>("Erro na deleção", HttpStatus.NOT_FOUND);
    	}
    }
    
    @GetMapping(value = "getEmp")
    @ResponseBody
    public ResponseEntity<ShowEmpSCH> getEmp(@RequestBody ReqEmpSCH reqemp)
    {
    	Empresa empresa = empRep.findByCNPJ(reqemp.getCnpjemp());
    	ShowEmpSCH showemp = new ShowEmpSCH();
    	showemp.Convert(empresa);
    	return new ResponseEntity<ShowEmpSCH>(showemp, HttpStatus.OK);
    }
    
//Endpoints de endereço
    @PostMapping(value = "postORpatchEnd")
    @ResponseBody
    public ResponseEntity<RespEnd> postORpatchEnd(@RequestBody Endereco reqend)
    {
		Endereco endereco = new Endereco();
		Usuario utmp = reqend.getCpfusu();
		Empresa etmp = reqend.getCnpjemp();
		if((utmp != null)||(etmp != null))
		{
			if(utmp != null)
			{
				endereco = endRep.findByCPF(utmp.getCpfusu());
			}
			else
			{
				endereco = endRep.findByCNPJ(etmp.getCnpjemp());
			}
			CompleteEnd.complete(reqend, endereco);
			endRep.save(endereco);
			RespEnd respend = new RespEnd();
			respend.RespValEnd(endereco, 0);
			return new ResponseEntity<RespEnd>(respend, HttpStatus.CREATED);
		}
		else
		{
			RespEnd respend = new RespEnd();
			respend.RespValEnd(null, 500);
			return new ResponseEntity<RespEnd>(respend, HttpStatus.BAD_REQUEST);
		}
    }
    
    
    @GetMapping(value = "getEnd")
    @ResponseBody
    public ResponseEntity<ShowEndSCH> getEnd(@RequestBody ReqEndSCH reqend)
    {
    	Endereco endereco = new Endereco();
    	if(reqend.getCpfusu() != 0)
    	{
    		endereco = endRep.findByCPF(reqend.getCpfusu());
    	}
    	else
    	{
    		endereco = endRep.findByCNPJ(reqend.getCnpjemp());
    	}
    	ShowEndSCH showend = new ShowEndSCH();
    	showend.Convert(endereco);
    	return new ResponseEntity<ShowEndSCH>(showend, HttpStatus.OK);
    }
    
//Endpoints de medico
    @PostMapping(value = "postMed")
    @ResponseBody
    public ResponseEntity<RespMed> postMed(@RequestBody Medico reqmed)
    {
		Medico medico = new Medico();
		medico = medRep.findByCRM(reqmed.getCrmmed());
		if(medico != null)
		{       
			RespMed respmed = new RespMed();
			respmed.RespValMed(null, 501);
			return new ResponseEntity<RespMed>(respmed, HttpStatus.CONFLICT);
		}
		else
		{
			medRep.save(medico);
			RespMed respmed =new RespMed();
			respmed.RespValMed(medico, 0);
			return new ResponseEntity<RespMed>(respmed, HttpStatus.CREATED);
		}
    }
    
    @DeleteMapping(value = "deleteMed")
    @ResponseBody
    public ResponseEntity<String> deleteMed(@RequestBody ReqMedSCH reqmed)
    {
    	try {
    		Medico medico = new Medico();
    		if(reqmed.getCrmmed() == null)
    		{
    			medico = medRep.findByCPF(reqmed.getCpfusu());
    		}
    		else
    		{
    			medico = medRep.findByCRM(reqmed.getCrmmed());
    		}
    		vacRep.setCrmNull(medico.getCrmmed());
    		medRep.deleteById(medico.getCrmmed());
    		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    		return new ResponseEntity<String>("Erro na deleção", HttpStatus.NOT_FOUND);
    	}
    }
    
    @GetMapping(value = "getMed")
    @ResponseBody
    public ResponseEntity<ShowMedSCH> getMed(@RequestBody ReqMedSCH reqmed)
    {
    	Medico medico = new Medico();
		if(reqmed.getCrmmed() == null)
		{
			medico = medRep.findByCPF(reqmed.getCpfusu());
		}
		else
		{
			medico = medRep.findByCRM(reqmed.getCrmmed());
		}
    	ShowMedSCH showmed = new ShowMedSCH();
    	showmed.Convert(medico);
    	return new ResponseEntity<ShowMedSCH>(showmed, HttpStatus.OK);
    }
    
//Endpoint de cidade
    @GetMapping(value = "getCid")
    @ResponseBody
    public ResponseEntity<ShowCidSCH> getCid(@RequestBody ReqCidSCH reqcid)
    {
    	Cidade cidade = cidRep.findByCodcid(reqcid.getCodcid());
    	ShowCidSCH showcid = new ShowCidSCH();
    	showcid.Convert(cidade);
    	return new ResponseEntity<ShowCidSCH>(showcid, HttpStatus.OK);
    }
    
    @GetMapping(value = "getEstCids")
    @ResponseBody
    public ResponseEntity<List<ShowCidSCH>> getCids(@RequestBody ReqCidSCH reqcid)
    {
    	List<Cidade> cidades = cidRep.findByCodest(reqcid.getCodest());
    	List<ShowCidSCH> listshowcid = new ArrayList<ShowCidSCH>();
    	for(Cidade ctmp : cidades)
    	{
    		ShowCidSCH sctmp = new ShowCidSCH();
    		sctmp.Convert(ctmp);
    		listshowcid.add(sctmp);
    	}
    	return new ResponseEntity<List<ShowCidSCH>>(listshowcid, HttpStatus.OK);
    }
    
    
//Endpoint de comorbidade
  	@GetMapping(value = "getCom")
  	@ResponseBody
  	public ResponseEntity<Comorbidade> getCom(@RequestBody ReqComSCH reqcom)
  	{
  		Comorbidade comorbidade = comRep.findByCodcom(reqcom.getCodcom());
  		return new ResponseEntity<Comorbidade>(comorbidade, HttpStatus.OK);
  	}
  	
  	@GetMapping(value = "getComs")
  	@ResponseBody
  	public ResponseEntity<List<Comorbidade>> getComs()
  	{
  		List<Comorbidade> comorbidades = comRep.findAllComs();
  		return new ResponseEntity<List<Comorbidade>>(comorbidades, HttpStatus.OK);
  	}
  	
//Endpoint de estado
  	@GetMapping(value = "getEst")
  	@ResponseBody
  	public ResponseEntity<ShowEstSCH> getEst(@RequestBody ReqEstSCH reqest)
  	{
  		Estado estado = estRep.findByCodest(reqest.getCodest());
  		ShowEstSCH showest = new ShowEstSCH();
  		showest.Convert(estado);
  		return new ResponseEntity<ShowEstSCH>(showest, HttpStatus.OK);
  	}
  	
  	@GetMapping(value = "getEsts")
  	@ResponseBody
  	public ResponseEntity<List<ShowEstSCH>> getEsts(@RequestBody ReqEstSCH reqest)
  	{
  		List<Estado> estados = estRep.findByCodpai(reqest.getCodpai());
  		List<ShowEstSCH> listshowest = new ArrayList<ShowEstSCH>();
    	for(Estado etmp : estados)
    	{
    		ShowEstSCH setmp = new ShowEstSCH();
    		setmp.Convert(etmp);
    		listshowest.add(setmp);
    	}
  		return new ResponseEntity<List<ShowEstSCH>>(listshowest, HttpStatus.OK);
  	}
  	
//Endpoint de monitoramento paciente
  	@PostMapping(value = "postMonPac")
  	@ResponseBody
  	public ResponseEntity<RespMonPac> postMomPac(@RequestBody MonitoramentoPaciente monpac)
  	{
		try {
			char intsin = monpac.getIntsin();
			if((intsin == 'P')||(intsin == 'M')||(intsin == 'C') || (intsin=='S'))
			{
				monPacRep.save(monpac);
				RespMonPac respmonpac = new RespMonPac();
				respmonpac.RespValMomPac(monpac, 0);
				return new ResponseEntity<RespMonPac>(respmonpac, HttpStatus.OK);
			}
			else
			{
				RespMonPac respmonpac = new RespMonPac();
				respmonpac.RespValMomPac(monpac, 501);
				return new ResponseEntity<RespMonPac>(respmonpac, HttpStatus.NOT_ACCEPTABLE);
			}
		}catch(Exception e)
		{
			RespMonPac respmonpac = new RespMonPac();
			respmonpac.RespValMomPac(monpac, 500);
			return new ResponseEntity<RespMonPac>(respmonpac, HttpStatus.INTERNAL_SERVER_ERROR);
		}
  	}
  	
  	@GetMapping(value = "getMonsPac")
  	@ResponseBody
  	public ResponseEntity<List<ShowMonPacSCH>> getMonsPac(@RequestBody ReqMonPacSCH reqmompac)
  	{
  		List<MonitoramentoPaciente> monitoramentos = monPacRep.findByCodpac(reqmompac.getCodpac());
  		List<ShowMonPacSCH> showmonspac = new ArrayList<ShowMonPacSCH>();
  		for (MonitoramentoPaciente mptmp: monitoramentos)
  		{
  			ShowMonPacSCH smptmp = new ShowMonPacSCH();
  			smptmp.Convert(mptmp);
  			showmonspac.add(smptmp);
  		}
  		return new ResponseEntity<List<ShowMonPacSCH>>(showmonspac, HttpStatus.OK);
  	}
  	
//Endpoints de paciente
  	
}



