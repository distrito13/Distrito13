package fatec.edu.verificarExistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.loginEmpresa.Credor;
import fatec.edu.models.Tomador;

/*
 * Classe para fazer consulta no banco de dados e verificar a existencia de um dado específico 
 * já cadastrado na base de dados.
 */
public class ValidaExistenciaDAOImpl implements ValidaExistenciaDAO {

	Connection con;

	public ValidaExistenciaDAOImpl() {
		GenericDAO gDAO = new GenericDAO();
		con = gDAO.getConnection();
	}

	/*
	 * Método criado para consultar um cpf específico no banco de dados.
	 * (non-Javadoc)
	 * 
	 * @see
	 * fatec.edu.verificarExistencia.ValidaExistenciaDAO#verificaExistenciaCpf()
	 */

	@Override
	public boolean verificaExistenciaCpf(String cpf) throws SQLException {
		Tomador tomador = new Tomador();
		List<Tomador> listaCpf = new ArrayList<Tomador>();
		String sql = "select * from Tomadores where cpf =" + cpf;
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			tomador.setCpf("cpf");
			listaCpf.add(tomador);
			return true;
		}
		ps.close();
		rs.close();
		return false;
	}

	/*
	 * Método criado para consultar um cnpj específico no banco de dados.
	 * (non-Javadoc)
	 * 
	 * @see
	 * fatec.edu.verificarExistencia.ValidaExistenciaDAO#verificaExistenciaCnpj(
	 * )
	 */
	@Override
	public boolean verificaExistenciaCnpj(String cnpj) throws SQLException {
		Credor credor = new Credor();
		List<Credor> listaCnpj = new ArrayList<Credor>();
		String sql = "select * from Credor where cnpj =" + cnpj;
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			credor.setCnpj("cnpj");
			listaCnpj.add(credor);
			return true;
		}
		ps.close();
		rs.close();
		return false;
	}

}
