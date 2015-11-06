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
import fatec.edu.dao.interfaces.crud.QuestionarioPtIDAO;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIIIDAO;
import fatec.edu.models.Estado;
import fatec.edu.models.QuestionarioPtIII;
import fatec.edu.models.TipoEmail;

public class QuestionarioPtIIIDAOImpl implements QuestionarioPtIIIDAO {

	Connection conection;

	public QuestionarioPtIIIDAOImpl() {
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

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

	@Override
	public List<QuestionarioPtIII> listarRendas() throws SQLException {
		ControleAcessoDAOImpl controleAcessoDAOImpl = new ControleAcessoDAOImpl();
		int idTomador = controleAcessoDAOImpl.retornaIdControleAcesso();
		List<QuestionarioPtIII> lista = new ArrayList<QuestionarioPtIII>();
		String sql = "SELECT * FROM Rendas WHERE idTomador = ?";
		PreparedStatement ps = conection.prepareStatement(sql);
		System.out.println("UltimoTomador"+idTomador);
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
	
}
