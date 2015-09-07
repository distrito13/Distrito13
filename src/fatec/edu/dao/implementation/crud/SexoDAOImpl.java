package fatec.edu.dao.implementation.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.SexoDAO;
import fatec.edu.models.Sexo;

public class SexoDAOImpl implements SexoDAO {

	Connection conection;

	public SexoDAOImpl() {
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public void manter(Sexo sexo) throws SQLException {
		String sql = "INSERT INTO Sexos VALUES(?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setString(1, sexo.getSexo());

		ps.execute();
		ps.close();
	}

	@Override
	public List<Sexo> pesquisar() throws SQLException {
		List<Sexo> lista = new ArrayList<Sexo>();
		String sql = "SELECT sexo FROM Sexos";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Sexo sexo = new Sexo();
			sexo.setSexo(rs.getString("sexo"));
			lista.add(sexo);
			System.out.println(sexo);
		}
		ps.close();
		rs.close();
		return lista;
	}

	@Override
	public void remover(Sexo sexo) throws SQLException {
		String sql = "DELETE Sexos WHERE idSexo =?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, sexo.getIdSexo());
		ps.execute();
		ps.close();
	}

}
