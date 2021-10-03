package pandemicstats.entidades;

public class Monitoramento_paciente {
	public int codmon;
	public String datmon;
	public char intsin;
	public Paciente codpac;
	public Sintoma codsin;
	
	public Monitoramento_paciente() {
	}

	public Monitoramento_paciente(int codmon, String datmon, char intsin, Paciente codpac, Sintoma codsin) {
		this.codmon = codmon;
		this.datmon = datmon;
		this.intsin = intsin;
		this.codpac = codpac;
		this.codsin = codsin;
	}

	public int getCodmon() {
		return codmon;
	}

	public void setCodmon(int codmon) {
		this.codmon = codmon;
	}

	public String getDatmon() {
		return datmon;
	}

	public void setDatmon(String datmon) {
		this.datmon = datmon;
	}

	public char getIntsin() {
		return intsin;
	}

	public void setIntsin(char intsin) {
		this.intsin = intsin;
	}

	public String getCodpac() {
		return codpac.getNompac();
	}

	public void setCodpac(Paciente codpac) {
		this.codpac = codpac;
	}

	public String getCodsin() {
		return codsin.getNomsin();
	}

	public void setCodsin(Sintoma codsin) {
		this.codsin = codsin;
	}

	
}
