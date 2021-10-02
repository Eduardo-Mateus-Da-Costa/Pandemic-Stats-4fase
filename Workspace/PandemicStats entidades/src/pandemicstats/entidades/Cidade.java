package pandemicstats.entidades;

public class Cidade {
	public int codcid;
	public String nomcid;
	public Estado codest;
	
	public Cidade() {
	}

	public Cidade(int codcid, String nomcid, Estado codest) {
		this.codcid = codcid;
		this.nomcid = nomcid;
		this.codest = codest;
	}

	public int getCodcid() {
		return codcid;
	}

	public void setCodcid(int codcid) {
		this.codcid = codcid;
	}

	public String getNomcid() {
		return nomcid;
	}

	public void setNomcid(String nomcid) {
		this.nomcid = nomcid;
	}

	public String getCodest() {
		return codest.getNomest();
	}

	public void setCodest(Estado codest) {
		this.codest = codest;
	}

	@Override
	public String toString() {
		return "Cidade [codcid=" + codcid + ", nomcid=" + nomcid + ", getCodest()=" + codest.getCodest() + "]";
	}
	
	
	
}
