package fatec.edu.mb;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fatec.edu.dao.implementation.crud.TipoTelefoneDAOImpl;
import fatec.edu.dao.interfaces.crud.TipoTelefoneDAO;
import fatec.edu.models.TipoTelefone;

@ManagedBean
@SessionScoped
public class TipoTelefoneManagedBean {

	private TipoTelefone tipoTelefoneAtual;
	private TipoTelefoneDAO tipoTelefoneDAO;
	private List<TipoTelefone> tiposTelefones;

	public TipoTelefoneManagedBean() {
		tipoTelefoneAtual = new TipoTelefone();
		tipoTelefoneDAO = new TipoTelefoneDAOImpl();
		try {
			setTiposTelefones(tipoTelefoneDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public String adicionarTipo() {
		try {
			tipoTelefoneDAO.manter(getTipoTelefoneAtual());
			tipoTelefoneAtual = new TipoTelefone();
			setTiposTelefones(tipoTelefoneDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "";
	}
	
	public void remover(TipoTelefone tipoTelefone){
		try {
			tipoTelefoneDAO.remover(tipoTelefone);
			setTiposTelefones(tipoTelefoneDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editar(TipoTelefone tipoTelefone) {
		tipoTelefoneAtual = tipoTelefone;
	}

	public void setTipoTelefoneDAO(TipoTelefoneDAO tipoTelefoneDAO) {
		this.tipoTelefoneDAO = tipoTelefoneDAO;
	}

	public TipoTelefoneDAO getTipoTelefoneDAO() {
		return tipoTelefoneDAO;
	}

	public void setTipoTelefoneAtual(TipoTelefone tipoTelefoneAtual) {
		this.tipoTelefoneAtual = tipoTelefoneAtual;
	}

	public TipoTelefone getTipoTelefoneAtual() {
		return tipoTelefoneAtual;
	}

	public List<TipoTelefone> getTiposTelefones() {
		return tiposTelefones;
	}

	public void setTiposTelefones(List<TipoTelefone> tiposTelefones) {
		this.tiposTelefones = tiposTelefones;
	}

}
