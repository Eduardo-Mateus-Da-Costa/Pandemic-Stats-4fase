package br.edu.unoesc.pandemicstats.springboot.schemmas;

import java.sql.Date;

import br.edu.unoesc.pandemicstats.springboot.model.Cidade;
import br.edu.unoesc.pandemicstats.springboot.model.Empresa;
import br.edu.unoesc.pandemicstats.springboot.model.Usuario;
import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 09/11/2021
 * @version 1.2
 * @see Usuario
 */
@Data
public class ShowUsuSCH {
	private long cpfusu;
	private String nomusu;
	private Date datnasusu;	
	private String emausu;
	private char sexusu;
	private String telusu;
	private long cnpjemp;
	private long codcid;
	private String rua;
	private long cep;
	private String num;
	
	/**
	 * @param Usuario usuario
	 * @see Empresa
	 * @see Cidade
	 */
	public void Convert(Usuario usuario)
	{
		this.cpfusu = usuario.getCpfusu();
		this.nomusu = usuario.getNomusu();
		this.datnasusu = usuario.getDatnasusu();
		this.emausu = usuario.getEmausu();
		this.sexusu = usuario.getSexusu();
		this.telusu = usuario.getTelusu();
		this.cep = usuario.getCep();
		this.rua = usuario.getRua();
		this.num = usuario.getNum();
		Cidade cidade = usuario.getCodcid();
		Empresa empresa = new Empresa();
		empresa = usuario.getCnpjemp();
		if(empresa != null)
		{
			this.cnpjemp = empresa.getCnpjemp();
		}
		if(cidade != null)
		{
			this.codcid = cidade.getCodcid();
		}
	}
}
