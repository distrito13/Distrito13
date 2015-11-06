package fatec.edu.models;

public class QuestionarioPtIV {
	private int id;
	private double valor;
	private String tipoDivida;
	private int idTomador;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTipoDivida() {
		return tipoDivida;
	}
	public void setTipoDivida(String tipoDivida) {
		this.tipoDivida = tipoDivida;
	}
	public int getIdTomador() {
		return idTomador;
	}
	public void setIdTomador(int idTomador) {
		this.idTomador = idTomador;
	}
	
	public double getValor(){
		return valor;
	}
	
	public void setValor(double valor){
		this.valor = valor;
	}
	
}
