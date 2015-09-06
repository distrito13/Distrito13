package fatec.edu.mb;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fatec.edu.dao.implementation.crud.QuestionarioPtIIDAOImpl;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIIDAO;
import fatec.edu.models.QuestionarioPtII;

@ManagedBean
@SessionScoped
public class QuestionarioPtIIMB {

	
	private QuestionarioPtII questionarioPtIIAtual;
	private QuestionarioPtIIDAO questionarioPtIIDAO;
	
	public QuestionarioPtIIMB() {
		questionarioPtIIAtual = new QuestionarioPtII();
		questionarioPtIIDAO = new QuestionarioPtIIDAOImpl();
	}
	
	
	public String adicionar(){
		try {
			questionarioPtIIDAO.manter(getQuestionarioPtIIAtual());
			questionarioPtIIAtual = new QuestionarioPtII();
		} catch (SQLException e) {
			e.printStackTrace();
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

}
