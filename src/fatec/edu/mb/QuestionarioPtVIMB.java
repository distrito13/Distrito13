package fatec.edu.mb;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fatec.edu.enumeration.TipoAtivo;
import fatec.edu.dao.implementation.crud.QuestionarioPtVIDAOImpl;
import fatec.edu.dao.interfaces.crud.QuestionarioPtVIDAO;
import fatec.edu.models.QuestionarioPtVI;

@ManagedBean
@SessionScoped
public class QuestionarioPtVIMB {

	private QuestionarioPtVI questionarioPtVIAtual;
	private QuestionarioPtVIDAO questionarioPtVIDAO;
	private List tipoAtivo;
	private List<QuestionarioPtVI> ativos;
	
	private boolean ocultar;

	public QuestionarioPtVIMB() {
		ocultar = true;
		questionarioPtVIAtual = new QuestionarioPtVI();
		questionarioPtVIDAO = new QuestionarioPtVIDAOImpl();
		try {
			setAtivos(questionarioPtVIDAO.listarAtivos());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		tipoAtivo = Arrays.asList(TipoAtivo.values());
	}
	
	public boolean validaEntrada(){
		if(questionarioPtVIAtual.getValor()<=0.0){
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
			questionarioPtVIDAO.manter(getQuestionarioPtVIAtual());
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ativo inserido com sucesso", null);
			fc.addMessage("", msg);
			questionarioPtVIAtual = new QuestionarioPtVI();
			setAtivos(questionarioPtVIDAO.listarAtivos());
			}

		} catch (SQLException e) {
			e.printStackTrace();
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir",      null);
			fc.addMessage("", msg);
		}
		return " ";
	}
	
	public void editar(QuestionarioPtVI ativo) {
		questionarioPtVIAtual = ativo;
		setOcultar(false);
	}

	public void atualizar() {
		try {
			if(validaEntrada()){
			questionarioPtVIDAO.atualizarAtivo(questionarioPtVIAtual, questionarioPtVIAtual.getId());
			setOcultar(true);
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dívida/Despesa atualizada com sucesso", null);
			fc.addMessage("", msg);
			questionarioPtVIAtual = new QuestionarioPtVI();
		}
			setAtivos(questionarioPtVIDAO.listarAtivos());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletar(QuestionarioPtVI ativo) {
		try {
			questionarioPtVIDAO.deletarAtivo(ativo);
			setAtivos(questionarioPtVIDAO.listarAtivos());
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dívida/Despesa excluida com sucesso", null);
			fc.addMessage("", msg);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public QuestionarioPtVIDAO getQuestionarioPtVIDAO() {
		return questionarioPtVIDAO;
	}

	public void setQuestionarioPtVIDAO(QuestionarioPtVIDAO questionarioPtVIDAO) {
		this.questionarioPtVIDAO = questionarioPtVIDAO;
	}

	public QuestionarioPtVI getQuestionarioPtVIAtual() {
		return questionarioPtVIAtual;
	}

	public void setQuestionarioPtVIAtual(QuestionarioPtVI questionarioPtVIAtual) {
		this.questionarioPtVIAtual = questionarioPtVIAtual;
	}

	public List getTipoAtivo() {
		return tipoAtivo;
	}

	public void setTipoAtivo(List tipoAtivo) {
		this.tipoAtivo = tipoAtivo;
	}
	
	public List<QuestionarioPtVI> getAtivos() {
		return ativos;
	}

	public void setAtivos(List<QuestionarioPtVI> ativos) {
		this.ativos= ativos;
	}

	public boolean isOcultar() {
		return ocultar;
	}

	public void setOcultar(boolean ocultar) {
		this.ocultar = ocultar;
	}
	
	

}
