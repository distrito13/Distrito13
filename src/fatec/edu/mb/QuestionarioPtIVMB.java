package fatec.edu.mb;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fatec.edu.dao.implementation.crud.QuestionarioPtIVDAOImpl;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIVDAO;
import fatec.edu.enumeration.TipoDivida;
import fatec.edu.models.QuestionarioPtIV;

@ManagedBean
@SessionScoped

public class QuestionarioPtIVMB {

	private QuestionarioPtIV questionarioPtIVAtual;
	private QuestionarioPtIVDAO questionarioPtIVDAO;
	private List tipoDivida;
	private List<QuestionarioPtIV> dividas;

	private boolean ocultar;
	
	public QuestionarioPtIVMB() {
		ocultar = true;
		questionarioPtIVAtual = new QuestionarioPtIV();
		questionarioPtIVDAO = new QuestionarioPtIVDAOImpl();
		try {
			setDividas(questionarioPtIVDAO.listarDividas());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		tipoDivida = Arrays.asList(TipoDivida.values());
	}

	public boolean validaEntrada(){
		if(questionarioPtIVAtual.getValor()<=0.0){
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Favor inserir um valor maior que zero!", null);
			fc.addMessage("", msg);
			
			return false;
		}else{
		return true;
			}
	}
	
	public String adicionar() {
		try {
			if(validaEntrada()){
			questionarioPtIVDAO.manter(getQuestionarioPtIVAtual());
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dívida/Despesa inserida com sucesso",null);
			fc.addMessage("", msg);
			questionarioPtIVAtual = new QuestionarioPtIV();
			setDividas(questionarioPtIVDAO.listarDividas());
			}
			} catch (SQLException e) {
			e.printStackTrace();
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir", null);
			fc.addMessage("", msg);
		}
		return "";
	}

	public void editar(QuestionarioPtIV divida) {
		questionarioPtIVAtual = divida;
		setOcultar(false);
	}

	public void atualizar() {
		try {
			if(validaEntrada()){
			questionarioPtIVDAO.atualizarDivida(questionarioPtIVAtual, questionarioPtIVAtual.getId());
			setOcultar(true);
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dívida/Despesa atualizada com sucesso", null);
			fc.addMessage("", msg);
			questionarioPtIVAtual = new QuestionarioPtIV();
		}
			setDividas(questionarioPtIVDAO.listarDividas());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletar(QuestionarioPtIV divida) {
		try {
			questionarioPtIVDAO.deletarDivida(divida);
			setDividas(questionarioPtIVDAO.listarDividas());
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dívida/Despesa excluida com sucesso", null);
			fc.addMessage("", msg);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	public List<QuestionarioPtIV> getDividas() {
		return dividas;
	}

	public void setDividas(List<QuestionarioPtIV> dividas) {
		this.dividas = dividas;
	}

	public boolean isOcultar() {
		return ocultar;
	}

	public void setOcultar(boolean ocultar) {
		this.ocultar = ocultar;
	}

	
}
