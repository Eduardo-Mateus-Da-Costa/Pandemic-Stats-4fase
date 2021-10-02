package pandemicstats.entidades;

public class Estado{
	public int codest;
	public String nomest;
	public Pais codpai;
	
	public Estado() {
	}

	public Estado(int codest, String nomest, Pais codpai) {
		this.codest = codest;
		this.nomest = nomest;
		this.codpai = codpai;
	}

	
	public int getCodest() {
		return codest;
	}

	public void setCodest(int codest) {
		this.codest = codest;
	}

	public String getNomest() {
		return nomest;
	}

	public void setNomest(String nomest) {
		this.nomest = nomest;
	}

	public String getCodpai() {
		return codpai.getNompai();
	}

	public void setCodpai(Pais codpai) {
		this.codpai = codpai;
	}

	@Override
	public String toString() {
		return "Estado [codest=" + codest + ", nomest=" + nomest + ", pais=" + codpai.getCodpai() + "]";
	}
	
}
