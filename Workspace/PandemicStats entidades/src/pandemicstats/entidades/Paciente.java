package pandemicstats.entidades;

public class Paciente {
	public int codpac;
	public String nompac;
	public int cpfpac;
	public String datnaspac;
	public double pespac;
	public String telpac1;
	public String telpac2;
	public char grurispac;
	public char sexpac;
	public String sitpac;
	public Empresa codemp;
	public Tipo_funcionario codfun;
	
	public Paciente() {
	}
	
	public Paciente(int codpac, String nompac, int cpfpac, String datnaspac, double pespac, String telpac1,
			String telpac2, char grurispac, char sexpac, String sitpac, Empresa codemp, Tipo_funcionario codfun) {
		this.codpac = codpac;
		this.nompac = nompac;
		this.cpfpac = cpfpac;
		this.datnaspac = datnaspac;
		this.pespac = pespac;
		this.telpac1 = telpac1;
		this.telpac2 = telpac2;
		this.grurispac = grurispac;
		this.sexpac = sexpac;
		this.sitpac = sitpac;
		this.codemp = codemp;
		this.codfun = codfun;
	}

	public int getCodpac() {
		return codpac;
	}

	public void setCodpac(int codpac) {
		this.codpac = codpac;
	}

	public String getNompac() {
		return nompac;
	}

	public void setNompac(String nompac) {
		this.nompac = nompac;
	}

	public int getCpfpac() {
		return cpfpac;
	}

	public void setCpfpac(int cpfpac) {
		this.cpfpac = cpfpac;
	}

	public String getDatnaspac() {
		return datnaspac;
	}

	public void setDatnaspac(String datnaspac) {
		this.datnaspac = datnaspac;
	}

	public double getPespac() {
		return pespac;
	}

	public void setPespac(double pespac) {
		this.pespac = pespac;
	}

	public String getTelpac1() {
		return telpac1;
	}

	public void setTelpac1(String telpac1) {
		this.telpac1 = telpac1;
	}

	public String getTelpac2() {
		return telpac2;
	}

	public void setTelpac2(String telpac2) {
		this.telpac2 = telpac2;
	}

	public char getGrurispac() {
		return grurispac;
	}

	public void setGrurispac(char grurispac) {
		this.grurispac = grurispac;
	}

	public char getSexpac() {
		return sexpac;
	}

	public void setSexpac(char sexpac) {
		this.sexpac = sexpac;
	}

	public String getSitpac() {
		return sitpac;
	}

	public void setSitpac(String sitpac) {
		this.sitpac = sitpac;
	}

	public String getCodemp() {
		return codemp.getNomemp();
	}

	public void setCodemp(Empresa codemp) {
		this.codemp = codemp;
	}

	public String getCodfun() {
		return codfun.getTipfun();
	}

	public void setCodfun(Tipo_funcionario codfun) {
		this.codfun = codfun;
	}

	@Override
	public String toString() {
		return "Paciente [codpac=" + codpac + ", nompac=" + nompac + ", cpfpac=" + cpfpac + ", datnaspac=" + datnaspac
				+ ", pespac=" + pespac + ", telpac1=" + telpac1 + ", telpac2=" + telpac2 + ", grurispac=" + grurispac
				+ ", sexpac=" + sexpac + ", sitpac=" + sitpac + ", getCodemp()=" + getCodemp() + ", getCodfun()="
				+ getCodfun() + "]";
	}

	
	
	

}
