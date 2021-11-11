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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pandemicstats.springboot.model.Cidade;
import br.edu.unoesc.pandemicstats.springboot.model.Empresa;
import br.edu.unoesc.pandemicstats.springboot.model.Endereco;
import br.edu.unoesc.pandemicstats.springboot.model.Medico;
import br.edu.unoesc.pandemicstats.springboot.model.Usuario;
import br.edu.unoesc.pandemicstats.springboot.repository.CidadeRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.ComorbidadeRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.EmpresaRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.EnderecoRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.EstadoRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.MedicoRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.Monitoramento_pacienteRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.PacienteRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.Paciente_comorbidadeRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.PaisRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.SintomaRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.SolicitacaoRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.Test_covidRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.UsuarioRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.VacinaRepository;
import br.edu.unoesc.pandemicstats.springboot.responses.RespEmp;
import br.edu.unoesc.pandemicstats.springboot.responses.RespEnd;
import br.edu.unoesc.pandemicstats.springboot.responses.RespMed;
import br.edu.unoesc.pandemicstats.springboot.responses.RespUsu;
import br.edu.unoesc.pandemicstats.springboot.schemmas.LoginSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ReqCidSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ReqEmp;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ReqEndSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ReqMedSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ReqUsu;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowCidSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowEmpSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowEndSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowMedSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowUsuSCH;
import br.edu.unoesc.pandemicstats.springboot.utils.ConvertEmp;
import br.edu.unoesc.pandemicstats.springboot.utils.ConvertEnd;
import br.edu.unoesc.pandemicstats.springboot.utils.ConvertUsu;
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
	Monitoramento_pacienteRepository monPacRep;
	@Autowired
	Paciente_comorbidadeRepository pacComRep;
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
    public ResponseEntity<RespUsu> postUsu(@RequestBody Usuario usu)
    {
    	try {
    		Usuario val_u = new Usuario();
    		val_u = usuRep.findByCPF(usu.getCpfusu());
    		if(val_u != null)
    		{
    			RespUsu rg = new RespUsu();
    			rg.RespValUsu(null, 503);
    			return new ResponseEntity<RespUsu>(rg, HttpStatus.CONFLICT);
    		}
    		else
    		{
    			usuRep.save(usu);
    			RespUsu rg = new RespUsu();
    			rg.RespValUsu(usu, 0);
    			return new ResponseEntity<RespUsu>(rg, HttpStatus.CREATED);
    		}
		} catch (Exception e) {
			RespUsu rg = new RespUsu();
			rg.RespValUsu(null, 500);
			return new ResponseEntity<RespUsu>(rg, HttpStatus.CONFLICT);
		}
    }
    
    @PatchMapping(value = "patchUsu")
    @ResponseBody
    public ResponseEntity<RespUsu> patchUsu(@RequestBody Usuario usu)
    {
    	try {
    		Usuario u = usuRep.findByCPF(usu.getCpfusu());
    		ConvertUsu.complete(usu, u);
    		usuRep.save(usu);
    		RespUsu rg = new RespUsu();
    		rg.RespValUsu(usu, 0);
    		return new ResponseEntity<RespUsu>(rg, HttpStatus.OK);
    	}catch(Exception e)
    	{
    		RespUsu rg = new RespUsu();
    		rg.RespValUsu(null, 500);
    		return new ResponseEntity<RespUsu>(rg, HttpStatus.CONFLICT);
    	}
    }
    
    
    @DeleteMapping(value = "deleteUsu")
    @ResponseBody
    public ResponseEntity<String> deleteUsu(@RequestBody ReqUsu usu)
    {
    	try {
    		Usuario u = new Usuario();
    		if(usu.getEmausu() != null)
    		{
    			u = usuRep.findByEmail(usu.getEmausu());
    		}
    		else
    		{
    			u = usuRep.findByCPF(usu.getCpfusu());
    		}
    		
    		Empresa e = empRep.findByCpfusu(u.getCpfusu());
    		if(e !=null)
    		{
    			usuRep.setCnpjempNull(e.getCnpjemp());
    		}
    		
    		Endereco end = endRep.findByCPF(u.getCpfusu());
    		Empresa e_end = end.getCnpjemp();
    		if((end.getCnpjemp() != null)&&(e_end.getCnpjemp() != e.getCnpjemp()))
    		{ 
    			endRep.setCpfusuNull(end.getCodend());
    		}
    		else
    		{
    			endRep.deleteById(end.getCodend());
    		}
    		
    		usuRep.deleteById(u.getCpfusu());
    		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
    	}catch(Exception e)
    	{
    		return new ResponseEntity<String>("Erro na deleção", HttpStatus.NOT_FOUND);
    	}
    }
    
    @GetMapping(value = "getUsu")
    @ResponseBody
    public ResponseEntity<ShowUsuSCH>getUsu(@RequestBody ReqUsu usu)
    {
    	Usuario u = new Usuario();
    	if (usu.getEmausu() != null)
    	{
    		u = usuRep.findByEmail(usu.getEmausu());
    	}
    	else
    	{
    		u = usuRep.findByCPF(usu.getCpfusu());
    	}
    	ShowUsuSCH user = new ShowUsuSCH();
    	user.Convert(u);
    	return new ResponseEntity<ShowUsuSCH>(user, HttpStatus.OK);
    }
    
    @GetMapping(value = "login")
    @ResponseBody
    public ResponseEntity<RespUsu> login(@RequestBody LoginSCH login)
    {
    	Usuario u = new Usuario();
    	u = usuRep.findByEmail(login.getEmail());
    	if(u == null)
    	{
    		RespUsu rg = new RespUsu();
    		rg.RespValUsu(null, 505);
    		return new ResponseEntity<RespUsu>(rg, HttpStatus.CONFLICT);
    	}
    	else
    	{
    		if (u.getSenusu().equals(login.getSenha()))
    		{
    			RespUsu rg = new RespUsu();
        		rg.RespValUsu(u, 0);
        		return new ResponseEntity<RespUsu>(rg, HttpStatus.ACCEPTED);
    		}
    		else
    		{
    			RespUsu rg = new RespUsu();
        		rg.RespValUsu(null, 504);
        		System.out.println(u.getSenusu());
            	System.out.println(login.toString());
        		return new ResponseEntity<RespUsu>(rg, HttpStatus.UNAUTHORIZED);
    		}
    	}
    }
    
