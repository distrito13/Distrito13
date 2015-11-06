package fatec.edu.GerenciadorResultados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.edu.controle.acesso.ControleAcessoDAO;
import fatec.edu.controle.acesso.ControleAcessoDAOImpl;
import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.models.Avaliacao;
import fatec.edu.models.QuestionarioPtIII;

public class GerenciaResultadosDAOIMpl implements GerenciaResultadosDAO {

	Connection conection;
	Avaliacao avaliacao;
	static double ScoreFinal;
	static double ScoreExercAtividade;
	static double ScoreRenda;
	static double ScoreDivida;
	static double ScorePendencia;
	static double ScoreAtivo;
	static double ScoreTomador;
	

	public GerenciaResultadosDAOIMpl() {
		super();
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public double pegarScoreFinal() throws SQLException {
		ControleAcessoDAO controleAcessoDAO = new ControleAcessoDAOImpl();
		int ultimoTomador = controleAcessoDAO.retornaIdControleAcesso();
		double Score = 0;
		List<Avaliacao> avaliacao = new ArrayList<Avaliacao>();
		String sql = "SELECT Avaliacao.scoreFinal FROM Avaliacao WHERE Avaliacao.idTomador =" + ultimoTomador
				+ " AND Avaliacao.idCredor = 1";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Avaliacao av = new Avaliacao();
			av.setScoreFinal(rs.getDouble("scoreFinal"));
			Score = av.getScoreFinal();
		}
		ps.close();
		rs.close();
		return Score;
	}

	public double pegarScorePendencia() throws SQLException {
		ControleAcessoDAO controleAcessoDAO = new ControleAcessoDAOImpl();
		int ultimoTomador = controleAcessoDAO.retornaIdControleAcesso();
		double Score = 0;
		List<Avaliacao> avaliacao = new ArrayList<Avaliacao>();
		String sql = "SELECT Avaliacao.scorePendencia FROM Avaliacao WHERE Avaliacao.idTomador =" + ultimoTomador
				+ " AND Avaliacao.idCredor = 1";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Avaliacao av = new Avaliacao();
			av.setScorePendencia(rs.getDouble("scorePendencia"));
			ScorePendencia = av.getScorePendencia();
		}
		ps.close();
		rs.close();
		return ScorePendencia;
	}

	public double pegarScoreDivida() throws SQLException {
		ControleAcessoDAO controleAcessoDAO = new ControleAcessoDAOImpl();
		int ultimoTomador = controleAcessoDAO.retornaIdControleAcesso();
		double Score = 0;
		List<Avaliacao> avaliacao = new ArrayList<Avaliacao>();
		String sql = "SELECT Avaliacao.scoreDivida FROM Avaliacao WHERE Avaliacao.idTomador =" + ultimoTomador
				+ " AND Avaliacao.idCredor = 1";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Avaliacao av = new Avaliacao();
			av.setScoreDivida(rs.getDouble("scoreDivida"));
			ScoreDivida = av.getScoreDivida();
		}
		ps.close();
		rs.close();
		return ScoreDivida;
	}

	public double pegarScoreRenda() throws SQLException {
		ControleAcessoDAO controleAcessoDAO = new ControleAcessoDAOImpl();
		int ultimoTomador = controleAcessoDAO.retornaIdControleAcesso();
		double Score = 0;
		List<Avaliacao> avaliacao = new ArrayList<Avaliacao>();
		String sql = "SELECT Avaliacao.scoreRenda FROM Avaliacao WHERE Avaliacao.idTomador =" + ultimoTomador
				+ " AND Avaliacao.idCredor = 1";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Avaliacao av = new Avaliacao();
			av.setScoreRenda(rs.getDouble("scoreRenda"));
			ScoreRenda = av.getScoreRenda();
		}
		ps.close();
		rs.close();
		return ScoreRenda;
	}

	public double pegarScoreExercAtividade() throws SQLException {
		ControleAcessoDAO controleAcessoDAO = new ControleAcessoDAOImpl();
		int ultimoTomador = controleAcessoDAO.retornaIdControleAcesso();
		double Score = 0;
		List<Avaliacao> avaliacao = new ArrayList<Avaliacao>();
		String sql = "SELECT Avaliacao.scoreExerceAtividade FROM Avaliacao WHERE Avaliacao.idTomador =" + ultimoTomador
				+ " AND Avaliacao.idCredor = 1";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Avaliacao av = new Avaliacao();
			av.setScoreExerceAtividade(rs.getDouble("scoreExerceAtividade"));
			ScoreExercAtividade = av.getScoreExerceAtividade();
		}
		ps.close();
		rs.close();
		return ScoreExercAtividade;
	}

	public double pegarScoreTomador() throws SQLException {
		ControleAcessoDAO controleAcessoDAO = new ControleAcessoDAOImpl();
		int ultimoTomador = controleAcessoDAO.retornaIdControleAcesso();
		double Score = 0;
		List<Avaliacao> avaliacao = new ArrayList<Avaliacao>();
		String sql = "SELECT Avaliacao.scoreTomador FROM Avaliacao WHERE Avaliacao.idTomador =" + ultimoTomador
				+ " AND Avaliacao.idCredor = 1";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Avaliacao av = new Avaliacao();
			av.setScoreTomador(rs.getDouble("scoreTomador"));
			ScoreTomador = av.getScoreTomador();
		}
		ps.close();
		rs.close();
		return ScoreTomador;
	}

	@Override
	public List<Avaliacao> pegarTodosResultados() throws SQLException {
		ControleAcessoDAOImpl controleAcessoDAOImpl = new ControleAcessoDAOImpl();
		int idTomador = controleAcessoDAOImpl.retornaIdControleAcesso();
		List<Avaliacao> lista = new ArrayList<Avaliacao>();
		String sql = "SELECT Avaliacao.scoreTomador, Avaliacao.scoreExerceAtividade, Avaliacao.scoreDivida, Avaliacao.scorePendencia,Avaliacao.scoreRenda ,Avaliacao.scoreFinal FROM Avaliacao WHERE Avaliacao.idTomador = "
				+ idTomador + " AND Avaliacao.idCredor = 1";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Avaliacao av = new Avaliacao();
			av.setScoreTomador(rs.getDouble("scoreTomador"));
			av.setScoreExerceAtividade(rs.getDouble("scoreExerceAtividade"));
			av.setScoreDivida(rs.getDouble("scoreDivida"));
			av.setScorePendencia(rs.getDouble("scorePendencia"));
			av.setScoreRenda(rs.getDouble("scoreRenda"));
			av.setScoreFinal(rs.getDouble("scoreFinal"));
			lista.add(av);
		}
		ps.close();
		rs.close();
		return lista;

	}

	/*@Override
	public double pegarScoreAtivo() throws SQLException {
		
		return ScoreAtivo;
	}*/

}
