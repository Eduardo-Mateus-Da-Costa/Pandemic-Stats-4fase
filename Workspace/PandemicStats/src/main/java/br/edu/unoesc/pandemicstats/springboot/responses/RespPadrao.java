package br.edu.unoesc.pandemicstats.springboot.responses;

import lombok.Data;

@Data
public abstract class RespPadrao {
	protected String s;
	protected int Httpstatus;
}
