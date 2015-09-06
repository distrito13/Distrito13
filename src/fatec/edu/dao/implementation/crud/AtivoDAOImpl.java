package fatec.edu.dao.implementation.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.AtivoDAO;
import fatec.edu.models.Ativo;
import fatec.edu.models.Credor;

public class AtivoDAOImpl implements AtivoDAO {

	Connection conection;
	Credor credor;
	
	public AtivoDAOImpl(){
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}
	public void manter(Ativo ativo) throws SQLException {
		String sql = "INSERT INTO Ativos VALUES(?,?,?,?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setDouble(1, ativo.getValor());
		ps.setString(2, ativo.getDescricao());
		ps.setString(3, ativo.getSituacao());
		ps.setInt(4, ativo.getCredor());
		ps.execute();
		ps.close();
		
	}


	public List<Ativo> pesquisar() throws SQLException {
		List<Ativo> lista= new ArrayList<Ativo>();
		String sql= "SELECT * FROM Ativos";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Ativo ativo=new Ativo();
			ativo.setIdAtivo(rs.getInt("idAtivo"));
			ativo.setValor(rs.getDouble("valor"));
			ativo.setDescricao(rs.getString("descricao"));
			ativo.setSituacao(rs.getString("situacao"));
			ativo.setCredor(rs.getInt("idCredor"));
			lista.add(ativo);
		}
		ps.close();
		rs.close();
		return lista;
	
	}


	public void remover(Ativo ativo) throws SQLException {
		String sql ="DELETE Ativos WHERE idAtivo =?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, ativo.getIdAtivo());
		ps.execute();
		ps.close();		
	}

}
