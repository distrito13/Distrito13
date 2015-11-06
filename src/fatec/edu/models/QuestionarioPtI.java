package fatec.edu.models;

import java.util.Date;

public class QuestionarioPtI {

	private int id;
	private String cpf;
	private String nome;
	private Date data;
	private String filiacaoI;
	private String filiacaoII;
	private int sexo;
	private String estadoCivil;
	private String regimeCasamento;

	private int idEstado;
	private String cidade;
	private String escolaridade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getFiliacaoI() {
		return filiacaoI;
	}

	public void setFiliacaoI(String filiacaoI) {
		this.filiacaoI = filiacaoI;
	}

	public String getFiliacaoII() {
		return filiacaoII;
	}

	public void setFiliacaoII(String filiacaoII) {
		this.filiacaoII = filiacaoII;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}



	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getRegimeCasamento() {
		return regimeCasamento;
	}

	public void setRegimeCasamento(String regimeCasamento) {
		this.regimeCasamento = regimeCasamento;
	}

	


}
