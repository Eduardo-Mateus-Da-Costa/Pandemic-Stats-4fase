package br.edu.unoesc.pandemicstats.springboot.schemmas;

import lombok.Data;

@Data
public class ReqLoginSCH {
	private String email;
	private String senha;
}
