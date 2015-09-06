package fatec.edu.mb;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fatec.edu.dao.implementation.crud.EstadoDAOImpl;
import fatec.edu.dao.interfaces.crud.EstadoDAO;
import fatec.edu.models.Estado;

@ManagedBean
@SessionScoped
public class EstadoManagedBean {

	private Estado estadoAtual;
	private EstadoDAO estadoDAO;
	private List<Estado> estados;

	public EstadoManagedBean() {
		estadoAtual = new Estado();
		estadoDAO = new EstadoDAOImpl();
		try {
			setEstados(estadoDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String adicionarEstado() {
		try {
			estadoDAO.manter(getEstadoAtual());
			estadoAtual = new Estado();
			setEstados(estadoDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";

	}

	public void remover(Estado estado) {
		try {
			estadoDAO.remover(estadoAtual);
			setEstados(estadoDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editar(Estado estado) {
		estadoAtual = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public EstadoDAO getEstadoDAO() {
		return estadoDAO;
	}

	public void setEstadoDAO(EstadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}

	public Estado getEstadoAtual() {
		return estadoAtual;
	}

	public void setEstadoAtual(Estado estadoAtual) {
		this.estadoAtual = estadoAtual;
	}

}
