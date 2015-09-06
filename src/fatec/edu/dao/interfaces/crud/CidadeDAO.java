package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.Cidade;

public interface CidadeDAO {

	public void manter(Cidade cidade) throws SQLException;

	public List<Cidade> pesquisar() throws SQLException;

	public void remover(Cidade cidade) throws SQLException;
}
