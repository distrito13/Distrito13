package fatec.edu.GerenciadorResultados;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.Avaliacao;

public interface GerenciaResultadosDAO {

	public double pegarScoreFinal() throws SQLException;

	public List<Avaliacao> pegarTodosResultados() throws SQLException;

	public double pegarScoreExercAtividade() throws SQLException;

	public double pegarScoreRenda() throws SQLException;

	public double pegarScoreDivida() throws SQLException;

	public double pegarScorePendencia() throws SQLException;
	
	public double pegarScoreTomador() throws SQLException;

	//public double pegarScoreAtivo() throws SQLException;
}
