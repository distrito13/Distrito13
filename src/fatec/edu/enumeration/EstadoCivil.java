package fatec.edu.enumeration;

public enum EstadoCivil {

	SOLTEIRO("Solteiro"), CASADO("Casado"), SEPARADO("Separado"), DIVORCIADO("Divorciado"), VIUVO("Viúvo");

	private final String estadoCivil;

	EstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	@Override
	public String toString() {
		return getEstadoCivil();
	}

}
