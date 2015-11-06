package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.Avaliacao;

public interface AvaliacaoGraficosDAO  {

	public List<Avaliacao> retornaScores() throws SQLException;
	
}
