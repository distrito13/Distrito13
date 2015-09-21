package fatec.edu.enumeration;

public enum RegimeCasamento {

	a("Comunhão Parcial de Bens"), b("Comunhão Universal de Bens"), c("Separação Total de Bens");

	private final String regimeCasamento;

	RegimeCasamento(String regimeCasamento) {
		this.regimeCasamento = regimeCasamento;
	}

	public String getRegimeCasamento() {
		return regimeCasamento;
	}

	@Override
	public String toString() {
		return getRegimeCasamento();
	}

}