package fatec.edu.dao.implementation.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIDAO;
import fatec.edu.models.QuestionarioPtI;

public class QuestionarioPtIDAOImpl implements QuestionarioPtIDAO {

	Connection conection;

	public QuestionarioPtIDAOImpl() {
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public void manter(QuestionarioPtI questionarioPtI) throws SQLException {
		String sql = "UPDATE Tomadores SET "
				+ "cpf = ?,"
				+ "nome = ?,"
				+ "dataNasc = ?,"
				+ "filiacaoResp1 = ?,"
				+ "filiacaoResp2 = ?,"
				+ "idSexo = ?,"
				+ "estadoCivil = ?,"
				+ "regimeCasamento = ?,"
				+ "idEstado = ?,"
				+ "idCidade = ? WHERE idTomador = (SELECT  MAX(ControleAcesso.idControle) FROM ControleAcesso)";
		
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setString(1, questionarioPtI.getCpf());
		ps.setString(2, questionarioPtI.getNome());
		ps.setDate(3, new java.sql.Date(questionarioPtI.getData().getTime()));
		ps.setString(4, questionarioPtI.getFiliacaoI());
		ps.setString(5, questionarioPtI.getFiliacaoII());
		ps.setInt(6, questionarioPtI.getSexo());
		ps.setInt(7, questionarioPtI.getEstadoCivil());
		ps.setString(8, questionarioPtI.getRegismeCasamento());
		ps.setInt(9, questionarioPtI.getIdEstado());
		ps.setInt(10, questionarioPtI.getIdCidade());

		ps.execute();
		ps.close();

	}

	@Override
	public int pesquisarUltimoId() throws SQLException {
		String sql = "SELECT idTomador from Tomadores";
		int i = 0;
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			QuestionarioPtI qptI = new QuestionarioPtI();
			i = rs.getInt("idTomador");
		}
		return i;
	}

}