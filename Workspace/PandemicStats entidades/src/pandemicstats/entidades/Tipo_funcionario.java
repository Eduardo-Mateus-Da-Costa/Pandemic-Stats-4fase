package pandemicstats.entidades;

import pandemicstats.enumeracoes.FuncaoPac;

public class Tipo_funcionario {
	public int codfun;
	public FuncaoPac tipfun;
	public String desfun;
	
	public Tipo_funcionario(int codfun, FuncaoPac tipfun, String desfun) {
		this.codfun = codfun;
		this.tipfun = tipfun;
		this.desfun = desfun;
	}

	public int getCodfun() {
		return codfun;
	}

	public void setCodfun(int codfun) {
		this.codfun = codfun;
	}

	public String getTipfun() {
		return tipfun.getDescricao();
	}

	public void setTipfun(FuncaoPac tipfun) {
		this.tipfun = tipfun;
	}

	public String getDesfun() {
		return desfun;
	}

	public void setDesfun(String desfun) {
		this.desfun = desfun;
	}

	@Override
	public String toString() {
		return "Tipo_funcionario [codfun=" + codfun + ", desfun=" + desfun + ", getTipfun()=" + getTipfun() + "]";
	}
	
	
}
