package pandemicstats.entidades;

import pandemicstats.enumeracoes.ListaSint;

public class Sintoma {
	public int codsin;
	public ListaSint nomsin;
	public String dessin;
	
	public Sintoma() {
	}

	public Sintoma(int codsin, ListaSint nomsin, String dessin) {
		this.codsin = codsin;
		this.nomsin = nomsin;
		this.dessin = dessin;
	}

	public int getCodsin() {
		return codsin;
	}

	public void setCodsin(int codsin) {
		this.codsin = codsin;
	}

	public String getNomsin() {
		return nomsin.getDescricao();
	}

	public void setNomsin(ListaSint nomsin) {
		this.nomsin = nomsin;
	}

	public String getDessin() {
		return dessin;
	}

	public void setDessin(String dessin) {
		this.dessin = dessin;
	}

	@Override
	public String toString() {
		return "Sintoma [codsin=" + codsin + ", dessin=" + dessin + ", getNomsin()=" + getNomsin() + "]";
	}
	
	
}
