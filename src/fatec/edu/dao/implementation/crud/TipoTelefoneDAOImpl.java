package fatec.edu.dao.implementation.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.TipoTelefoneDAO;
import fatec.edu.models.TipoTelefone;

public class TipoTelefoneDAOImpl implements TipoTelefoneDAO {

	Connection conection;

	public TipoTelefoneDAOImpl() {
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public void manter(TipoTelefone tipoTelefone) throws SQLException {

		String sql = "INSERT INTO TipoTelefone VALUES(?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setString(1, tipoTelefone.getTipoTelefone());

		ps.execute();
		ps.close();

	}

	@Override
	public List<TipoTelefone> pesquisar() throws SQLException {
		List<TipoTelefone> lista = new ArrayList<TipoTelefone>();
		String sql = "SELECT * FROM TipoTelefone";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			TipoTelefone tipoTelefone = new TipoTelefone();
			tipoTelefone.setIdTipoTelefone(rs.getInt("idTipoTelefone"));
			tipoTelefone.setTipoTelefone(rs.getString("tipo"));
			lista.add(tipoTelefone);
		}
		ps.close();
		rs.close();
		return lista;
	}

	@Override
	public void remover(TipoTelefone tipoTelefone) throws SQLException {
		String sql = "DELETE TipoTelefone WHERE idTipoTelefone =?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, tipoTelefone.getIdTipoTelefone());
		ps.execute();
		ps.close();
	}

}
