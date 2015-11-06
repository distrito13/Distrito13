package fatec.edu.enumeration;

public enum TipoDivida {

	a("Cartão de Crédito"), b("Aluguel Atrasado"), c("Compra de Imóvel Atrasado");

	private final String tipoDivida;

	TipoDivida(String tipoDivida) {
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
