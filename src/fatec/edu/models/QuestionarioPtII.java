package fatec.edu.models;

import java.util.Date;

public class QuestionarioPtII {
	private int id;

	private String idAtividade;
	private String idEmpresa;
	private Date dataAdmissao;
	private String idCargo;
	private double salario;
	private int idTomador;
	private String estabilidade;
	private boolean exercAtividade;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	
	public int getIdTomador() {
		return idTomador;
	}
	public void setIdTomador(int idTomador) {
		
		this.idTomador = idTomador;
	}
	public String getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(String idCargo) {
		this.idCargo = idCargo;
	}
	public String getIdAtividade() {
		return idAtividade;
	}
	public void setIdAtividade(String idAtividade) {
		this.idAtividade = idAtividade;
	}
	public String getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getEstabilidade() {
		return estabilidade;
	}
	public void setEstabilidade(String estabilidade) {
		this.estabilidade = estabilidade;
	}
	public boolean isExercAtividade() {
		return exercAtividade;
	}
	public void setExercAtividade(boolean exercAtividade) {
		this.exercAtividade = exercAtividade;
	}
	

}
