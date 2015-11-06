package fatec.edu.models;

import java.util.Date;

public class Avaliacao {
	private int idAvaliacao;
	private  int idTomador;
	private  int idCredor;
	private double valorEmprestimo;
	private double scoreExerceAtividade ;
	private double scoreRenda ;
	private double scoreDivida ;
	private double scorePendencia;
	//NEW
	private double scoreAtivo;
	private double scoreTomador;
	private double scoreFinal;
	private Date dataAvaliação ;
	
	public int getIdAvaliacao() {
		return idAvaliacao;
	}
	public void setIdAvaliacao(int idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}
	public int getIdTomador() {
		return idTomador;
	}
	public void setIdTomador(int idTomador) {
		this.idTomador = idTomador;
	}
	public int getIdCredor() {
		return idCredor;
	}
	public void setIdCredor(int idCredor) {
		this.idCredor = idCredor;
	}
	public double getValorEmprestimo() {
		return valorEmprestimo;
	}
	public void setValorEmprestimo(double valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}
	public double getScoreExerceAtividade() {
		return scoreExerceAtividade;
	}
	public void setScoreExerceAtividade(double scoreExerceAtividade) {
		this.scoreExerceAtividade = scoreExerceAtividade;
	}
	public double getScoreRenda() {
		return scoreRenda;
	}
	public void setScoreRenda(double scoreRenda) {
		this.scoreRenda = scoreRenda;
	}
	public double getScoreDivida() {
		return scoreDivida;
	}
	public void setScoreDivida(double scoreDivida) {
		this.scoreDivida = scoreDivida;
	}
	public double getScorePendencia() {
		return scorePendencia;
	}
	public void setScorePendencia(double scorePendencia) {
		this.scorePendencia = scorePendencia;
	}
	public double getScoreAtivo() {
		return scoreAtivo;
	}
	public void setScoreAtivo(double scoreAtivo) {
		this.scoreAtivo = scoreAtivo;
	}
	public double getScoreTomador() {
		return scoreTomador;
	}
	public void setScoreTomador(double scoreTomador) {
		this.scoreTomador = scoreTomador;
	}
	public double getScoreFinal() {
		return scoreFinal;
	}
	public void setScoreFinal(double scoreFinal) {
		this.scoreFinal = scoreFinal;
	}
	public Date getDataAvaliação() {
		return dataAvaliação;
	}
	public void setDataAvaliação(Date dataAvaliação) {
		this.dataAvaliação = dataAvaliação;
	}
	
	
	
	
	

}
