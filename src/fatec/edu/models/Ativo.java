package fatec.edu.models;

public class Ativo {

	private int idAtivo;
	private double valor;
	private String tipo;
	private String idTomador;

	public int getIdAtivo() {
		return idAtivo;
	}

	public void setIdAtivo(int idAtivo) {
		this.idAtivo = idAtivo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getIdTomador() {
		return idTomador;
	}

	public void setIdTomador(String idTomador) {
		this.idTomador = idTomador;
	}
}
