package pandemicstats.enumeracoes;

public enum ListaComo {
	OBESIDADE(1,"Obesidade"),
	DOENCACARDIACA(2,"Doença cardíaca"),
	IDOSO(3,"Idoso"),
	DOENCARESPIRATORIA(4,"Doenca respiratória"),
	OUTRO(5,"Outro");
	
	private int valor;
	private String descricao;
	
	private ListaComo(int valor, String descricao) {
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
