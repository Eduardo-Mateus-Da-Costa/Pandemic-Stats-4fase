package pandemicstats.entidades;

public class Endereco_paciente {
	public int codendpac;
	public int ceppac;
	public String ruapac;
	public String numpac;
	public Paciente codpac;
	public Cidade codcid;
	
	public Endereco_paciente() {
	}

	public Endereco_paciente(int codendpac, int ceppac, String ruapac, String numpac, Paciente codpac, Cidade codcid) {
		this.codendpac = codendpac;
		this.ceppac = ceppac;
		this.ruapac = ruapac;
		this.numpac = numpac;
		this.codpac = codpac;
		this.codcid = codcid;
	}

	public int getCodendpac() {
		return codendpac;
	}

	public void setCodendpac(int codendpac) {
		this.codendpac = codendpac;
	}

	public int getCeppac() {
		return ceppac;
	}

	public void setCeppac(int ceppac) {
		this.ceppac = ceppac;
	}

	public String getRuapac() {
		return ruapac;
	}

	public void setRuapac(String ruapac) {
		this.ruapac = ruapac;
	}

	public String getNumpac() {
		return numpac;
	}

	public void setNumpac(String numpac) {
		this.numpac = numpac;
	}

	public String getCodpac() {
		return codpac.getNompac();
	}

	public void setCodpac(Paciente codpac) {
		this.codpac = codpac;
	}

	public String getCodcid() {
		return codcid.getNomcid();
	}

	public void setCodcid(Cidade codcid) {
		this.codcid = codcid;
	}

	@Override
	public String toString() {
		return "Endereco_paciente [codendpac=" + codendpac + ", ceppac=" + ceppac + ", ruapac=" + ruapac + ", numpac="
				+ numpac + ", getCodpac()=" + getCodpac() + ", getCodcid()=" + getCodcid() + "]";
	}

	
}
