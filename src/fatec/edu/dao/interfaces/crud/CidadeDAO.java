package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.Cidade_vaisair;

public interface CidadeDAO {

	public void manter(Cidade_vaisair cidade) throws SQLException;

	public List<Cidade_vaisair> pesquisar() throws SQLException;

	public void remover(Cidade_vaisair cidade) throws SQLException;
}
