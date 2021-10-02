package pandemicstats.entidades;

public class Pais {
	public String nompai;
	public int codpai;
	
	public Pais() {
	}

	public Pais(String nompai, int codpai) {
		this.nompai = nompai;
		this.codpai = codpai;
	}
	
	public String getNompai() {
		return nompai;
	}
	public void setNompai(String nompai) {
		this.nompai = nompai;
	}
	public int getCodpai() {
		return codpai;
	}
	public void setCodpai(int codpai) {
		this.codpai = codpai;
	}

	@Override
	public String toString() {
		return "Pais [nompai=" + nompai + ", codpai=" + codpai + "]";
	}
	
}
