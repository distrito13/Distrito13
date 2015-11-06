package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.Avaliacao;
import fatec.edu.models.Credor_provavelmentevaisair;
import fatec.edu.models.Tomador;

public interface AvaliacaoDAO {

	public void gravarScoreTomador(Avaliacao avaliacao)  ;

	public Avaliacao pesquisarScoreIDTomador(int id)  ;

	public List<Avaliacao> pesquisarHistorioScoreIDTomador(int id) ;

	public void deletarScoreTomador(Avaliacao av) ;

}
