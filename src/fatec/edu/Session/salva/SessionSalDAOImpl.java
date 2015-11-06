package fatec.edu.Session.salva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fatec.edu.controle.acesso.ControleAcessoDAO;
import fatec.edu.controle.acesso.ControleAcessoDAOImpl;
import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.loginEmpresa.Credor;
import fatec.edu.loginEmpresa.LoginEmpresaDAO;
import fatec.edu.loginEmpresa.LoginEmpresaDAOImpl;
import fatec.edu.loginEmpresa.LoginEmpresaManagedBean;

public class SessionSalDAOImpl implements SessionSalDAO{

	Connection conection;

	
	public SessionSalDAOImpl(){
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}
	
	
	@Override
	public void UsuarioCredor() throws SQLException {
		Credor credor = new Credor();
		ControleAcessoDAO controleAcessoDAO= new ControleAcessoDAOImpl();
		int tomador = controleAcessoDAO.retornaIdControleAcesso();
		
		LoginEmpresaManagedBean usuarioLogado = new LoginEmpresaManagedBean();
		
		credor.setId(usuarioLogado.usuarioLogado);
		
		String sql = "INSERT INTO CredorTomador VALUES(?,?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1,tomador);
		ps.setInt(2,credor.getId());
		System.out.println("Dados"+tomador+"-"+credor.getId());
		
		
		
		ps.execute();
		ps.close();

	}

}
