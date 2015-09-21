package fatec.edu.mb;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fatec.edu.dao.implementation.crud.QuestionarioPtIVDAOImpl;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIVDAO;
import fatec.edu.enumeration.TipoDivida;
import fatec.edu.models.QuestionarioPtIV;


@ManagedBean
//@SessionScoped
@RequestScoped
public class QuestionarioPtIVMB {

	
	private QuestionarioPtIV questionarioPtIVAtual;
	private QuestionarioPtIVDAO questionarioPtIVDAO;
	private List tipoDivida;
	
	
	public QuestionarioPtIVMB() {
		questionarioPtIVAtual = new QuestionarioPtIV();
		questionarioPtIVDAO = new QuestionarioPtIVDAOImpl();			
	}
	
	@PostConstruct
	 public void init() {
		tipoDivida = Arrays.asList(TipoDivida.values());
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


	public List getTipoDivida() {
		return tipoDivida;
	}


	public void setTipoDivida(List tipoDivida) {
		this.tipoDivida = tipoDivida;
	}



}
