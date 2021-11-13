package br.edu.unoesc.pandemicstats.springboot.schemmas;

import java.sql.Date;

import br.edu.unoesc.pandemicstats.springboot.model.Empresa;
import br.edu.unoesc.pandemicstats.springboot.model.Usuario;
import lombok.Data;

@Data
public class ShowUsuSCH {
	private long cpfusu;
	private String nomusu;
	private Date datnasusu;	
	private String emausu;
	private char sexusu;
	private String telusu;
	private long cnpjemp;
	
	public void Convert(Usuario u)
	{
		this.cpfusu = u.getCpfusu();
		this.nomusu = u.getNomusu();
		this.datnasusu = u.getDatnasusu();
		this.emausu = u.getEmausu();
		this.sexusu = u.getSexusu();
		this.telusu = u.getTelusu();
		Empresa e = new Empresa();
		e = u.getCnpjemp();
		if(e != null)
		{
			this.cnpjemp = e.getCnpjemp();
		}
	}
}
