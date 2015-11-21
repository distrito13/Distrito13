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
import fatec.edu.dao.interfaces.crud.QuestionarioPtIVDAO;
import fatec.edu.models.QuestionarioPtIV;

/**
 * 
 * @author Concecred
 * @since 09/11/2015 Classe para fazer as operações sobre Dívidas no banco de
 *        dados
 *
 */
public class QuestionarioPtIVDAOImpl implements QuestionarioPtIVDAO {

	Connection conection;

	/**
	 * Construtor da classe inicializando o genericDao
	 */
	public QuestionarioPtIVDAOImpl() {
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	/**
	 * Método para inserir as dívidas do Tomador no Banco de dados
	 * 
	 * @param questionarioPtIV
	 */
	@Override
	public void manter(QuestionarioPtIV questionarioPtIV) throws SQLException {
		String sql = "insert into Dividas Values(?, ?, ?)";
		PreparedStatement ps = conection.prepareStatement(sql);

		ps.setDouble(1, questionarioPtIV.getValor());
		ps.setString(2, questionarioPtIV.getTipoDivida());
		ControleAcessoDAO controleAcessoDAO = new ControleAcessoDAOImpl();
		ps.setInt(3, controleAcessoDAO.retornaIdControleAcesso());

		ps.execute();
		ps.close();

	}

	/**
	 * Método para listar as dívidas na Table do banco de dados
	 */
	@Override
	public List<QuestionarioPtIV> listarDividas() throws SQLException {
		ControleAcessoDAOImpl controleAcessoDAOImpl = new ControleAcessoDAOImpl();
		int idTomador = controleAcessoDAOImpl.retornaIdControleAcesso();
		List<QuestionarioPtIV> lista = new ArrayList<QuestionarioPtIV>();
		String sql = "SELECT * FROM Dividas WHERE idTomador = ?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, idTomador);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			QuestionarioPtIV questionarioPtIV = new QuestionarioPtIV();
			questionarioPtIV.setId(rs.getInt("idDivida"));
			questionarioPtIV.setTipoDivida(rs.getString("tipoDivida"));
			questionarioPtIV.setValor(rs.getDouble("valor"));
			lista.add(questionarioPtIV);
		}
		ps.close();
		rs.close();
		return lista;
	}

	/**
	 * Método usado para fazer os updates de dívidas no banco
	 * 
	 * @param questionarioPtIV
	 * @param idDivdia
	 */
	@Override
	public void atualizarDivida(QuestionarioPtIV questionarioPtIV, int idDivida) throws SQLException {
		String sql = "UPDATE Dividas SET valor = ? , tipoDivida = ? WHERE idDivida = " + idDivida;
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setDouble(1, questionarioPtIV.getValor());
		ps.setString(2, questionarioPtIV.getTipoDivida());

		ps.execute();
		ps.close();
	}

	/**
	 * Método usado para deletar determinada dívida do banco de dados
	 * 
	 * @param questionarioPtIV
	 */
	@Override
	public void deletarDivida(QuestionarioPtIV questionarioPtIV) throws SQLException {
		String sql = "DELETE Dividas WHERE idDivida = ?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, questionarioPtIV.getId());
		ps.execute();
		ps.close();

	}
}
