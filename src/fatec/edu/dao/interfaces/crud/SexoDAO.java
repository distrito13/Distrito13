package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.Sexo;

public interface SexoDAO {
	public void manter(Sexo sexo) throws SQLException;

	public List<Sexo> pesquisar() throws SQLException;

	public void remover(Sexo sexo) throws SQLException;
}
