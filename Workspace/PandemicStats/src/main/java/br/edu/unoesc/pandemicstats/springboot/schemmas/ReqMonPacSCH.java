package br.edu.unoesc.pandemicstats.springboot.schemmas;

import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 11/12/2021
 * @version 1.0
 * @see MonitoramentoPaciente
 */
@Data
public class ReqMonPacSCH {
	private long codmon;
	private long codpac;
}
