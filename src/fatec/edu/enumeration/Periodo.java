package fatec.edu.enumeration;

public enum Periodo {

	a("Anual"), b("Semestral"), c("Mensal"), d("Diário"), e("Bimestral"), f("Trimestral");

	private final String periodo;

	Periodo(String periodo) {
		this.periodo = periodo;
	}

	public String getPeriodo() {
		return periodo;
	}

	@Override
	public String toString() {
		return getPeriodo();
	}

}
