package fatec.edu.verificarExistencia;

import java.sql.SQLException;


/*
 * Interface para os m�todos de valida��o do banco de dados
 */
public interface ValidaExistenciaDAO {

	public boolean verificaExistenciaCpf(String cpf) throws SQLException;

	public boolean verificaExistenciaCnpj(String cnpj) throws SQLException;

}
