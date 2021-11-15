package br.edu.unoesc.pandemicstats.springboot.schemmas;

import java.sql.Date;

import lombok.Data;

@Data
public class CidadeCovidSCH {
	private String nomusu;
	private char sexusu;
	private String nomemp;
	private Date dattes;
	private char covpactes;
}
