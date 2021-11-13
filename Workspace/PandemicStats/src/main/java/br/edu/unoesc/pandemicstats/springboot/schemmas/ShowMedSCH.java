package br.edu.unoesc.pandemicstats.springboot.schemmas;


import br.edu.unoesc.pandemicstats.springboot.model.Medico;
import br.edu.unoesc.pandemicstats.springboot.model.Usuario;
import lombok.Data;

@Data
public class ShowMedSCH {
	private String crmmed;
	private long cpfusu;
	private String nomusu;
	
	public void Convert(Medico m)
	{
		this.crmmed = m.getCrmmed();
		Usuario u = new Usuario();
		u = m.getCpfusu();
		if(u != null)
		{
			this.cpfusu = u.getCpfusu();
			this.nomusu = u.getNomusu();
		}
	}
}
