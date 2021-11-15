package br.edu.unoesc.pandemicstats.springboot.schemmas;

import lombok.Data;

@Data
public class PermisSCH {
	private boolean paciente;
	private boolean empresa;
	private boolean medico;
}
