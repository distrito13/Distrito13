package fatec.edu.models;

import java.sql.Date;

public class ExercAtividade {

	private int idExercAtividade;
	private int carteiraTrabalho;
	private Atividade_vaisair atividade;
	private Empresa_vaisair empresa;
	private Date dataAdmissao;
	private Cargo_vaisair cargo;
	private double salario;
	private Tomador tomador;

	public void setTomador(Tomador tomador) {
		this.tomador = tomador;
	}

	public Tomador getTomador() {
		return tomador;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getSalario() {
		return salario;
	}

	public void setCargo(Cargo_vaisair cargo) {
		this.cargo = cargo;
	}

	public Cargo_vaisair getCargo() {
		return cargo;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setEmpresa(Empresa_vaisair empresa) {
		this.empresa = empresa;
	}

	public Empresa_vaisair getEmpresa() {
		return empresa;
	}

	public void setAtividade(Atividade_vaisair atividade) {
		this.atividade = atividade;
	}

	public Atividade_vaisair getAtividade() {
		return atividade;
	}

	public void setCarteiraTrabalho(int carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

	public int getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setIdExercAtividade(int idExercAtividade) {
		this.idExercAtividade = idExercAtividade;
	}

	public int getIdExercAtividade() {
		return idExercAtividade;
	}

}
