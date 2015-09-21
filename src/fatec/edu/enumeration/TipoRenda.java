package fatec.edu.enumeration;

public enum TipoRenda {

	a("Bolsa ou aux�lio do governo"), b("Pens�o Aliment�cia"), c("Im�vel Alugado");

	private final String tipoRenda;

	TipoRenda(String tipoRenda) {
		this.tipoRenda = tipoRenda;
	}

	public String getTipoRenda() {
		return tipoRenda;
	}

	@Override
	public String toString() {
		return getTipoRenda();
	}

}