//Endpoints de empresa
    @PostMapping(value = "postEmp")
    @ResponseBody
    public ResponseEntity<RespEmp> postEmp(@RequestBody Empresa emp)
    {
    	try {
    		Empresa val_e = new Empresa();
    		val_e = empRep.findByCNPJ(emp.getCnpjemp());
    		if(val_e != null)
    		{
    			RespEmp re = new RespEmp();
    			re.RespValEmp(null, 503);
    			return new ResponseEntity<RespEmp>(re, HttpStatus.CONFLICT);
    		}
    		else
    		{
    			empRep.save(emp);
    			RespEmp re = new RespEmp();
    			re.RespValEmp(emp, 0);
    			return new ResponseEntity<RespEmp>(re, HttpStatus.CREATED);
    		}
		} catch (Exception e) {
			RespEmp re = new RespEmp();
			re.RespValEmp(null, 500);
			return new ResponseEntity<RespEmp>(re, HttpStatus.CONFLICT);
		}
    }
    
    @PatchMapping(value = "patchEmp")
    @ResponseBody
    public ResponseEntity<RespEmp> patchEmp(@RequestBody Empresa emp)
    {
    	try {
    		Empresa e = empRep.findByCNPJ(emp.getCnpjemp());
    		ConvertEmp.complete(emp, e);
    		empRep.save(emp);
    		RespEmp re = new RespEmp();
    		re.RespValEmp(emp, 0);
    		return new ResponseEntity<RespEmp>(re, HttpStatus.OK);
    	}catch(Exception e)
    	{
    		RespEmp re = new RespEmp();
    		re.RespValEmp(null, 500);
    		return new ResponseEntity<RespEmp>(re, HttpStatus.CONFLICT);
    	}
    }
    
    @DeleteMapping(value = "deleteEmp")
    @ResponseBody
    public ResponseEntity<String> deleteEmp(@RequestBody ReqEmp emp)
    {
    	try {
    		usuRep.setCnpjempNull(emp.getCnpjemp());
    		empRep.deleteById(emp.getCnpjemp());
    		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    		return new ResponseEntity<String>("Erro na deleção", HttpStatus.NOT_FOUND);
    	}
    }
    
    @GetMapping(value = "getEmp")
    @ResponseBody
    public ResponseEntity<ShowEmpSCH> getEmp(@RequestParam(name ="cnpjemp") int cnpjemp)
    {
    	Empresa e = empRep.findById(cnpjemp).get();
    	ShowEmpSCH se = new ShowEmpSCH();
    	se.Convert(e);
    	return new ResponseEntity<ShowEmpSCH>(se, HttpStatus.OK);
    }
    
