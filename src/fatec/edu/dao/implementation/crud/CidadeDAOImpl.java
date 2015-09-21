package fatec.edu.dao.implementation.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.CidadeDAO;
import fatec.edu.models.Cidade;

public class CidadeDAOImpl implements CidadeDAO {

	Connection conection;
	
	public CidadeDAOImpl(){
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}
	
	@Override
	public void manter(Cidade cidade) throws SQLException {
		String sql = "INSERT INTO Cidade VALUES(?,?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setString(1, cidade.getCidade());
		ps.setObject(2, cidade.getEstado());
		ps.execute();
		ps.close();
		
	}

	@Override
	public List<Cidade> pesquisar() throws SQLException {
		List<Cidade> lista= new ArrayList<Cidade>();
		String sql= "SELECT * FROM Cidades";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Cidade cidade = new Cidade();
			cidade.setIdCidade(rs.getInt("idCidade"));
			cidade.setCidade(rs.getString("cidade"));
//			cidade.setEstado(Estado)(rs.getObject("estado"));
			lista.add(cidade);
		}
			ps.close();
			rs.close();
		return lista;
	}

	@Override
	public void remover(Cidade cidade) throws SQLException {

	}

}
