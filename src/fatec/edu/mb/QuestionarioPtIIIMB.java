package fatec.edu.mb;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fatec.edu.controle.acesso.ControleAcessoDAO;
import fatec.edu.controle.acesso.ControleAcessoDAOImpl;
import fatec.edu.dao.implementation.crud.QuestionarioPtIIIDAOImpl;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIIIDAO;
import fatec.edu.enumeration.Periodo;
import fatec.edu.enumeration.TipoRenda;
import fatec.edu.models.QuestionarioPtIII;

@ManagedBean
@SessionScoped

public class QuestionarioPtIIIMB {

	private QuestionarioPtIII questionarioPtIIIAtual;
	private QuestionarioPtIIIDAO questionarioPtIIIDAO;
	private List tipoRenda;
	private List periodo;
	private List<QuestionarioPtIII> rendas;
	public static int tomadorDaRenda;

	private boolean ocultar;

	public QuestionarioPtIIIMB() {
		ocultar = true;
		questionarioPtIIIAtual = new QuestionarioPtIII();
		questionarioPtIIIDAO = new QuestionarioPtIIIDAOImpl();
		try {
			setRendas(questionarioPtIIIDAO.listarRendas());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@PostConstruct
	public void init() {
		tipoRenda = Arrays.asList(TipoRenda.values());
		periodo = Arrays.asList(Periodo.values());
	}

	public boolean validaEntrada(){
		if(questionarioPtIIIAtual.getValor()<=0.0){
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
			//teste de validação interno para remoção de validação em janela -required removido de valor
				if(validaEntrada()){
				questionarioPtIIIDAO.manter(getQuestionarioPtIIIAtual());

				ControleAcessoDAO controleAcessoDAO = new ControleAcessoDAOImpl();
				tomadorDaRenda = controleAcessoDAO.retornaIdControleAcesso();
				System.out.println("No tomador : " + tomadorDaRenda);
				FacesContext fc = FacesContext.getCurrentInstance();
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Renda inserida com sucesso", null);
				fc.addMessage("", msg);
				questionarioPtIIIAtual = new QuestionarioPtIII();
				setRendas(questionarioPtIIIDAO.listarRendas());				
			}
			/*}*/
				} catch (SQLException e) {
			e.printStackTrace();
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir", null);
			fc.addMessage("", msg);
		}
		return "";
	}

	public void editar(QuestionarioPtIII renda) {
		questionarioPtIIIAtual = renda;
		setOcultar(false);
	}

	public void atualizar() {
		try {
			if(validaEntrada()){
			questionarioPtIIIDAO.atualizarRenda(questionarioPtIIIAtual, questionarioPtIIIAtual.getId());
			setOcultar(true);
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Renda atualizada com sucesso", null);
			fc.addMessage("", msg);
			questionarioPtIIIAtual = new QuestionarioPtIII();
			}
			setRendas(questionarioPtIIIDAO.listarRendas());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletar(QuestionarioPtIII renda) {
		try {
			questionarioPtIIIDAO.deletarRenda(renda);
			setRendas(questionarioPtIIIDAO.listarRendas());
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Renda excluida com sucesso", null);
			fc.addMessage("", msg);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public QuestionarioPtIIIDAO getQuestionarioPtIIIDAO() {
		return questionarioPtIIIDAO;
	}

	public void setQuestionarioPtIIIDAO(QuestionarioPtIIIDAO questionarioPtIIIDAO) {
		this.questionarioPtIIIDAO = questionarioPtIIIDAO;
	}

	public QuestionarioPtIII getQuestionarioPtIIIAtual() {
		return questionarioPtIIIAtual;
	}

	public void setQuestionarioPtIIIAtual(QuestionarioPtIII questionarioPtIIIAtual) {
		this.questionarioPtIIIAtual = questionarioPtIIIAtual;
	}

	public List getTipoRenda() {
		return tipoRenda;
	}

	public void setTipoRenda(List tipoRenda) {
		this.tipoRenda = tipoRenda;
	}

	public List getPeriodo() {
		return periodo;
	}

	public void setPeriodo(List periodo) {
		this.periodo = periodo;
	}

	public List<QuestionarioPtIII> getRendas() {
		return rendas;
	}

	public void setRendas(List<QuestionarioPtIII> rendas) {
		this.rendas = rendas;
	}

	public boolean isOcultar() {
		return ocultar;
	}

	public void setOcultar(boolean ocultar) {
		this.ocultar = ocultar;
	}

	//
	
}