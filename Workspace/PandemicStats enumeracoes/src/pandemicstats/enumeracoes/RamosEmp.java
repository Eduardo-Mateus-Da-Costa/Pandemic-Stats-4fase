package pandemicstats.enumeracoes;

public enum RamosEmp {
	VENDA(1,"Venda"),
	SEGUROS(2,"Seguros"),
	CONTABILIDADE(3,"Contabilidade"),
	SERVIÇOSGERAIS(4,"Serviços gerais"),
	OUTRO(5,"Outro");
	
	private int valor;
	private String descricao;
	
	private RamosEmp(int valor, String descricao) {
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
