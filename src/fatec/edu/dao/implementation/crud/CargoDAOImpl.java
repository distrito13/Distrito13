package fatec.edu.dao.implementation.crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.CargoDAO;
import fatec.edu.models.Cargo;

public class CargoDAOImpl implements CargoDAO{
	
	Connection conection;
	
	public CargoDAOImpl(){
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public void manter(Cargo cargo) throws SQLException {
		String sql = "INSERT INTO Cargos VALUES(?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setString(1, cargo.getCargo());

		ps.execute();
		ps.close();

		
	}

	@Override
	public List<Cargo> pesquisar() throws SQLException {
		List<Cargo> lista = new ArrayList<Cargo>();
		String sql = "SELECT * FROM Cargos";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Cargo cargo = new Cargo();
			cargo.setIdCargo(rs.getInt("idCargo"));
			cargo.setCargo(rs.getString("cargo"));
			lista.add(cargo);
		}
		ps.close();
		rs.close();
		return lista;
	}

	@Override
	public void remover(Cargo cargo) throws SQLException {
		String sql = "DELETE Cargos WHERE idCargo =?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, cargo.getIdCargo());
		ps.execute();
		ps.close();
		
	}

}
