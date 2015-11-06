package fatec.edu.enumeration;

public enum Periodo {

	Anual("Anual"), Semestral("Semestral"), Mensal("Mensal"), Diário("Diário"), Bimestral("Bimestral"), Trimestral("Trimestral");

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