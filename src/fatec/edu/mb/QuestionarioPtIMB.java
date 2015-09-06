package fatec.edu.mb;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fatec.edu.dao.implementation.crud.QuestionarioPtIDAOImpl;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIDAO;
import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.Sexo;

@ManagedBean
@SessionScoped
public class QuestionarioPtIMB {

	
	private QuestionarioPtI questionarioPtIAtual;
	private QuestionarioPtIDAO questionarioPtIDAO;
	
	public QuestionarioPtIMB() {
		questionarioPtIAtual = new QuestionarioPtI();
		questionarioPtIDAO = new QuestionarioPtIDAOImpl();
	}
	
	

	
	public String adicionar(){
		try {
			questionarioPtIDAO.manter(getQuestionarioPtIAtual());
			questionarioPtIAtual = new QuestionarioPtI();

		} catch (SQLException e) {
			e.printStackTrace();
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

}
