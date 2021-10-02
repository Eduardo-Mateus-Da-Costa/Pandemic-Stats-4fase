package pandemicstats.entidades;

public class Endereco_empresa {
	public int codendemp;
	public int cepemp;
	public String numemp;
	public String ruaemp;
	public Empresa codemp;
	public Cidade codcid;
	
	public Endereco_empresa() {
	}

	public Endereco_empresa(int codendemp, int cepemp, String numemp, String ruaemp, Empresa codemp, Cidade codcid) {
		this.codendemp = codendemp;
		this.cepemp = cepemp;
		this.numemp = numemp;
		this.ruaemp = ruaemp;
		this.codemp = codemp;
		this.codcid = codcid;
	}

	public int getCodendemp() {
		return codendemp;
	}

	public void setCodendemp(int codendemp) {
		this.codendemp = codendemp;
	}

	public int getCepemp() {
		return cepemp;
	}

	public void setCepemp(int cepemp) {
		this.cepemp = cepemp;
	}

	public String getNumemp() {
		return numemp;
	}

	public void setNumemp(String numemp) {
		this.numemp = numemp;
	}

	public String getRuaemp() {
		return ruaemp;
	}

	public void setRuaemp(String ruaemp) {
		this.ruaemp = ruaemp;
	}

	public String getCodemp() {
		return codemp.getNomemp();
	}

	public void setCodemp(Empresa codemp) {
		this.codemp = codemp;
	}

	public String getCodcid() {
		return codcid.getNomcid();
	}

	public void setCodcid(Cidade codcid) {
		this.codcid = codcid;
	}

	@Override
	public String toString() {
		return "Endereco_empresa [codendemp=" + codendemp + ", cepemp=" + cepemp + ", numemp=" + numemp + ", ruaemp="
				+ ruaemp + ", getCodemp()=" + codemp.getCodemp() + ", getCodcid()=" + codcid.getCodcid() + "]";
	}
	
	

}
