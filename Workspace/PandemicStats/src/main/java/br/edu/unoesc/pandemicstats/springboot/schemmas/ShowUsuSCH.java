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
	
	public void Convert(Usuario usuario)
	{
		this.cpfusu = usuario.getCpfusu();
		this.nomusu = usuario.getNomusu();
		this.datnasusu = usuario.getDatnasusu();
		this.emausu = usuario.getEmausu();
		this.sexusu = usuario.getSexusu();
		this.telusu = usuario.getTelusu();
		Empresa empresa = new Empresa();
		empresa = usuario.getCnpjemp();
		if(empresa != null)
		{
			this.cnpjemp = empresa.getCnpjemp();
		}
	}
}
