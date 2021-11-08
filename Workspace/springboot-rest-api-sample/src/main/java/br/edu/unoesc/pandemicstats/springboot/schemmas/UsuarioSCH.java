package br.edu.unoesc.pandemicstats.springboot.schemmas;

import java.sql.Date;

import br.edu.unoesc.pandemicstats.springboot.model.Usuario;
import lombok.Data;

@Data
public class UsuarioSCH {
	private int cpfusu;
	private String nomusu;
	private Date datnasusu;	
	private String emausu;
	
	public void Convert(Usuario u)
	{
		this.cpfusu = u.getCpfusu();
		this.nomusu = u.getNomusu();
		this.datnasusu = u.getDatnasusu();
		this.emausu = u.getEmausu();
	}
}
