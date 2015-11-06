package fatec.edu.enumeration;

public enum TipoAtivo {

	Automóvel("Automóvel"), Imóvel("Imóvel"), Terreno("Terreno"),Outros("Outros");

	private final String tipoDivida;

	TipoAtivo(String tipoDivida) {
		this.tipoDivida = tipoDivida;
	}

	public String getTipoDivida() {
		return tipoDivida;
	}

	@Override
	public String toString() {
		return getTipoDivida();
	}

}
