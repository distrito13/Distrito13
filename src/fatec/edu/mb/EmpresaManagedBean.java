package fatec.edu.mb;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fatec.edu.dao.implementation.crud.EmpresaDAOImpl;
import fatec.edu.dao.interfaces.crud.EmpresaDAO;
import fatec.edu.models.Empresa;

@ManagedBean
@SessionScoped
public class EmpresaManagedBean {
	private Empresa empresaAtual;
	private EmpresaDAO empresaDAO;
	private List<Empresa> empresas;

	public EmpresaManagedBean() {
		setEmpresaAtual(new Empresa());
		empresaDAO = new EmpresaDAOImpl();
		try {
			setEmpresas(empresaDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public String adicionarEmpresa() {
		try {
			empresaDAO.manter(getEmpresaAtual());
			empresaAtual = new Empresa();
			setEmpresas(empresaDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

	public void remover(Empresa empresa) {
		try {
			empresaDAO.remover(empresaAtual);
			setEmpresas(empresaDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editar(Empresa empresa) {
		empresaAtual = empresa;
	}

	public void setEmpresaAtual(Empresa empresaAtual) {
		this.empresaAtual = empresaAtual;

	}

	public Empresa getEmpresaAtual() {
		return empresaAtual;
	}

	public void setEmpresaDAO(EmpresaDAO empresaDAO) {
		this.empresaDAO = empresaDAO;
	}

	public EmpresaDAO getEmpresaDAO() {
		return empresaDAO;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

}
