package fatec.edu.mb;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fatec.edu.dao.implementation.crud.QuestionarioPtIDAOImpl;
import fatec.edu.dao.implementation.crud.SexoDAOImpl;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIDAO;
import fatec.edu.dao.interfaces.crud.SexoDAO;
import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.Sexo;

@ManagedBean
@SessionScoped
public class QuestionarioPtIMB implements Serializable{


	private static final long serialVersionUID = 1L;
	private QuestionarioPtI questionarioPtIAtual;
	private QuestionarioPtIDAO questionarioPtIDAO;
	private SexoDAO sexoDAO;
	private List<Sexo> listaSexo;
	Connection conection;

	
	
	public QuestionarioPtIMB() {
		questionarioPtIAtual = new QuestionarioPtI();
		questionarioPtIDAO = new QuestionarioPtIDAOImpl();
		sexoDAO = new SexoDAOImpl();
		try {
			setListaSexo(questionarioPtIDAO.buscarSexo());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public String adicionar(){
		try {
			questionarioPtIDAO.manter(getQuestionarioPtIAtual());
			questionarioPtIAtual = new QuestionarioPtI();
			System.out.println((questionarioPtIDAO.buscarSexo()));
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


	public List<Sexo> getListaSexo() {
		return listaSexo;
	}


	public void setListaSexo(List<Sexo> listaSexo) {
		this.listaSexo = listaSexo;
	}


	public SexoDAO getSexoDAO() {
		return sexoDAO;
	}


	public void setSexoDAO(SexoDAO sexoDAO) {
		this.sexoDAO = sexoDAO;
	}




}
