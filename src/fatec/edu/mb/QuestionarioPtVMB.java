package fatec.edu.mb;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fatec.edu.dao.implementation.crud.QuestionarioPtVDAOImpl;
import fatec.edu.dao.interfaces.crud.QuestionarioPtVDAO;
import fatec.edu.enumeration.Periodo;
import fatec.edu.enumeration.TipoRenda;
import fatec.edu.models.QuestionarioPtV;

@ManagedBean
@SessionScoped
public class QuestionarioPtVMB {

	
	private QuestionarioPtV questionarioPtVAtual;
	private QuestionarioPtVDAO questionarioPtVDAO;
	private List periodo;
	
	
	public QuestionarioPtVMB() {
		questionarioPtVAtual = new QuestionarioPtV();
		questionarioPtVDAO = new QuestionarioPtVDAOImpl();
	}
	
	@PostConstruct
	 public void init() {
		periodo = Arrays.asList(Periodo.values());
	 }
	 
	
	public String adicionar(){
			try {
				questionarioPtVDAO.manter(getQuestionarioPtVAtual());
			} catch (SQLException e) {
				e.printStackTrace();
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

}
