package br.edu.unoesc.pandemicstats.springboot.schemmas;

import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 11/12/2021
 * @version 1.0
 * @see Endereco
 */
@Data
public class ReqEndSCH {
	private long codend;
	private long cpfusu;
	private long cnpjemp;
}
