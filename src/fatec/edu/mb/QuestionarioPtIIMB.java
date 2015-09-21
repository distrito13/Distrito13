package fatec.edu.mb;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fatec.edu.dao.implementation.crud.QuestionarioPtIDAOImpl;
import fatec.edu.dao.implementation.crud.QuestionarioPtIIDAOImpl;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIDAO;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIIDAO;
import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.QuestionarioPtII;

@ManagedBean
//@SessionScoped
//@RequestScoped
@ViewScoped
public class QuestionarioPtIIMB {

	
	private QuestionarioPtII questionarioPtIIAtual;
	private QuestionarioPtIIDAO questionarioPtIIDAO;
	private QuestionarioPtI questionarioPtI;
	private QuestionarioPtIDAO questionarioPtIDAO;
	private int newId;
	
	public QuestionarioPtIIMB() {
		questionarioPtIIAtual = new QuestionarioPtII();
		questionarioPtIIDAO = new QuestionarioPtIIDAOImpl();
		questionarioPtIDAO = new QuestionarioPtIDAOImpl();
		
		try {
			System.out.println(questionarioPtIDAO.pesquisarUltimoId());
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
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

}
