package pandemicstats.entidades;

public class Medico {
	public int codmed;
	public String nommed;
	public String crmmed;
	public int cpfmed;
	
	public Medico() {
	}

	public Medico(int codmed, String nommed, String crmmed, int cpfmed) {
		this.codmed = codmed;
		this.nommed = nommed;
		this.crmmed = crmmed;
		this.cpfmed = cpfmed;
	}

	public int getCodmed() {
		return codmed;
	}

	public void setCodmed(int codmed) {
		this.codmed = codmed;
	}

	public String getNommed() {
		return nommed;
	}

	public void setNommed(String nommed) {
		this.nommed = nommed;
	}

	public String getCrmmed() {
		return crmmed;
	}

	public void setCrmmed(String crmmed) {
		this.crmmed = crmmed;
	}

	public int getCpfmed() {
		return cpfmed;
	}

	public void setCpfmed(int cpfmed) {
		this.cpfmed = cpfmed;
	}

	@Override
	public String toString() {
		return "Medico [codmed=" + codmed + ", nommed=" + nommed + ", crmmed=" + crmmed + ", cpfmed=" + cpfmed + "]";
	}
	
}
