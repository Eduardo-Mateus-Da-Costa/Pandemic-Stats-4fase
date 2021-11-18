package br.edu.unoesc.pandemicstats.springboot.schemmas;

import java.sql.Date;

import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 15/11/2021
 * @version 1.0
 */
@Data
public class EmpresaCovidSCH {
	private String nomusu;
	private char sexusu;
	private String nomcid;
	private Date dattes;
	private char covpactes;
}
