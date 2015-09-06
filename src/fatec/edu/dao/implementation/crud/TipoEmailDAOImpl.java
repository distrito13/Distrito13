package fatec.edu.dao.implementation.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.TipoEmailDAO;
import fatec.edu.models.TipoEmail;

public class TipoEmailDAOImpl implements TipoEmailDAO {

	Connection conection;

	public TipoEmailDAOImpl() {
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public void manter(TipoEmail tipoEmail) throws SQLException {
		String sql = "INSERT INTO TipoEmail VALUES(?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setString(1, tipoEmail.getTipoEmail());

		ps.execute();
		ps.close();

	}

	@Override
	public List<TipoEmail> pesquisar() throws SQLException {
		List<TipoEmail> lista = new ArrayList<TipoEmail>();
		String sql = "SELECT * FROM TipoEmail";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			TipoEmail tipoEmail = new TipoEmail();
			tipoEmail.setIdTipoEmail(rs.getInt("idTipoEmail"));
			tipoEmail.setTipoEmail(rs.getString("tipo"));
			lista.add(tipoEmail);
		}
		ps.close();
		rs.close();
		return lista;
	}

	@Override
	public void remover(TipoEmail tipoEmail) throws SQLException {

		String sql = "DELETE TipoEmail WHERE idTipoEmail =?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, tipoEmail.getIdTipoEmail());
		ps.execute();
		ps.close();
	}

}
