package br.edu.unoesc.pandemicstats.springboot.schemmas;

import lombok.Data;
/**
 * @author Eduardo Mateus Da Costa
 * @since 15/11/2021
 * @version 1.0
 */
@Data
public class PermisSCH {
	private boolean paciente;
	private boolean empresa;
	private boolean medico;
}
