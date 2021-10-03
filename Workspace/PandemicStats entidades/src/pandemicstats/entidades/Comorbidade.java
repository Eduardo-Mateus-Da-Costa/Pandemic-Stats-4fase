package pandemicstats.entidades;

import pandemicstats.enumeracoes.ListaComo;

public class Comorbidade {
	public int codcom;
	public ListaComo com;
	
	public Comorbidade() {
	}

	public Comorbidade(int codcom, ListaComo com) {
		this.codcom = codcom;
		this.com = com;
	}

	public int getCodcom() {
		return codcom;
	}

	public void setCodcom(int codcom) {
		this.codcom = codcom;
	}

	public String getCom() {
		return com.getDescricao();
	}

	public void setCom(ListaComo com) {
		this.com = com;
	}

	@Override
	public String toString() {
		return "Comorbidade [codcom=" + codcom + ", getCom()=" + getCom() + "]";
	}
	
	
}
