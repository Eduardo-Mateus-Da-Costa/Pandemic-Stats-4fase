package br.edu.unoesc.pandemicstats.springboot.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.unoesc.pandemicstats.springboot.repository.EmpresaRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.PacienteRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.UsuarioRepository;
import br.unoesc.pandemicstats.springboot.data.model.TipoCidCov;

public class CidCov {
	
	@Autowired
	EmpresaRepository empRep;
	
	@Autowired
	UsuarioRepository usuRep;
	
	@Autowired
	PacienteRepository pacRep;
	
	public static List<TipoCidCov> CidadeCovid(long cnpjemp)
	{
		List<TipoCidCov> lista = new ArrayList<TipoCidCov>();
		
		return lista;
	}
}
