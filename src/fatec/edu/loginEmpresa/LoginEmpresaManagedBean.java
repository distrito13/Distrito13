package fatec.edu.loginEmpresa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class LoginEmpresaManagedBean {

	private Credor credorAtual;
	private LoginEmpresaDAO loginEmpresaDAO;
	private List<Credor> credores;
	public static int usuarioLogado;
	
	public LoginEmpresaManagedBean() throws SQLException {
		credorAtual = new Credor();
		loginEmpresaDAO = new LoginEmpresaDAOImpl();
	}

	public String adicionarEmpresa() {
		try {
			loginEmpresaDAO.inserirEmpresa(getCredorAtual());
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio inserido com sucesso", null);
			fc.addMessage("", msg);
			credorAtual = new Credor();
		} catch (SQLException e) {
			e.printStackTrace();
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir",      null);
			fc.addMessage("", msg);
		}
		return "";
	}

	public String pesquisarLogin() throws SQLException, IOException {

//		FacesContext facesContext = FacesContext.getCurrentInstance();

		List<Credor> lista = loginEmpresaDAO.buscarLoginSenha(credorAtual.getUsuario(), credorAtual.getSenha());
		if (lista.isEmpty()) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("FalhaLogin.xhtml");
		} else {
			FacesContext.getCurrentInstance().getExternalContext().redirect("menuBolha2//index2.xhtml");
			credorAtual.setId(loginEmpresaDAO.buscarLoginId(credorAtual.getUsuario(), credorAtual.getSenha()));
			usuarioLogado = credorAtual.getId();
//			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
//			session.setAttribute("usuario", credorAtual.getId());  
		}


		System.out.println("o usu�rio logado � :" + usuarioLogado);
		return "";
	}

	public Credor getCredorAtual() {
		return credorAtual;
	}

	public void setCredorAtual(Credor credorAtual) {
		this.credorAtual = credorAtual;
	}

	public LoginEmpresaDAO getLoginEmpresaDAO() {
		return loginEmpresaDAO;
	}

	public void setLoginEmpresaDAO(LoginEmpresaDAO loginEmpresaDAO) {
		this.loginEmpresaDAO = loginEmpresaDAO;
	}

	public List<Credor> getCredores() {
		return credores;
	}

	public void setCredores(List<Credor> credores) {
		this.credores = credores;
	}
}
