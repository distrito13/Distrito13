package fatec.edu.models;

public class QuestionarioPtIII {
	private int id;
	private double valor;
	private String tipoRenda;
	private String periodo;
	private int idTomador;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTipoRenda() {
		return tipoRenda;
	}
	public void setTipoRenda(String tipoRenda) {
		this.tipoRenda = tipoRenda;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public int getIdTomador() {
		return idTomador;
	}
	public void setIdTomador(int idTomador) {
		this.idTomador = idTomador;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	

}
