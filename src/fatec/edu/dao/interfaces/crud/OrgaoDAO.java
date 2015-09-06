package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.Orgao;


public interface OrgaoDAO {

	public void manter(Orgao orgao) throws SQLException;

	public List<Orgao> pesquisar() throws SQLException;

	public void remover(Orgao orgao) throws SQLException;
}
