package br.edu.unoesc.pandemicstats.springboot.schemmas;

import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 09/11/2021
 * @version 1.0
 * @see Empresa
 */
@Data
public class ReqEmpSCH {
	private long cnpjemp;
	private long cpfusu;
}
