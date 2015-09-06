package fatec.edu.dao.implementation.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.OrgaoDAO;
import fatec.edu.models.Orgao;

public class OrgaoDAOImpl implements OrgaoDAO{
	
	Connection conection;
	
	public OrgaoDAOImpl(){
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public void manter(Orgao orgao) throws SQLException {
		String sql = "INSERT INTO Orgaos VALUES(?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setString(1, orgao.getOrgao());

		ps.execute();
		ps.close();
		
	}

	@Override
	public List<Orgao> pesquisar() throws SQLException {
		List<Orgao> lista = new ArrayList<Orgao>();
		String sql = "SELECT * FROM Orgaos";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Orgao orgao = new Orgao();
			orgao.setIdOrgao(rs.getInt("idOrgao"));
			orgao.setOrgao(rs.getString("descricao"));
		
			lista.add(orgao);
		}
		ps.close();
		rs.close();
		return lista;
	}

	@Override
	public void remover(Orgao orgao) throws SQLException {
		String sql = "DELETE Orgaos WHERE idOrgao =?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, orgao.getIdOrgao());
		ps.execute();
		ps.close();
	}

}
