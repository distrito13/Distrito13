package fatec.edu.mb;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fatec.edu.dao.implementation.crud.QuestionarioPtIVDAOImpl;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIVDAO;
import fatec.edu.enumeration.TipoDivida;
import fatec.edu.models.QuestionarioPtIV;

@ManagedBean
@SessionScoped

public class QuestionarioPtIVMB {

	private QuestionarioPtIV questionarioPtIVAtual;
	private QuestionarioPtIVDAO questionarioPtIVDAO;
	private List tipoDivida;
	private List<QuestionarioPtIV> dividas;

	public QuestionarioPtIVMB() {
		questionarioPtIVAtual = new QuestionarioPtIV();
		questionarioPtIVDAO = new QuestionarioPtIVDAOImpl();
		try {
			setDividas(questionarioPtIVDAO.listarDividas());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		tipoDivida = Arrays.asList(TipoDivida.values());
	}

	public String adicionar() {
		try {
			questionarioPtIVDAO.manter(getQuestionarioPtIVAtual());
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dívida/Despesa inserida com sucesso", null);
			fc.addMessage("", msg);
			questionarioPtIVAtual = new QuestionarioPtIV();
			setDividas(questionarioPtIVDAO.listarDividas());
		} catch (SQLException e) {
			e.printStackTrace();
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir",      null);
			fc.addMessage("", msg);
		}
		return "";
	}

	public QuestionarioPtIVDAO getQuestionarioPtIVDAO() {
		return questionarioPtIVDAO;
	}

	public void setQuestionarioPtIVDAO(QuestionarioPtIVDAO questionarioPtIVDAO) {
		this.questionarioPtIVDAO = questionarioPtIVDAO;
	}

	public QuestionarioPtIV getQuestionarioPtIVAtual() {
		return questionarioPtIVAtual;
	}

	public void setQuestionarioPtIVAtual(QuestionarioPtIV questionarioPtIVAtual) {
		this.questionarioPtIVAtual = questionarioPtIVAtual;
	}

	public List getTipoDivida() {
		return tipoDivida;
	}

	public void setTipoDivida(List tipoDivida) {
		this.tipoDivida = tipoDivida;
	}

	public List<QuestionarioPtIV> getDividas() {
		return dividas;
	}

	public void setDividas(List<QuestionarioPtIV> dividas) {
		this.dividas = dividas;
	}
	
}
