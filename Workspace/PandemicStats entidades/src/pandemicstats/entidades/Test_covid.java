package pandemicstats.entidades;

public class Test_covid {
	public int codtes;
	public char covpactes;
	public Paciente codpac;
	
	public Test_covid() {
	}

	public Test_covid(int codtes, char covpactes, Paciente codpac) {
		this.codtes = codtes;
		this.covpactes = covpactes;
		this.codpac = codpac;
	}

	public int getCodtes() {
		return codtes;
	}

	public void setCodtes(int codtes) {
		this.codtes = codtes;
	}

	public char getCovpactes() {
		return covpactes;
	}

	public void setCovpactes(char covpactes) {
		this.covpactes = covpactes;
	}

	public String getCodpac() {
		return codpac.getNompac();
	}

	public void setCodpac(Paciente codpac) {
		this.codpac = codpac;
	}
	
	
}
