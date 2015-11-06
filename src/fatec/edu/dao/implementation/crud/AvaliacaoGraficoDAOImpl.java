package fatec.edu.dao.implementation.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.edu.controle.acesso.ControleAcessoDAO;
import fatec.edu.controle.acesso.ControleAcessoDAOImpl;
import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.AvaliacaoGraficosDAO;
import fatec.edu.models.Avaliacao;

public class AvaliacaoGraficoDAOImpl implements AvaliacaoGraficosDAO {

	Connection conection;
	Avaliacao avaliacao;

	public AvaliacaoGraficoDAOImpl() {
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public List<Avaliacao> retornaScores() throws SQLException {
		ControleAcessoDAO controleAcessoDAO = new ControleAcessoDAOImpl();
		int ultimoTomador = controleAcessoDAO.retornaIdControleAcesso();

		List<Avaliacao> avaliacao = new ArrayList<Avaliacao>();
		String sql = "SELECT scoreTomador, scoreExerceAtividade, scoreRenda, scoreDivida, scorePendencia FROM Avaliacao WHERE idTomador = "
				+ ultimoTomador;
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Avaliacao av = new Avaliacao();
			av.setScoreTomador(rs.getDouble("scoreTomador"));
			av.setScoreExerceAtividade(rs.getDouble("scoreExerceAtividade"));
			av.setScoreRenda(rs.getDouble("scoreRenda"));
			av.setScoreDivida(rs.getDouble("scoreDivida"));
			av.setScorePendencia(rs.getDouble("scorePendencia"));
			avaliacao.add(av);
		}
		ps.close();
		rs.close();

		return avaliacao;
	}

}
