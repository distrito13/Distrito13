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
	private int estadoCivil;
	private int RegimeCasamento;
	private String idEstado;
	private String idCidade;
	
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
	public int getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(int estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public int getRegimeCasamento() {
		return RegimeCasamento;
	}
	public void setRegimeCasamento(int regimeCasamento) {
		RegimeCasamento = regimeCasamento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}
	public String getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(String idCidade) {
		this.idCidade = idCidade;
	}

	
	
	
}
