package pandemicstats.entidades;

public class Ajuda {
	public int codaju;
	public String infaju;
	
	public Ajuda() {
		super();
	}

	public Ajuda(int codaju, String infaju) {
		this.codaju = codaju;
		this.infaju = infaju;
	}

	public int getCodaju() {
		return codaju;
	}

	public void setCodaju(int codaju) {
		this.codaju = codaju;
	}

	public String getInfaju() {
		return infaju;
	}

	public void setInfaju(String infaju) {
		this.infaju = infaju;
	}

	@Override
	public String toString() {
		return "Ajuda [codaju=" + codaju + ", infaju=" + infaju + "]";
	}
	
}
