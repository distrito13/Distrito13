package fatec.edu.enumeration;

public enum Estabilidade {
	
	a("Aut�nomo"), b("Funcion�rio de Empresa privada"), c("Funcion�rio do setor P�blico");
	
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
