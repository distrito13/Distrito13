package fatec.edu.controle.acesso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.TipoEmail;

public class ControleAcessoDAOImpl implements ControleAcessoDAO{

	Connection conection;
	
	public ControleAcessoDAOImpl() {
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();

	}
	
	@Override
	public int retornaIdControleAcesso() throws SQLException {
		int ultimoId = 0;
		String sql = "SELECT idControle FROM ControleAcesso";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			TipoEmail tipoEmail = new TipoEmail();
			ControleAcesso controleAcesos = new ControleAcesso();
			ultimoId = rs.getInt("idControle");
			
			}
		ps.close();
		rs.close();
		return ultimoId;
	
	}

	public void manterControleAcesso(ControleAcesso controleAcesso) throws SQLException {
		String sql = "INSERT INTO ControleAcesso VALUES(?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		String armazena = controleAcesso.getStatusControle();
		ps.setString(1,armazena);
		ps.execute();
		ps.close();
	
	}

	@Override
	public boolean identificaTomadorExistente() throws SQLException {
	boolean flag;
	String sql = "SELECT * FROM Tomadores";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (!rs.next()) {
			return false;
			}
		ps.close();
		rs.close();
		return true;
	}

	@Override
	public void inicializarTabelaTomador() throws SQLException {
		String sql = "insert into Tomadores Values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setString(1,"123456789");
		ps.setString(2, "inicializada");
		ps.setDate(3, new java.sql.Date(10/10/2010));
		ps.setString(4, "inicializada");
		ps.setString(5, "inicializada");
		ps.setInt(6, 1);
		ps.setInt(7, 1);
		ps.setString(8, "inicializada");
		ps.setInt(9, 1);
		ps.setString(10, "inicializada");
		ps.setString(11, "inicializada");

		ps.execute();
		ps.close();

		
	}

}
