package fatec.edu.mb;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import fatec.edu.dao.implementation.crud.QuestionarioPtIIIDAOImpl;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIIIDAO;
import fatec.edu.enumeration.Periodo;
import fatec.edu.enumeration.RegimeCasamento;
import fatec.edu.enumeration.TipoRenda;
import fatec.edu.models.QuestionarioPtIII;

@ManagedBean
@SessionScoped

public class QuestionarioPtIIIMB {
	
	private QuestionarioPtIII questionarioPtIIIAtual;
	private QuestionarioPtIIIDAO questionarioPtIIIDAO;
	private List  tipoRenda;
	private List periodo;
	private List<QuestionarioPtIII> rendas;
		
	public QuestionarioPtIIIMB() {
		questionarioPtIIIAtual = new QuestionarioPtIII();
		questionarioPtIIIDAO = new QuestionarioPtIIIDAOImpl();
		try {
			setRendas(questionarioPtIIIDAO.listarRendas());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	
	@PostConstruct
	 public void init() {
		tipoRenda = Arrays.asList(TipoRenda.values());
		periodo = Arrays.asList(Periodo.values());
	 }
	 
	
	public String adicionar(){
		try {
			questionarioPtIIIDAO.manter(getQuestionarioPtIIIAtual());
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Renda inserida com sucesso", null);
			fc.addMessage("", msg);
			questionarioPtIIIAtual = new QuestionarioPtIII();
			setRendas(questionarioPtIIIDAO.listarRendas());
		} catch (SQLException e) {
			e.printStackTrace();
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir",      null);
			fc.addMessage("", msg);
		}
			return "";
	}
	

	public QuestionarioPtIIIDAO getQuestionarioPtIIIDAO() {
		return questionarioPtIIIDAO;
	}

	public void setQuestionarioPtIIIDAO(QuestionarioPtIIIDAO questionarioPtIIIDAO) {
		this.questionarioPtIIIDAO = questionarioPtIIIDAO;
	}

	public QuestionarioPtIII getQuestionarioPtIIIAtual() {
		return questionarioPtIIIAtual;
	}

	public void setQuestionarioPtIIIAtual(QuestionarioPtIII questionarioPtIIIAtual) {
		this.questionarioPtIIIAtual = questionarioPtIIIAtual;
	}


	public List getTipoRenda() {
		return tipoRenda;
	}


	public void setTipoRenda(List tipoRenda) {
		this.tipoRenda = tipoRenda;
	}



	public List getPeriodo() {
		return periodo;
	}



	public void setPeriodo(List periodo) {
		this.periodo = periodo;
	}



	public List<QuestionarioPtIII> getRendas() {
		return rendas;
	}



	public void setRendas(List<QuestionarioPtIII> rendas) {
		this.rendas = rendas;
	}

}