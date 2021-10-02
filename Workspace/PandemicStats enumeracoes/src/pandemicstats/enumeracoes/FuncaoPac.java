package pandemicstats.enumeracoes;

public enum FuncaoPac {
	FAXINEIRO(1, "Faxineiro"),
	CONTADOR(2,"Contador");
	
	private int valor;
	private String descricao;
	
	private FuncaoPac(int valor, String descricao) {
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
