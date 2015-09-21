package fatec.edu.enumeration;

public enum RegimeCasamento {

	a("Comunh�o Parcial de Bens"), b("Comunh�o Universal de Bens"), c("Separa��o Total de Bens");

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