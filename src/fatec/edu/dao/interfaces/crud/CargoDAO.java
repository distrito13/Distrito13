package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.Cargo;

public interface CargoDAO {
	public void manter(Cargo cargo) throws SQLException;

	public List<Cargo> pesquisar() throws SQLException;

	public void remover(Cargo cargo) throws SQLException;
}
