package br.edu.unoesc.pandemicstats.springboot.schemmas;

import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 12/11/2021
 * @version 1.0
 * @see Usuario
 */
@Data
public class ReqUsuSCH {
	private long cpfusu;
	private String emausu;
}
