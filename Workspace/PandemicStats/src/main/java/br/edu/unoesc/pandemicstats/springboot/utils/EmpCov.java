package br.edu.unoesc.pandemicstats.springboot.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.unoesc.pandemicstats.springboot.repository.CidadeRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.EmpresaRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.PacienteRepository;
import br.edu.unoesc.pandemicstats.springboot.repository.UsuarioRepository;
import br.unoesc.pandemicstats.springboot.data.model.TipoEmpCov;
public class EmpCov {
	
	@Autowired
	EmpresaRepository empRep;
	
	@Autowired
	UsuarioRepository usuRep;
	
	@Autowired
	PacienteRepository pacRep;
	
	@Autowired
	CidadeRepository cidRep;
	
	public static List<TipoEmpCov> EmpresaCovid(long cnpjemp)
	{
		List<TipoEmpCov> lista = new ArrayList<TipoEmpCov>();
		
		return lista;
	}
}
