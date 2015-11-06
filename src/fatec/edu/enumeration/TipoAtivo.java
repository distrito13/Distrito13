package fatec.edu.enumeration;

public enum TipoAtivo {

	Autom�vel("Autom�vel"), Im�vel("Im�vel"), Terreno("Terreno"),Outros("Outros");

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
