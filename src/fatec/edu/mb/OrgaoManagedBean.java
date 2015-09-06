package fatec.edu.mb;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fatec.edu.dao.implementation.crud.OrgaoDAOImpl;
import fatec.edu.dao.interfaces.crud.OrgaoDAO;
import fatec.edu.models.Orgao;

@ManagedBean
@SessionScoped
public class OrgaoManagedBean {

	private Orgao orgaoAtual;
	private OrgaoDAO orgaoDAO;
	private List<Orgao> orgaos;

	public OrgaoManagedBean() {
		setOrgaoAtual(new Orgao());
		orgaoDAO = new OrgaoDAOImpl();
		try {
			setOrgaos(orgaoDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public String adicionarTipo(){
		try {
			orgaoDAO.manter(getOrgaoAtual());
			orgaoAtual = new Orgao();
			setOrgaos(orgaoDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public void remover(Orgao orgao){
		try {
			orgaoDAO.remover(orgaoAtual);
			setOrgaos(orgaoDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editar(Orgao orgao){
		orgaoAtual = orgao;
	}
	
	public Orgao getOrgaoAtual() {
		return orgaoAtual;
	}

	public void setOrgaoAtual(Orgao orgaoAtual) {
		this.orgaoAtual = orgaoAtual;
	}

	public OrgaoDAO getOrgaoDAO() {
		return orgaoDAO;
	}

	public void setOrgaoDAO(OrgaoDAO orgaoDAO) {
		this.orgaoDAO = orgaoDAO;
	}

	public List<Orgao> getOrgaos() {
		return orgaos;
	}

	public void setOrgaos(List<Orgao> orgaos) {
		this.orgaos = orgaos;
	}

}
