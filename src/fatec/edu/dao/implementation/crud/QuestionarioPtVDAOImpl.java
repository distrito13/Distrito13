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
import fatec.edu.dao.interfaces.crud.QuestionarioPtVDAO;

import fatec.edu.models.QuestionarioPtV;

public class QuestionarioPtVDAOImpl implements QuestionarioPtVDAO {

	Connection conection;

	public QuestionarioPtVDAOImpl(){
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public void manter(QuestionarioPtV questionarioPtV) throws SQLException {
		String sql = "insert into Pendencias Values(?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		
		ps.setDate(1,new java.sql.Date(questionarioPtV.getDataAtraso().getTime()));
		ps.setString(2, questionarioPtV.getTipoPendencia());
		ps.setDouble(3, questionarioPtV.getValor());
		ps.setString(4, questionarioPtV.getPeriodo());
		ps.setInt(5, questionarioPtV.getIdOrgao());
		ControleAcessoDAO controleAcessoDAO= new ControleAcessoDAOImpl();
		ps.setInt(6, controleAcessoDAO.retornaIdControleAcesso());
		
		ps.execute();
		ps.close();
		
	}

	@Override
	public List<QuestionarioPtV> listarPendencias() throws SQLException {
		ControleAcessoDAOImpl controleAcessoDAOImpl = new ControleAcessoDAOImpl();
		int idTomador = controleAcessoDAOImpl.retornaIdControleAcesso();
		List<QuestionarioPtV> lista = new ArrayList<QuestionarioPtV>();
		String sql = "SELECT * FROM Pendencias WHERE idTomador = ?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, idTomador);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			QuestionarioPtV questionarioPtV = new QuestionarioPtV();
			questionarioPtV.setId(rs.getInt("idPendencia"));
			questionarioPtV.setDataAtraso(rs.getDate("dataAtraso"));
			questionarioPtV.setTipoPendencia(rs.getString("tipoPendencia"));
			questionarioPtV.setValor(rs.getDouble("valor"));
			questionarioPtV.setPeriodo(rs.getString("periodo"));
			questionarioPtV.setIdOrgao(rs.getInt("idOrgao"));
			lista.add(questionarioPtV);
		}
		ps.close();
		rs.close();
		return lista;

	}

}
