package fatec.edu.dao.implementation.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.EstadoDAO;
import fatec.edu.models.Estado;

public class EstadoDAOImpl implements EstadoDAO{

	Connection conection;
	
	public EstadoDAOImpl(){
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}
	
	@Override
	public void manter(Estado estado) throws SQLException {
		String sql = "INSERT INTO Estados VALUES(?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setString(1, estado.getEstado());

		ps.execute();
		ps.close();
	}

	@Override
	public List<Estado> pesquisar() throws SQLException {
		List<Estado> lista = new ArrayList<Estado>();
		String sql = "SELECT * FROM Estados";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Estado estado = new Estado();
			estado.setIdEstado(rs.getInt("idEstado"));
			estado.setEstado(rs.getString("estado"));
			lista.add(estado);
		}
		ps.close();
		rs.close();
		return lista;
	}

	@Override
	public void remover(Estado estado) throws SQLException {
		String sql = "DELETE Estados WHERE idEstado =?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, estado.getIdEstado());
		ps.execute();
		ps.close();
	}

}
