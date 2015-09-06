package fatec.edu.mb;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fatec.edu.dao.implementation.crud.QuestionarioPtVDAOImpl;
import fatec.edu.dao.interfaces.crud.QuestionarioPtVDAO;
import fatec.edu.models.QuestionarioPtV;

@ManagedBean
@SessionScoped
public class QuestionarioPtVMB {

	
	private QuestionarioPtV questionarioPtVAtual;
	private QuestionarioPtVDAO questionarioPtVDAO;
	
	public QuestionarioPtVMB() {
		questionarioPtVAtual = new QuestionarioPtV();
		questionarioPtVDAO = new QuestionarioPtVDAOImpl();
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

}
