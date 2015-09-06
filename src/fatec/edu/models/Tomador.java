package fatec.edu.models;

import java.sql.Date;

public class Tomador {

	private int idTomador;
	private String cpf;
	private String nome;
	private Date dataNasc;
	private String filiacaoResp1;
	private String filiacaoResp2;
	private Sexo sexo;
	private String estadoCivil;
	private String regimeCasamento;
	private Estado estado;
	private Cidade cidade;

	public void setIdTomador(int idTomador) {
		this.idTomador = idTomador;
	}

	public int getIdTomador() {
		return idTomador;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setFiliacaoResp1(String filiacaoResp1) {
		this.filiacaoResp1 = filiacaoResp1;
	}

	public String getFiliacaoResp1() {
		return filiacaoResp1;
	}

	public void setFiliacaoResp2(String filiacaoResp2) {
		this.filiacaoResp2 = filiacaoResp2;
	}

	public String getFiliacaoResp2() {
		return filiacaoResp2;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setRegimeCasamento(String regimeCasamento) {
		this.regimeCasamento = regimeCasamento;
	}

	public String getRegimeCasamento() {
		return regimeCasamento;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Cidade getCidade() {
		return cidade;
	}

}
