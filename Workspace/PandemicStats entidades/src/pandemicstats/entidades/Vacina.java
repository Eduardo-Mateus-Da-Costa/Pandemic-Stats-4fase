package pandemicstats.entidades;

public class Vacina {
	public int codvac;
	public String datvac;
	public char dosvac;
	public String fabvac;
	public Paciente codpac;
	public Medico codmed;
	
	public Vacina() {
	}
	
	
	public Vacina(int codvac, String datvac, char dosvac, String fabvac, Paciente codpac, Medico codmed) {
		this.codvac = codvac;
		this.datvac = datvac;
		this.dosvac = dosvac;
		this.fabvac = fabvac;
		this.codpac = codpac;
		this.codmed = codmed;
	}


	public int getCodvac() {
		return codvac;
	}


	public void setCodvac(int codvac) {
		this.codvac = codvac;
	}


	public String getDatvac() {
		return datvac;
	}


	public void setDatvac(String datvac) {
		this.datvac = datvac;
	}


	public char getDosvac() {
		return dosvac;
	}


	public void setDosvac(char dosvac) {
		this.dosvac = dosvac;
	}


	public String getFabvac() {
		return fabvac;
	}


	public void setFabvac(String fabvac) {
		this.fabvac = fabvac;
	}


	public Paciente getCodpac() {
		return codpac;
	}


	public void setCodpac(Paciente codpac) {
		this.codpac = codpac;
	}


	public Medico getCodmed() {
		return codmed;
	}


	public void setCodmed(Medico codmed) {
		this.codmed = codmed;
	}


	@Override
	public String toString() {
		return "Vacina [codvac=" + codvac + ", datvac=" + datvac + ", dosvac=" + dosvac + ", fabvac=" + fabvac
				+ ", codpac=" + codpac + ", codmed=" + codmed + "]";
	}
}
