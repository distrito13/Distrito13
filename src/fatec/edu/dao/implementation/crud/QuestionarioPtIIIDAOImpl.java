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
import fatec.edu.dao.interfaces.crud.QuestionarioPtIIIDAO;
import fatec.edu.models.QuestionarioPtIII;

/**
 * @author Concecred
 * @since 08/11/2015 Classe para fazer as operações sobre Renda no banco de
 *        dados.
 */
public class QuestionarioPtIIIDAOImpl implements QuestionarioPtIIIDAO {

	Connection conection;

	/**
	 * Construtor da classe inicializando o genericDao
	 */
	public QuestionarioPtIIIDAOImpl() {
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	/**
	 * Método para inserir as rendas do Tomador no Banco de dados
	 * 
	 * @param questionarioPtIII
	 */
	@Override
	public void manter(QuestionarioPtIII questionarioPtIII) throws SQLException {
		String sql = "insert into Rendas Values(?, ?, ?, ?)";
		PreparedStatement ps = conection.prepareStatement(sql);

		ps.setDouble(1, questionarioPtIII.getValor());
		ps.setString(2, questionarioPtIII.getTipoRenda());
		ps.setString(3, questionarioPtIII.getPeriodo());
		ControleAcessoDAO controleAcessoDAO = new ControleAcessoDAOImpl();

		ps.setInt(4, controleAcessoDAO.retornaIdControleAcesso());

		ps.execute();
		ps.close();

	}

	/**
	 * Método para listar as rendas na Table do banco de dados
	 */
	@Override
	public List<QuestionarioPtIII> listarRendas() throws SQLException {
		ControleAcessoDAOImpl controleAcessoDAOImpl = new ControleAcessoDAOImpl();
		int idTomador = controleAcessoDAOImpl.retornaIdControleAcesso();
		List<QuestionarioPtIII> lista = new ArrayList<QuestionarioPtIII>();
		String sql = "SELECT * FROM Rendas WHERE idTomador = ?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, idTomador);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			QuestionarioPtIII questionarioPtIII = new QuestionarioPtIII();
			questionarioPtIII.setId(rs.getInt("idRenda"));
			questionarioPtIII.setTipoRenda(rs.getString("tipoRenda"));
			questionarioPtIII.setValor(rs.getDouble("valor"));
			questionarioPtIII.setPeriodo(rs.getString("periodo"));
			lista.add(questionarioPtIII);
		}
		ps.close();
		rs.close();
		return lista;
	}

	@Override
	public int consultandoTomador() throws SQLException {
		return 0;
	}

	/**
	 * Método usado para fazer os updates de renda no banco de dados
	 * 
	 * @param questionarioPtIII
	 * @param idRenda
	 */
	@Override
	public void atualizarRenda(QuestionarioPtIII questionarioPtIII, int idRenda) throws SQLException {

		String sql = "UPDATE Rendas SET valor = ? , tipoRenda = ? , periodo = ? WHERE idRenda = " + idRenda;
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setDouble(1, questionarioPtIII.getValor());
		ps.setString(2, questionarioPtIII.getTipoRenda());
		ps.setString(3, questionarioPtIII.getPeriodo());

		ps.execute();
		ps.close();

	}

	/**
	 * Método usado para deletar determinada renda do banco de dados
	 * 
	 * @param questionarioPtIII
	 */
	@Override
	public void deletarRenda(QuestionarioPtIII questionarioPtIII) throws SQLException {
		String sql = "DELETE Rendas WHERE idRenda = ?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, questionarioPtIII.getId());
		ps.execute();
		ps.close();

	}

}
