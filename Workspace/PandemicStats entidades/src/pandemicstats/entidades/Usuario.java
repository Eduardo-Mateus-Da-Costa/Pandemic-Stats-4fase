package pandemicstats.entidades;

public class Usuario {
	public int codusu;
	public String nomusu;
	public String logusu;
	public String senusu;
	public char tipusu;
	public Empresa codemp;
	public Paciente codpac;
	
	public Usuario() {
	}

	public Usuario(int codusu, String nomusu, String logusu, String senusu, char tipusu, Empresa codemp,
			Paciente codpac) {
		this.codusu = codusu;
		this.nomusu = nomusu;
		this.logusu = logusu;
		this.senusu = senusu;
		this.tipusu = tipusu;
		this.codemp = codemp;
		this.codpac = codpac;
	}

	public int getCodusu() {
		return codusu;
	}

	public void setCodusu(int codusu) {
		this.codusu = codusu;
	}

	public String getNomusu() {
		return nomusu;
	}

	public void setNomusu(String nomusu) {
		this.nomusu = nomusu;
	}

	public String getLogusu() {
		return logusu;
	}

	public void setLogusu(String logusu) {
		this.logusu = logusu;
	}

	public String getSenusu() {
		return senusu;
	}

	public void setSenusu(String senusu) {
		this.senusu = senusu;
	}

	public char getTipusu() {
		return tipusu;
	}

	public void setTipusu(char tipusu) {
		this.tipusu = tipusu;
	}

	public String getCodemp() {
		return codemp.getNomemp();
	}

	public void setCodemp(Empresa codemp) {
		this.codemp = codemp;
	}

	public String getCodpac() {
		return codpac.getNompac();
	}

	public void setCodpac(Paciente codpac) {
		this.codpac = codpac;
	}

	@Override
	public String toString() {
		return "Usuario [codusu=" + codusu + ", nomusu=" + nomusu + ", logusu=" + logusu + ", senusu=" + senusu
				+ ", tipusu=" + tipusu + ", getCodemp()=" + getCodemp() + ", getCodpac()=" + getCodpac() + "]";
	}
}
