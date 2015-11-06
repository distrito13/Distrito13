package fatec.edu.enumeration;

public enum Escolaridade {

	a("Ensino fundamental I Incompleto"), 
	b("Ensino fundamental II incompleto"), 
	c("Ensino fundamental completo"), 
	d("Ensino Medio incompleto"), 
	e("Ensino medio completo"), 
	f("Tecnico completo"), 
	g("Ensino superior incompleto"), 
	h("Ensino superior completo"), 
	i("Mestrado e Doutorado");

	private String escolaridade;

	public String getEscolaridade() {
		return escolaridade;
	}

	Escolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	@Override
	public String toString() {
		return getEscolaridade();
	}

}
