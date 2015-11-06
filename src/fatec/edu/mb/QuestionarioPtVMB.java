package fatec.edu.mb;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fatec.edu.dao.implementation.crud.QuestionarioPtVDAOImpl;
import fatec.edu.dao.interfaces.crud.QuestionarioPtVDAO;
import fatec.edu.enumeration.Periodo;
import fatec.edu.models.QuestionarioPtV;

@ManagedBean
@SessionScoped
public class QuestionarioPtVMB {

	private QuestionarioPtV questionarioPtVAtual;
	private QuestionarioPtVDAO questionarioPtVDAO;
	private List periodo;
	private List<QuestionarioPtV> pendencias;
	private boolean rememberMe;
	private String sim;
	private String nao;
	private String[] resposta;

	
	
	public QuestionarioPtVMB() {
		questionarioPtVAtual = new QuestionarioPtV();
		questionarioPtVDAO = new QuestionarioPtVDAOImpl();
		try {
			setPendencias(questionarioPtVDAO.listarPendencias());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		periodo = Arrays.asList(Periodo.values());
	}

	public String adicionar() {
		try {
			questionarioPtVDAO.manter(getQuestionarioPtVAtual());
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pendência inserida com sucesso", null);
			fc.addMessage("", msg);
			setPendencias(questionarioPtVDAO.listarPendencias());

		} catch (SQLException e) {
			e.printStackTrace();
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir",      null);
			fc.addMessage("", msg);
		}
		return " ";
	}

	public QuestionarioPtVDAO getQuestionarioPtVDAO() {
		return questionarioPtVDAO;
	}

	public void setQuestionarioPtVDAO(QuestionarioPtVDAO questionarioPtVDAO) {
		this.questionarioPtVDAO = questionarioPtVDAO;
	}

	public QuestionarioPtV getQuestionarioPtVAtual() {
		return questionarioPtVAtual;
	}

	public void setQuestionarioPtVAtual(QuestionarioPtV questionarioPtVAtual) {
		this.questionarioPtVAtual = questionarioPtVAtual;
	}

	public List getPeriodo() {
		return periodo;
	}

	public void setPeriodo(List periodo) {
		this.periodo = periodo;
	}
	
	public List<QuestionarioPtV> getPendencias() {
		return pendencias;
	}

	public void setPendencias(List<QuestionarioPtV> pendencias) {
		this.pendencias= pendencias;
	}

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getNao() {
		return nao;
	}

	public void setNao(String nao) {
		this.nao = nao;
	}

	public String[] getResposta() {
		return resposta;
	}

	public void setResposta(String[] resposta) {
		this.resposta = resposta;
	}


	

}
