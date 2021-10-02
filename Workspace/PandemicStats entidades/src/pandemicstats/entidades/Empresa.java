package pandemicstats.entidades;

import pandemicstats.enumeracoes.RamosEmp;

public class Empresa {
	public int codemp;
	public String nomemp;
	public int cnpjemp;
	public String nomfanemp;
	public String telemp1;
	public String telemp2;
	public String emaemp;
	public RamosEmp ramo;
	public Ajuda codaju;
	
	public Empresa() {
	}

	public Empresa(int codemp, String nomemp, int cnpjemp, String nomfanemp, String telemp1, String telemp2,
			String emaemp, RamosEmp ramo, Ajuda codaju) {
		this.codemp = codemp;
		this.nomemp = nomemp;
		this.cnpjemp = cnpjemp;
		this.nomfanemp = nomfanemp;
		this.telemp1 = telemp1;
		this.telemp2 = telemp2;
		this.emaemp = emaemp;
		this.ramo = ramo;
		this.codaju = codaju;
	}

	public int getCodemp() {
		return codemp;
	}

	public void setCodemp(int codemp) {
		this.codemp = codemp;
	}

	public String getNomemp() {
		return nomemp;
	}

	public void setNomemp(String nomemp) {
		this.nomemp = nomemp;
	}

	public int getCnpjemp() {
		return cnpjemp;
	}

	public void setCnpjemp(int cnpjemp) {
		this.cnpjemp = cnpjemp;
	}

	public String getNomfanemp() {
		return nomfanemp;
	}

	public void setNomfanemp(String nomfanemp) {
		this.nomfanemp = nomfanemp;
	}

	public String getTelemp1() {
		return telemp1;
	}

	public void setTelemp1(String telemp1) {
		this.telemp1 = telemp1;
	}

	public String getTelemp2() {
		return telemp2;
	}

	public void setTelemp2(String telemp2) {
		this.telemp2 = telemp2;
	}

	public String getEmaemp() {
		return emaemp;
	}

	public void setEmaemp(String emaemp) {
		this.emaemp = emaemp;
	}

	public String getRamo() {
		return ramo.getDescricao();
	}

	public void setRamo(RamosEmp ramo) {
		this.ramo = ramo;
	}

	public String getCodaju() {
		return codaju.getInfaju();
	}

	public void setCodaju(Ajuda codaju) {
		this.codaju = codaju;
	}

	@Override
	public String toString() {
		return "Empresa [codemp=" + codemp + ", nomemp=" + nomemp + ", cnpjemp=" + cnpjemp + ", nomfanemp=" + nomfanemp
				+ ", telemp1=" + telemp1 + ", telemp2=" + telemp2 + ", emaemp=" + emaemp + ", ramo=" + getRamo()
				+ ", codaju=" + getCodaju() + "]";
	}
	
	
}