//Endpoints de endereço
    @PostMapping(value = "postORpatchEnd")
    @ResponseBody
    public ResponseEntity<RespEnd> postORpatchEnd(@RequestBody Endereco end)
    {
		Endereco val_end = new Endereco();
		Usuario u_tmp = end.getCpfusu();
		Empresa e_tmp = end.getCnpjemp();
		if((u_tmp != null)||(e_tmp != null))
		{
			if(u_tmp != null)
			{
				val_end = endRep.findByCPF(u_tmp.getCpfusu());
			}
			else
			{
				val_end = endRep.findByCNPJ(e_tmp.getCnpjemp());
			}
			ConvertEnd.complete(end, val_end);
			endRep.save(val_end);
			RespEnd re = new RespEnd();
			re.RespValEnd(val_end, 0);
			return new ResponseEntity<RespEnd>(re, HttpStatus.CREATED);
		}
		else
		{
			RespEnd re = new RespEnd();
			re.RespValEnd(null, 500);
			return new ResponseEntity<RespEnd>(re, HttpStatus.BAD_REQUEST);
		}
    }
    
    
    @GetMapping(value = "getEnd")
    @ResponseBody
    public ResponseEntity<ShowEndSCH> getEnd(@RequestBody ReqEndSCH end)
    {
    	Endereco e = new Endereco();
    	if(end.getCpfusu() != 0)
    	{
    		e = endRep.findByCPF(end.getCpfusu());
    	}
    	else
    	{
    		e = endRep.findByCNPJ(end.getCnpjemp());
    	}
    	ShowEndSCH se = new ShowEndSCH();
    	se.Convert(e);
    	return new ResponseEntity<ShowEndSCH>(se, HttpStatus.OK);
    }
    
//Endpoints de medico
    @PostMapping(value = "postMed")
    @ResponseBody
    public ResponseEntity<RespMed> postMed(@RequestBody Medico med)
    {
		Medico val_m = new Medico();
		val_m = medRep.findByCRM(med.getCrmmed());
		if(val_m != null)
		{       
			RespMed rm = new RespMed();
			rm.RespValMed(null, 501);
			return new ResponseEntity<RespMed>(rm, HttpStatus.CONFLICT);
		}
		else
		{
			medRep.save(med);
			RespMed rm =new RespMed();
			rm.RespValMed(med, 0);
			return new ResponseEntity<RespMed>(rm, HttpStatus.CREATED);
		}
    }
    
    @DeleteMapping(value = "deleteMed")
    @ResponseBody
    public ResponseEntity<String> deleteMed(@RequestBody ReqMedSCH med)
    {
    	try {
    		Medico m = new Medico();
    		if(med.getCrmmed() == null)
    		{
    			m = medRep.findByCPF(med.getCpfusu());
    		}
    		else
    		{
    			m = medRep.findByCRM(med.getCrmmed());
    		}
    		vacRep.setCrmNull(m.getCrmmed());
    		medRep.deleteById(m.getCrmmed());
    		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    		return new ResponseEntity<String>("Erro na deleção", HttpStatus.NOT_FOUND);
    	}
    }
    
    @GetMapping(value = "getMed")
    @ResponseBody
    public ResponseEntity<ShowMedSCH> getMed(@RequestBody ReqMedSCH med)
    {
    	Medico m = new Medico();
		if(med.getCrmmed() == null)
		{
			m = medRep.findByCPF(med.getCpfusu());
		}
		else
		{
			m = medRep.findByCRM(med.getCrmmed());
		}
    	ShowMedSCH sm = new ShowMedSCH();
    	sm.Convert(m);
    	return new ResponseEntity<ShowMedSCH>(sm, HttpStatus.OK);
    }
    
//Endpoint de cidade
    @GetMapping(value = "getCid")
    @ResponseBody
    public ResponseEntity<ShowCidSCH> getCid(@RequestBody ReqCidSCH cid)
    {
    	Cidade c = cidRep.findByCodcid(cid.getCodcid());
    	ShowCidSCH sc = new ShowCidSCH();
    	sc.Convert(c);
    	return new ResponseEntity<ShowCidSCH>(sc, HttpStatus.OK);
    }
    
    @GetMapping(value = "getEstCids")
    @ResponseBody
    public ResponseEntity<List<ShowCidSCH>> getCids(@RequestBody ReqCidSCH cid)
    {
    	List<Cidade> c = cidRep.findByCodest(cid.getCodest());
    	List<ShowCidSCH> sc = new ArrayList<ShowCidSCH>();
    	for(Cidade c_tmp : c)
    	{
    		ShowCidSCH sc_tmp = new ShowCidSCH();
    		sc_tmp.Convert(c_tmp);
    		sc.add(sc_tmp);
    	}
    	return new ResponseEntity<List<ShowCidSCH>>(sc, HttpStatus.OK);
    }
}

