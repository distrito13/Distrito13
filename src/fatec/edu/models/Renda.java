package fatec.edu.models;

public class Renda {

	private int idRenda;
	private double valor;
	private String tipoRenda;
	private String periodo;
	private Tomador tomador;

	public void setTomador(Tomador tomador) {
		this.tomador = tomador;
	}

	public Tomador getTomador() {
		return tomador;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setTipoRenda(String tipoRenda) {
		this.tipoRenda = tipoRenda;
	}

	public String getTipoRenda() {
		return tipoRenda;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

	public void setIdRenda(int idRenda) {
		this.idRenda = idRenda;
	}

	public int getIdRenda() {
		return idRenda;
	}
}
