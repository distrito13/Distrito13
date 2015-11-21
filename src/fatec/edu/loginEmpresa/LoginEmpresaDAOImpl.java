package fatec.edu.loginEmpresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import fatec.edu.dao.generic.GenericDAO;

public class LoginEmpresaDAOImpl implements LoginEmpresaDAO {

	Connection conection;
	static boolean validacao;
	public static int VALOR_CREDOR_ID;

	public LoginEmpresaDAOImpl() {
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public void inserirEmpresa(Credor credor) throws SQLException {
		String sql = "INSERT INTO Credor VALUES (?,?,?,?,?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		/*
		 * ps.setString(1, credor.getCnpj()); ps.setString(2,
		 * credor.getEmpresa()); ps.setString(3, credor.getUsuario());
		 * ps.setString(4, credor.getEmail()); ps.setString(5,
		 * credor.getSenha());
		 */
		ps.setString(5, credor.getCnpj());
		ps.setString(1, credor.getEmpresa());
		ps.setString(3, credor.getUsuario());
		ps.setString(2, credor.getEmail());
		ps.setString(4, credor.getSenha());
		ps.execute();
		ps.close();

	}

	public List<Credor> buscarLoginSenha(String credorUsuario, String senha) throws SQLException {
		Credor credor = new Credor();

		List<Credor> listaCredor = new ArrayList<Credor>();
		String sql = "SELECT id FROM Credor WHERE usuario =" + "'" + credorUsuario + "'" + " and senha =" + "'" + senha
				+ "'";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			credor.setId(rs.getInt("id"));
			listaCredor.add(credor);
		}
		ps.close();
		rs.close();
		return listaCredor;
	}

	@Override
	public int buscarLoginId(String credorUsuario, String senha) throws SQLException {
		Credor credor = new Credor();

		String sql = "SELECT id FROM Credor WHERE usuario =" + "'" + credorUsuario + "'" + " and senha =" + "'" + senha
				+ "'";
		PreparedStatement ps = conection.prepareStatement(sql);
		int id;
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			credor.setId(rs.getInt("id"));
		}
		ps.close();
		rs.close();
		return credor.getId();
	}

}
