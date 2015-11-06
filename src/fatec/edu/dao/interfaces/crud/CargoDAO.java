package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.Cargo_vaisair;

public interface CargoDAO {
	public void manter(Cargo_vaisair cargo) throws SQLException;

	public List<Cargo_vaisair> pesquisar() throws SQLException;

	public void remover(Cargo_vaisair cargo) throws SQLException;
}
