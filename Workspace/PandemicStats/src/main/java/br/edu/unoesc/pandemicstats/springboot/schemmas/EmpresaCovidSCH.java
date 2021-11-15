package br.edu.unoesc.pandemicstats.springboot.schemmas;

import java.sql.Date;

import lombok.Data;

@Data
public class EmpresaCovidSCH {
	private String nomusu;
	private char sexusu;
	private String nomcid;
	private Date dattes;
	private char covpactes;
}
