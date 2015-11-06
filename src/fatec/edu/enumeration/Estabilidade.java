package fatec.edu.enumeration;

public enum Estabilidade {
	
	a("Autônomo"), b("Funcionário de Empresa privada"), c("Funcionário do setor Público");
	
	private final String estabilidade;
	
	Estabilidade(String estabilidade){
		this.estabilidade = estabilidade;		
	}

	public String getEstabilidade() {
		return estabilidade;
	}
	
	@Override
	public String toString(){
		return getEstabilidade();
	}
}
