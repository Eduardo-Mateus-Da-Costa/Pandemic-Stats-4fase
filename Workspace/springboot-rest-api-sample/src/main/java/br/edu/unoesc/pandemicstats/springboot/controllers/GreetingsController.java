package br.edu.unoesc.pandemicstats.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pandemicstats.springboot.enumeracoes.RamosEmp;
import br.edu.unoesc.pandemicstats.springboot.model.Ajuda;
import br.edu.unoesc.pandemicstats.springboot.model.Empresa;
import br.edu.unoesc.pandemicstats.springboot.repository.AjudaRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.EmpresaRepository;

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
	private EmpresaRepository empresaRepository;
	@Autowired
	private AjudaRepository ajudaRepository;
	
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Hello " + name + "!";
    }
    
	@RequestMapping(value = "/insert-empresa/{name}/{cnpj}/{nomfanemp}/teleemp1}/{teleemp2}/{emaemp}/{codaju}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String insertEmpresa(@PathVariable String nome, @PathVariable int cnpj, @PathVariable String nomfanemp, @PathVariable String telemp1, @PathVariable String telemp2, @PathVariable String emaemp, @PathVariable Ajuda codaju)
    {
    	Empresa empresa = new Empresa();
    	RamosEmp ramo = RamosEmp.CONTABILIDADE;
    	empresa.setCnpjemp(cnpj);
    	empresa.setCodaju(codaju);
    	empresa.setEmaemp(emaemp);
    	empresa.setNomemp(nome);
    	empresa.setNomfanemp(nomfanemp);
    	empresa.setRamo(ramo);
    	empresa.setTelemp1(telemp1);
    	empresa.setTelemp2(telemp2);
    	try {
			empresaRepository.save(empresa);
		} catch (Exception e) {
			e.printStackTrace();
    	}
    	return "Funfou";
    }
    
	@RequestMapping(value = "/insert-ajuda/{infaju}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String insertAjuda(@PathVariable String infaju)
    {
    	Ajuda ajuda = new Ajuda();
    	ajuda.setInfaju(infaju);
    
    	try {
			ajudaRepository.save(ajuda);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Funfou";
    }
}
