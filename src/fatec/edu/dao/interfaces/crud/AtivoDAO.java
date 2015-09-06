package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.Ativo;

public interface AtivoDAO {

	public void manter(Ativo ativo) throws SQLException;

	public List<Ativo> pesquisar() throws SQLException;

	public void remover(Ativo ativo) throws SQLException;
}
