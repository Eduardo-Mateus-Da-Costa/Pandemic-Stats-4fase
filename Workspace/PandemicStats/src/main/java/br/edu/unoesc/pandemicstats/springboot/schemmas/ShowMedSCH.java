package br.edu.unoesc.pandemicstats.springboot.schemmas;


import br.edu.unoesc.pandemicstats.springboot.model.Medico;
import br.edu.unoesc.pandemicstats.springboot.model.Usuario;
import lombok.Data;

@Data
public class ShowMedSCH {
	private String crmmed;
	private long cpfusu;
	private String nomusu;
	
	public void Convert(Medico medico)
	{
		this.crmmed = medico.getCrmmed();
		Usuario usuario = new Usuario();
		usuario = medico.getCpfusu();
		if(usuario != null)
		{
			this.cpfusu = usuario.getCpfusu();
			this.nomusu = usuario.getNomusu();
		}
	}
}
