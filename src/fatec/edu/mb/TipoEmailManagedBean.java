package fatec.edu.mb;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fatec.edu.dao.implementation.crud.TipoEmailDAOImpl;
import fatec.edu.dao.interfaces.crud.TipoEmailDAO;
import fatec.edu.models.TipoEmail;

@ManagedBean
@SessionScoped
public class TipoEmailManagedBean {

	private TipoEmail tipoEmailAtual;
	private TipoEmailDAO tipoEmailDAO;
	private List<TipoEmail> tiposEmails;

	public TipoEmailManagedBean() {
		setTipoEmailAtual(new TipoEmail());
		tipoEmailDAO = new TipoEmailDAOImpl();
		try {
			setTiposEmails(tipoEmailDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public String adicionarTipo(){
		try {
			tipoEmailDAO.manter(getTipoEmailAtual());
			tipoEmailAtual = new TipoEmail();
			setTiposEmails(tipoEmailDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
		
	}
	
	public void remover(TipoEmail tipoEmail){
		try {
			tipoEmailDAO.remover(tipoEmail);
			setTiposEmails(tipoEmailDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editar(TipoEmail tipoEmail){
		tipoEmailAtual = tipoEmail;
	}
	
	public List<TipoEmail> getTiposEmails() {
		return tiposEmails;
	}

	public void setTiposEmails(List<TipoEmail> tiposEmails) {
		this.tiposEmails = tiposEmails;
	}

	public TipoEmailDAO getTipoEmailDAO() {
		return tipoEmailDAO;
	}

	public void setTipoEmailDAO(TipoEmailDAO tipoEmailDAO) {
		this.tipoEmailDAO = tipoEmailDAO;
	}

	public TipoEmail getTipoEmailAtual() {
		return tipoEmailAtual;
	}

	public void setTipoEmailAtual(TipoEmail tipoEmailAtual) {
		this.tipoEmailAtual = tipoEmailAtual;
	}

}
