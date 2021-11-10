package br.edu.unoesc.pandemicstats.springboot.schemmas;

import java.sql.Date;

import br.edu.unoesc.pandemicstats.springboot.model.Empresa;
import br.edu.unoesc.pandemicstats.springboot.model.Usuario;
import lombok.Data;

@Data
public class ShowEmpSCH {

	private int cnpjemp;
	private String nomemp;
	private String nomfanemp;
	private String telemp1;
	private String telemp2;
	private String emaemp;
	private String ramo;
	private Date valemp;
	private int cpfusu;
	
	public void Convert(Empresa e)
	{
		this.cnpjemp = e.getCnpjemp();
		this.nomfanemp = e.getNomemp();
		this.nomemp = e.getNomemp();
		this.emaemp = e.getEmaemp();
		this.telemp1 = e.getTelemp1();
		this.telemp2 = e.getTelemp2();
		this.valemp = e.getValemp();
		this.ramo = e.getRamo();
		Usuario u = new Usuario();
		u = e.getCpfusu();
		if(u != null)
		{
			this.cpfusu = u.getCpfusu();
		}
	}
}

