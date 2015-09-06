package fatec.edu.models;

public class Cidade {

	private int idCidade;
	private String cidade;
	private Estado estado;

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}

	public int getIdCidade() {
		return idCidade;
	}

}
