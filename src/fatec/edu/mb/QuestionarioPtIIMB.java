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

import fatec.edu.dao.implementation.crud.QuestionarioPtIDAOImpl;
import fatec.edu.dao.implementation.crud.QuestionarioPtIIDAOImpl;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIDAO;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIIDAO;
import fatec.edu.enumeration.Estabilidade;
import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.QuestionarioPtII;

@ManagedBean
@SessionScoped

public class QuestionarioPtIIMB {

	private QuestionarioPtII questionarioPtIIAtual;
	private QuestionarioPtIIDAO questionarioPtIIDAO;
	private QuestionarioPtI questionarioPtI;
	private QuestionarioPtIDAO questionarioPtIDAO;
	private int newId;
	private List<QuestionarioPtII> profissoes;
	private SelectItem[] estabilidade;
	
	private List estabilidades;
	
	

	public QuestionarioPtIIMB() {
		questionarioPtIIAtual = new QuestionarioPtII();
		questionarioPtIIDAO = new QuestionarioPtIIDAOImpl();
		questionarioPtIDAO = new QuestionarioPtIDAOImpl();

		try {
			
			System.out.println(questionarioPtIDAO.pesquisarUltimoId());
			setProfissoes(questionarioPtIIDAO.listarProfissoes());
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	
	@PostConstruct
	 public void init() {
		estabilidades = Arrays.asList(Estabilidade.values());
		
	 }
	
	public String adicionar() {
		try {
			questionarioPtIIDAO.manter(getQuestionarioPtIIAtual());
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atividade inserida com sucesso", null);
			fc.addMessage("", msg);
			questionarioPtIIAtual = new QuestionarioPtII();
			setProfissoes(questionarioPtIIDAO.listarProfissoes());
		} catch (SQLException e) {
			e.printStackTrace();
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir",      null);
			fc.addMessage("", msg);
		}
		return "";
	}

	public QuestionarioPtIIDAO getQuestionarioPtIIDAO() {
		return questionarioPtIIDAO;
	}

	public void setQuestionarioPtIIDAO(QuestionarioPtIIDAO questionarioPtIIDAO) {
		this.questionarioPtIIDAO = questionarioPtIIDAO;
	}

	public QuestionarioPtII getQuestionarioPtIIAtual() {
		return questionarioPtIIAtual;
	}

	public void setQuestionarioPtIIAtual(QuestionarioPtII questionarioPtIIAtual) {
		this.questionarioPtIIAtual = questionarioPtIIAtual;
	}

	public void setQuestionarioPtI(QuestionarioPtI questionarioPtI) {
		this.questionarioPtI = questionarioPtI;
	}

	public QuestionarioPtI getQuestionarioPtI() {
		return questionarioPtI;
	}

	public void setQuestionarioPtIDAO(QuestionarioPtIDAO questionarioPtIDAO) {
		this.questionarioPtIDAO = questionarioPtIDAO;
	}

	public QuestionarioPtIDAO getQuestionarioPtIDAO() {
		return questionarioPtIDAO;
	}

	public int getNewId() {
		return newId;
	}

	public void setNewId(int newId) throws SQLException {
		this.newId = questionarioPtIDAO.pesquisarUltimoId();
	}
	
	public SelectItem[] getEstabilidade() {
		SelectItem[] items = new SelectItem[Estabilidade.values().length];
		int i = 0;
		for (Estabilidade estabilidade : Estabilidade.values()) {
			items[i++] = new SelectItem(estabilidade, estabilidade.name());
		}
		return items;

	}
	public void setEstabilidade(SelectItem[] estabilidade) {
		this.estabilidade = estabilidade;
	}

	public List getEstabilidades() {
		return estabilidades;
	}


	public void setEstabilidades(List estabilidades) {
		this.estabilidades = estabilidades;
	}


	public List<QuestionarioPtII> getProfissoes() {
		return profissoes;
	}


	public void setProfissoes(List<QuestionarioPtII> profissoes) {
		this.profissoes = profissoes;
	}

	
	

	

}
