package fatec.edu.enumeration;

public enum TipoDivida {

	a("Cart�o de Cr�dito"), b("Aluguel Atrasado"), c("Compra de Im�vel Atrasado");

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
