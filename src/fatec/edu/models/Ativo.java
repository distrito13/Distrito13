package fatec.edu.models;

public class Ativo {

	private int idAtivo;
	private double valor;
	private String descricao;
	private String situacao;
	private int credor;

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getIdAtivo() {
		return idAtivo;
	}

	public void setIdAtivo(int idAtivo) {
		this.idAtivo = idAtivo;
	}

	public int getCredor() {
		return credor;
	}
	
	public void setCredor(int credor) {
		this.credor = credor;
	}

	

}
