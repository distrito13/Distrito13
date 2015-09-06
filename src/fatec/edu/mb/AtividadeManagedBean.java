package fatec.edu.mb;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fatec.edu.dao.implementation.crud.AtividadeDAOImpl;
import fatec.edu.dao.interfaces.crud.AtividadeDAO;
import fatec.edu.models.Atividade;

@ManagedBean
@SessionScoped
public class AtividadeManagedBean {

	private Atividade atividadeAtual;
	private AtividadeDAO atividadeDAO;
	private List<Atividade> atividades;
	
	public AtividadeManagedBean(){
		setAtividadeAtual(new Atividade());
		atividadeDAO = new AtividadeDAOImpl();
		try {
			setAtividades(atividadeDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String adicionarTipo(){
		try {
			atividadeDAO.manter(getAtividadeAtual());
			atividadeAtual = new Atividade();
			setAtividades(atividadeDAO.pesquisar());

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return "";
		
	}
	
	
	public void remover(Atividade atividade){
		try {
			atividadeDAO.remover(atividadeAtual);
			setAtividades(atividadeDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void editar(Atividade atividade){
		atividadeAtual = atividade;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public AtividadeDAO getAtividadeDAO() {
		return atividadeDAO;
	}

	public void setAtividadeDAO(AtividadeDAO atividadeDAO) {
		this.atividadeDAO = atividadeDAO;
	}

	public Atividade getAtividadeAtual() {
		return atividadeAtual;
	}

	public void setAtividadeAtual(Atividade atividadeAtual) {
		this.atividadeAtual = atividadeAtual;
	}

}
