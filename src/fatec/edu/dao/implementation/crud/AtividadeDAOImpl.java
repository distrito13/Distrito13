package fatec.edu.dao.implementation.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.AtividadeDAO;
import fatec.edu.models.Atividade;

public class AtividadeDAOImpl implements AtividadeDAO {

	Connection conection;

	public AtividadeDAOImpl() {
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public void manter(Atividade atividade) throws SQLException {
		String sql = "INSERT INTO Atividades VALUES(?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setString(1, atividade.getAtividade());

		ps.execute();
		ps.close();
	}

	@Override
	public List<Atividade> pesquisar() throws SQLException {
		List<Atividade> lista = new ArrayList<Atividade>();
		String sql = "SELECT * FROM Atividades";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Atividade atividade = new Atividade();
			atividade.setIdAtividade(rs.getInt("idAtividade"));
			atividade.setAtividade(rs.getString("atividade"));
			lista.add(atividade);
		}
		ps.close();
		rs.close();
		return lista;
	}

	@Override
	public void remover(Atividade atividade) throws SQLException {
		String sql = "DELETE Atividades WHERE idAtividade =?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, atividade.getIdAtividade());
		ps.execute();
		ps.close();
	}

}
