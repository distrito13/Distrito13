package fatec.edu.controle.acesso;

import java.io.IOException;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ManagedBeanControleAcesso {

	private ControleAcesso controleAcessoUltimo;
	private ControleAcessoDAO controleAcessoDAO;

	public ManagedBeanControleAcesso() {
		controleAcessoUltimo = new ControleAcesso();
		controleAcessoDAO = new ControleAcessoDAOImpl();
	}

	public String iniciarControleAcesso() {
		try {
			controleAcessoDAO.manterControleAcesso(getControleAcessoUltimo());
			controleAcessoDAO.inicializarTabelaTomador();
			controleAcessoUltimo = new ControleAcesso();
			try {
				FacesContext.getCurrentInstance().getExternalContext().
				redirect("TestTomadorAbas.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";

	}
	
	public void RetornaUltimoId(){
		try {
			
			int ultimo = controleAcessoDAO.retornaIdControleAcesso();
			
			System.out.println(ultimo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public ControleAcesso getControleAcessoUltimo() {
		return controleAcessoUltimo;
	}

	public void setControleAcessoUltimo(ControleAcesso controleAcessoUltimo) {
		this.controleAcessoUltimo = controleAcessoUltimo;
	}

	public ControleAcessoDAO getControleAcessoDAO() {
		return controleAcessoDAO;
	}

	public void setControleAcessoDAO(ControleAcessoDAO controleAcessoDAO) {
		this.controleAcessoDAO = controleAcessoDAO;
	}
}
