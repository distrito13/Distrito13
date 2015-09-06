package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.Atividade;

public interface AtividadeDAO {
	public void manter(Atividade atividade) throws SQLException;

	public List<Atividade> pesquisar() throws SQLException;

	public void remover(Atividade atividade) throws SQLException;
}
