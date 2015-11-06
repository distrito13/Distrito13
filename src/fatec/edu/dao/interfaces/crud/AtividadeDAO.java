package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.Atividade_vaisair;

public interface AtividadeDAO {
	public void manter(Atividade_vaisair atividade) throws SQLException;

	public List<Atividade_vaisair> pesquisar() throws SQLException;

	public void remover(Atividade_vaisair atividade) throws SQLException;
}
