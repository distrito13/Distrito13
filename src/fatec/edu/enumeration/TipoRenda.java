package fatec.edu.enumeration;

public enum TipoRenda {

	a("Bolsa ou auxílio do governo"), b("Pensão Alimentícia"), c("Imóvel Alugado");

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