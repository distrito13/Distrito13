package fatec.edu.mb;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fatec.edu.dao.implementation.crud.QuestionarioPtVDAOImpl;
import fatec.edu.dao.interfaces.crud.QuestionarioPtVDAO;
import fatec.edu.enumeration.Periodo;
import fatec.edu.models.QuestionarioPtV;

@ManagedBean
@SessionScoped
public class QuestionarioPtVMB {

	private QuestionarioPtV questionarioPtVAtual;
	private QuestionarioPtVDAO questionarioPtVDAO;
	private List periodo;
	private List<QuestionarioPtV> pendencias;
	
	private boolean ocultar;
	

	public QuestionarioPtVMB() {
		ocultar = true;
		questionarioPtVAtual = new QuestionarioPtV();
		questionarioPtVDAO = new QuestionarioPtVDAOImpl();
		try {
			setPendencias(questionarioPtVDAO.listarPendencias());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		periodo = Arrays.asList(Periodo.values());
	}
	
	public boolean validaEntrada(){
		if(questionarioPtVAtual.getDataAtraso()==null){
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Favor preencher o campo data de atraso!", null);
			fc.addMessage("", msg);	
			return false;
		}else if(questionarioPtVAtual.getValor()<=0.0){
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Favor inserir um valor maior que zero!", null);
			fc.addMessage("", msg);
			return false;
			
		} else if(questionarioPtVAtual.getTipoPendencia().isEmpty()) {
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Favor preencher o campo tipo de pendência", null);
			fc.addMessage("", msg);
			return false;
		}else{
		return true;
			}
	}

	public String adicionar() {
		try {

			if(validaEntrada()){
			questionarioPtVDAO.manter(getQuestionarioPtVAtual());
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pendência inserida com sucesso", null);
			fc.addMessage("", msg);
			questionarioPtVAtual = new QuestionarioPtV();
			setPendencias(questionarioPtVDAO.listarPendencias());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir", null);
			fc.addMessage("", msg);
		}
		return " ";
	}

	public void editar(QuestionarioPtV pendencia) {
		questionarioPtVAtual = pendencia;
		setOcultar(false);
	}

	public void atualizar() {
		try {
			if(validaEntrada()){
			questionarioPtVDAO.atualizarPendencia(questionarioPtVAtual, questionarioPtVAtual.getId());
			setOcultar(true);
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pendência atualizada com sucesso", null);
			fc.addMessage("", msg);
			questionarioPtVAtual = new QuestionarioPtV();
		}
			setPendencias(questionarioPtVDAO.listarPendencias());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletar(QuestionarioPtV pendencia) {
		try {
			questionarioPtVDAO.deletarPendencia(pendencia);
			setPendencias(questionarioPtVDAO.listarPendencias());
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pendência excluida com sucesso", null);
			fc.addMessage("", msg);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	public List getPeriodo() {
		return periodo;
	}

	public void setPeriodo(List periodo) {
		this.periodo = periodo;
	}

	public List<QuestionarioPtV> getPendencias() {
		return pendencias;
	}

	public void setPendencias(List<QuestionarioPtV> pendencias) {
		this.pendencias = pendencias;
	}

	public boolean isOcultar() {
		return ocultar;
	}

	public void setOcultar(boolean ocultar) {
		this.ocultar = ocultar;
	}


}
