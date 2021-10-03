package pandemicstats.enumeracoes;

public enum ListaSint {
	TOSSE(1,"Tosse"),
	CORIZA(2,"Coriza"),
	FEBRE(3,"Febre"),
	CALAFRIOS(4,"Calafrios"),
	OUTRO(5,"Outro");
	
	private int valor;
	private String descricao;
	
	private ListaSint(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public int getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}
}
