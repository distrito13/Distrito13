package fatec.edu.models;

public class Despesa {

	private int idDespesa;
	private double valor;
	private String tipoDespesa;
	private String periodo;
	private Credor credor;

	public void setCredor(Credor credor) {
		this.credor = credor;
	}

	public Credor getCredor() {
		return credor;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setTipoDespesa(String tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public String getTipoDespesa() {
		return tipoDespesa;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

	public void setIdDespesa(int idDespesa) {
		this.idDespesa = idDespesa;
	}

	public int getIdDespesa() {
		return idDespesa;
	}

}
