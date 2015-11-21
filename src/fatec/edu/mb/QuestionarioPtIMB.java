package fatec.edu.mb;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import fatec.edu.dao.implementation.crud.EstadoDAOImpl;
import fatec.edu.dao.implementation.crud.QuestionarioPtIDAOImpl;
import fatec.edu.dao.implementation.crud.SexoDAOImpl;
import fatec.edu.dao.interfaces.crud.EstadoDAO;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIDAO;
import fatec.edu.dao.interfaces.crud.SexoDAO;
import fatec.edu.enumeration.Escolaridade;
import fatec.edu.enumeration.EstadoCivil;
import fatec.edu.enumeration.RegimeCasamento;
import fatec.edu.models.Estado;
import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.Sexo;
import fatec.edu.verificarExistencia.ValidaExistenciaDAO;
import fatec.edu.verificarExistencia.ValidaExistenciaDAOImpl;

@ManagedBean
@SessionScoped

public class QuestionarioPtIMB implements Serializable {

	private static final long serialVersionUID = -9157355034999009316L;
	private QuestionarioPtI questionarioPtIAtual;
	private QuestionarioPtIDAO questionarioPtIDAO;
	private List<Sexo> sexos;
	private List<Estado> estados;
	private SexoDAO sexoDAO;
	private EstadoDAO estadoDAO;
	private SelectItem[] regimeCasamento;
	private SelectItem[] escolaridade;

	private List regimesCasamento;
	private List estadosCivil;
	private List escolaridades;

	private ValidaExistenciaDAO validaExistenciaDAO;

	public QuestionarioPtIMB() {
		questionarioPtIAtual = new QuestionarioPtI();
		questionarioPtIDAO = new QuestionarioPtIDAOImpl();
		sexoDAO = new SexoDAOImpl();
		estadoDAO = new EstadoDAOImpl();
		validaExistenciaDAO = new ValidaExistenciaDAOImpl();

		try {
			setSexos(sexoDAO.pesquisar());
			setEstados(estadoDAO.pesquisar());

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@PostConstruct
	public void init() {
		regimesCasamento = Arrays.asList(RegimeCasamento.values());
		estadosCivil = Arrays.asList(EstadoCivil.values());
		escolaridades = Arrays.asList(Escolaridade.values());

	}

	public String adicionar() {
		try {

			boolean existencia = validaExistenciaDAO.verificaExistenciaCpf(questionarioPtIAtual.getCpf());
			if (existencia) {
				FacesContext fc = FacesContext.getCurrentInstance();
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cpf já cadastrado", null);
				fc.addMessage("", msg);
			} else {

				questionarioPtIDAO.manter(getQuestionarioPtIAtual());
				FacesContext fc = FacesContext.getCurrentInstance();
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tomador atualizado com sucesso", null);
				fc.addMessage("", msg);
				questionarioPtIAtual = new QuestionarioPtI();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir", null);
			fc.addMessage("", msg);
		}
		return "";
	}

	public QuestionarioPtIDAO getQuestionarioPtIDAO() {
		return questionarioPtIDAO;
	}

	public void setQuestionarioPtIDAO(QuestionarioPtIDAO questionarioPtIDAO) {
		this.questionarioPtIDAO = questionarioPtIDAO;
	}

	public QuestionarioPtI getQuestionarioPtIAtual() {
		return questionarioPtIAtual;
	}

	public void setQuestionarioPtIAtual(QuestionarioPtI questionarioPtIAtual) {
		this.questionarioPtIAtual = questionarioPtIAtual;
	}

	public List<Sexo> getSexos() {
		return sexos;
	}

	public void setSexos(List<Sexo> sexos) {
		this.sexos = sexos;
	}

	public SexoDAO getSexoDAO() {
		return sexoDAO;
	}

	public void setSexoDAO(SexoDAO sexoDAO) {
		this.sexoDAO = sexoDAO;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public EstadoDAO getEstadoDAO() {
		return estadoDAO;
	}

	public void setEstadoDAO(EstadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}

	public SelectItem[] getRegimeCasamento() {
		SelectItem[] items = new SelectItem[RegimeCasamento.values().length];
		int i = 0;
		for (RegimeCasamento regime : RegimeCasamento.values()) {
			items[i++] = new SelectItem(regime, regime.name());
		}
		return items;

	}

	public void setRegimeCasamento(SelectItem[] regimeCasamento) {
		this.regimeCasamento = regimeCasamento;
	}

	public List getRegimesCasamento() {
		return regimesCasamento;
	}

	public void setRegimesCasamento(List regimesCasamento) {
		this.regimesCasamento = regimesCasamento;
	}

	public List getEstadosCivil() {
		return estadosCivil;
	}

	public void setEstadosCivil(List estadosCivil) {
		this.estadosCivil = estadosCivil;
	}

	public List getEscolaridades() {
		return escolaridades;
	}

	public void setEscolaridades(List escolaridades) {
		this.escolaridades = escolaridades;
	}

	public SelectItem[] getEscolaridade() {
		SelectItem[] items = new SelectItem[Escolaridade.values().length];
		int i = 0;
		for (Escolaridade escolaridade : Escolaridade.values()) {
			items[i++] = new SelectItem(escolaridade, escolaridade.name());
		}
		return items;

	}

	public void setEscolaridade(SelectItem[] escolaridade) {
		this.escolaridade = escolaridade;
	}

}
