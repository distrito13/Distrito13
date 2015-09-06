package fatec.edu.mb;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fatec.edu.dao.implementation.crud.QuestionarioPtIIIDAOImpl;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIIIDAO;
import fatec.edu.models.QuestionarioPtIII;

@ManagedBean
@SessionScoped
public class QuestionarioPtIIIMB {

	
	private QuestionarioPtIII questionarioPtIIIAtual;
	private QuestionarioPtIIIDAO questionarioPtIIIDAO;
	
	public QuestionarioPtIIIMB() {
		questionarioPtIIIAtual = new QuestionarioPtIII();
		questionarioPtIIIDAO = new QuestionarioPtIIIDAOImpl();
	}
	
	
	public String adicionar(){
		try {
			questionarioPtIIIDAO.manter(getQuestionarioPtIIIAtual());
			questionarioPtIIIAtual = new QuestionarioPtIII();
		} catch (SQLException e) {
			e.printStackTrace();
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

}
