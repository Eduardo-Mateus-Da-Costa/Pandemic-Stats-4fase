package pandemicstats.entidades;

public class Paciente_Comorbidade {
	public Paciente codpac;
	public Comorbidade codcom;
	
	public Paciente_Comorbidade() {
	}

	public Paciente_Comorbidade(Paciente codpac, Comorbidade codcom) {
		this.codpac = codpac;
		this.codcom = codcom;
	}

	public String getCodpac() {
		return codpac.getNompac();
	}

	public void setCodpac(Paciente codpac) {
		this.codpac = codpac;
	}

	public String getCodcom() {
		return codcom.getCom();
	}

	public void setCodcom(Comorbidade codcom) {
		this.codcom = codcom;
	}

	@Override
	public String toString() {
		return "Paciente_Comorbidade [getCodpac()=" + getCodpac() + ", getCodcom()=" + getCodcom() + "]";
	}
}
