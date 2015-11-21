package fatec.edu.dao.implementation.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.edu.controle.acesso.ControleAcessoDAO;
import fatec.edu.controle.acesso.ControleAcessoDAOImpl;
import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.QuestionarioPtVIDAO;
import fatec.edu.models.QuestionarioPtVI;

public class QuestionarioPtVIDAOImpl implements QuestionarioPtVIDAO {

	Connection conection;

	public QuestionarioPtVIDAOImpl(){
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public void manter(QuestionarioPtVI questionarioPtVI) throws SQLException {
		String sql = "insert into Ativos Values(?, ?, ?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		
		ps.setDouble(1,questionarioPtVI.getValor());
		ps.setString(2, questionarioPtVI.getTipoAtivo());

		ControleAcessoDAO controleAcessoDAO= new ControleAcessoDAOImpl();
		ps.setInt(3, controleAcessoDAO.retornaIdControleAcesso());
		
		ps.execute();
		ps.close();
		
	}

	@Override
	public List<QuestionarioPtVI> listarAtivos() throws SQLException {
		ControleAcessoDAOImpl controleAcessoDAOImpl = new ControleAcessoDAOImpl();
		int idTomador = controleAcessoDAOImpl.retornaIdControleAcesso();
		List<QuestionarioPtVI> lista = new ArrayList<QuestionarioPtVI>();
		String sql = "SELECT * FROM Ativos WHERE idTomador = ?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, idTomador);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			QuestionarioPtVI questionarioPtVI = new QuestionarioPtVI();
			questionarioPtVI.setId(rs.getInt("idAtivo"));
			questionarioPtVI.setValor(rs.getDouble("valor"));
			questionarioPtVI.setTipoAtivo(rs.getString("tipo"));
			questionarioPtVI.setIdTomador(rs.getInt("idTomador"));
			lista.add(questionarioPtVI);
		}
		ps.close();
		rs.close();
		return lista;

	}
	
	@Override
	public void atualizarAtivo(QuestionarioPtVI questionarioPtVI, int idAtivo) throws SQLException {
		String sql = "UPDATE Ativos SET valor = ? , tipo = ? WHERE idAtivo = " + idAtivo;
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setDouble(1, questionarioPtVI.getValor());
		ps.setString(2, questionarioPtVI.getTipoAtivo());

		ps.execute();
		ps.close();
	}

	/**
	 * Método usado para deletar determinada dívida do banco de dados
	 * 
	 * @param questionarioPtIV
	 */
	@Override
	public void deletarAtivo(QuestionarioPtVI questionarioPtVI) throws SQLException {
		String sql = "DELETE Ativos WHERE idAtivo = ?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, questionarioPtVI.getId());
		ps.execute();
		ps.close();

	}

}
