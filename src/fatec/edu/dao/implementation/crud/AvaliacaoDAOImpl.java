package fatec.edu.dao.implementation.crud;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.AvaliacaoDAO;
import fatec.edu.models.Avaliacao;

public class AvaliacaoDAOImpl  implements AvaliacaoDAO{
	
	Connection con ;
	
	public AvaliacaoDAOImpl() {
		GenericDAO gDAO = new GenericDAO();
		con = gDAO.getConnection();
	
	
	}
	@Override
	
	public void gravarScoreTomador(Avaliacao avaliacao) {
		
		String sql = "Insert into Avaliacao (idTomador , idCredor , dataAvaliacao, scoreExerceAtividade , scoreRenda ,"
				+ " scoreDivida , scorePendencia , scoreTomador , scoreFinal , valorEmprestimo ) values (?,?,?,?,?,?,?,?,?,? ) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, avaliacao.getIdTomador());
			ps.setInt(2, avaliacao.getIdCredor());
			ps.setDate(3,   new java.sql.Date(avaliacao.getDataAvaliação().getTime()));
			ps.setDouble(4, avaliacao.getScoreExerceAtividade());
			ps.setDouble(5, avaliacao.getScoreRenda());
			ps.setDouble(6, avaliacao.getScoreDivida());
			ps.setDouble(7, avaliacao.getScorePendencia());
			ps.setDouble(8, avaliacao.getScoreTomador());
			ps.setDouble(9, avaliacao.getScoreFinal());
			ps.setDouble(10, avaliacao.getValorEmprestimo());
			
			ps.executeUpdate();
			ps.close();
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

	@Override
	public Avaliacao pesquisarScoreIDTomador(int id) {
		
		
		String sql = "select * from Avaliacao where idTomador = ? order by dataAvaliacao  desc ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1	, id);
			
			ResultSet rs = ps.executeQuery();
			if ( rs.next()){
				Avaliacao av = new Avaliacao();
				av.setIdAvaliacao(rs.getInt("idAvaliacao"));
				av.setIdTomador(rs.getInt("idTomador"));
				av.setIdCredor(rs.getInt("idCredor"));
				av.setScoreExerceAtividade(rs.getDouble("scoreExerceAtividade"));
				av.setScoreRenda(rs.getDouble("scoreRenda"));
				av.setScoreDivida(rs.getDouble("scoreDivida"));
				av.setScorePendencia(rs.getDouble("scorePendencia"));
				av.setScoreTomador(rs.getDouble("scoreTomador"));
				av.setScoreFinal(rs.getDouble("scoreFinal"));
				av.setValorEmprestimo(rs.getDouble("valorEmprestimo"));
				
				
				return av;
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public List<Avaliacao> pesquisarHistorioScoreIDTomador(int id) {
		
		String sql = "select * from Avaliacao where idTomador = ? order by dataAvaliacao  desc ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1	, id);
			
			ResultSet rs = ps.executeQuery();
			if ( rs.next()){
				
				List<Avaliacao> avaliações = new ArrayList<Avaliacao>();
				Avaliacao av = new Avaliacao();
				av.setIdAvaliacao(rs.getInt("idAvaliacao"));
				av.setIdTomador(rs.getInt("idTomador"));
				av.setIdCredor(rs.getInt("idCredor"));
				av.setScoreExerceAtividade(rs.getDouble("scoreExerceAtividade"));
				av.setScoreRenda(rs.getDouble("scoreRenda"));
				av.setScoreDivida(rs.getDouble("scoreDivida"));
				av.setScorePendencia(rs.getDouble("scorePedencia"));
				av.setScoreTomador(rs.getDouble("scoreTomador"));
				av.setScoreFinal(rs.getDouble("scoreFinal"));
				av.setValorEmprestimo(rs.getDouble("valorEmprestimo"));
				
				avaliações.add(av);
				return avaliações;
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;	}
	@Override
	public void deletarScoreTomador(Avaliacao av) {

		String sql = "Delete from Avaliacao where idAvaliacao = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, av.getIdAvaliacao());
			ps.executeUpdate();
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	

	

}
