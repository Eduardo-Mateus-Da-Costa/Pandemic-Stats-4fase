package br.edu.unoesc.pandemicstats.springboot.schemmas;

import java.sql.Date;

import br.edu.unoesc.pandemicstats.springboot.model.Cidade;
import br.edu.unoesc.pandemicstats.springboot.model.Empresa;
import br.edu.unoesc.pandemicstats.springboot.model.Usuario;
import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 09/11/2021
 * @version 1.0
 * @see Empresa
 */
@Data
public class ShowEmpSCH {

	private long cnpjemp;
	private String nomemp;
	private String nomfanemp;
	private String telemp1;
	private String telemp2;
	private String emaemp;
	private String ramemp;
	private Date valemp;
	private long cpfusu;
	private long cep;
	private String rua;
	private String num;
	private long codcid;
	
	/**
	 * @param Empresa empresa
	 * @see Usuario
	 * @see Cidade
	 */
	public void Convert(Empresa empresa)
	{
		this.cnpjemp = empresa.getCnpjemp();
		this.nomfanemp = empresa.getNomfanemp();
		this.nomemp = empresa.getNomemp();
		this.emaemp = empresa.getEmaemp();
		this.telemp1 = empresa.getTelemp1();
		this.telemp2 = empresa.getTelemp2();
		this.valemp = empresa.getValemp();
		this.ramemp = empresa.getRamemp();
		this.cep = empresa.getCep();
		this.num = empresa.getNum();
		this.rua = empresa.getRua();
		Cidade cidade = empresa.getCodcid();
		Usuario usuario = new Usuario();
		usuario = empresa.getCpfusu();
		if(usuario != null)
		{
			this.cpfusu = usuario.getCpfusu();
		}
		if(cidade != null)
		{
			this.codcid = cidade.getCodcid();
		}
	}
}

