package br.edu.unoesc.pandemicstats.springboot.schemmas;

import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 11/11/2021
 * @version 1.0
 * @see Usuario
 */
@Data
public class ReqLoginSCH {
	private String email;
	private String senha;
}
