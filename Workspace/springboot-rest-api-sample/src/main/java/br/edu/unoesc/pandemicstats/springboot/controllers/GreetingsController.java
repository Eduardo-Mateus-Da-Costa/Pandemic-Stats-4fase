package br.edu.unoesc.pandemicstats.springboot.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pandemicstats.springboot.model.Usuario;
import br.edu.unoesc.pandemicstats.springboot.repository.CidadeRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.ComorbidadeRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.EmpresaRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.Endereco_usuarioRepository;
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
import br.edu.unoesc.pandemicstats.springboot.responses.ResponseGeral;
import br.edu.unoesc.pandemicstats.springboot.schemmas.UsuarioSCH;
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
	Endereco_usuarioRepository endUsuRep;
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
	
	
    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Hello " + name + "!";
    }
    
    
    @PostMapping(value = "postUsu")
    @ResponseBody
    public ResponseEntity<ResponseGeral> postUsu(@RequestBody Usuario usu)
    {
    	try {
    		usuRep.save(usu);
    		ResponseGeral rg = new ResponseGeral();
    		rg.RespValUsu(usu, 0);
    		return new ResponseEntity<ResponseGeral>(rg, HttpStatus.CREATED);
		} catch (Exception e) {
			ResponseGeral rg = new ResponseGeral();
			rg.RespValUsu(usu, 500);
			return new ResponseEntity<ResponseGeral>(rg, HttpStatus.CONFLICT);
		}
    }
    
    @DeleteMapping(value = "deleteUsu")
    @ResponseBody
    public ResponseEntity<String> deleteUsu(@RequestParam(name ="cpfusu") int cpfusu)
    {
    	usuRep.deleteById(cpfusu);
    	return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
    }
    
    @GetMapping(value = "getUsu")
    @ResponseBody
    public ResponseEntity<UsuarioSCH>getUsu(@RequestParam(name ="cpfusu") int cpfusu)
    {
    	Usuario u = usuRep.findById(cpfusu).get();
    	UsuarioSCH user = new UsuarioSCH();
    	user.Convert(u);
    	return new ResponseEntity<UsuarioSCH>(user, HttpStatus.OK);
    }
    
    
    
}
