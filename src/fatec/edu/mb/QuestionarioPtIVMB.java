package fatec.edu.mb;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fatec.edu.dao.implementation.crud.QuestionarioPtIVDAOImpl;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIVDAO;
import fatec.edu.models.QuestionarioPtIV;

@ManagedBean
@SessionScoped
public class QuestionarioPtIVMB {

	
	private QuestionarioPtIV questionarioPtIVAtual;
	private QuestionarioPtIVDAO questionarioPtIVDAO;
	
	public QuestionarioPtIVMB() {
		questionarioPtIVAtual = new QuestionarioPtIV();
		questionarioPtIVDAO = new QuestionarioPtIVDAOImpl();
	}
	
	
	public String adicionar(){
		try {
			questionarioPtIVDAO.manter(getQuestionarioPtIVAtual());
			questionarioPtIVAtual = new QuestionarioPtIV();
		} catch (SQLException e) {
			e.printStackTrace();
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

}
