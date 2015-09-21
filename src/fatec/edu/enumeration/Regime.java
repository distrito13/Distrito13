package fatec.edu.enumeration;

public enum Regime {

	a("Comunhão Parcial de Bens"),
	b("Comunhão Universal de Bens"),
	c("Separação Total de Bens");

	private final String regimeCasamento;

	Regime(String regimeCasamento) {
		this.regimeCasamento = regimeCasamento;
	}

	@Override
	public String toString() {
		return regimeCasamento;
	}
}
