package fatec.edu.enumeration;

public enum Regime {

	a("Comunh�o Parcial de Bens"),
	b("Comunh�o Universal de Bens"),
	c("Separa��o Total de Bens");

	private final String regimeCasamento;

	Regime(String regimeCasamento) {
		this.regimeCasamento = regimeCasamento;
	}

	@Override
	public String toString() {
		return regimeCasamento;
	}
}
