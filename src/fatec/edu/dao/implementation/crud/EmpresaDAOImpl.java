package fatec.edu.dao.implementation.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.EmpresaDAO;
import fatec.edu.models.Empresa;

public class EmpresaDAOImpl implements EmpresaDAO {

	Connection conection;

	public EmpresaDAOImpl() {
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public void manter(Empresa empresa) throws SQLException {
		String sql = "INSERT INTO Empresas VALUES(?,?,?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setString(1, empresa.getRazaoSocial());
		ps.setString(2,empresa.getNomeFantasia());
		ps.setString(3, empresa.getCnpj());
		ps.execute();
		ps.close();
	}

	@Override
	public List<Empresa> pesquisar() throws SQLException {
		List<Empresa> lista = new ArrayList<Empresa>();
		String sql = "SELECT * FROM Empresas";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Empresa empresa = new Empresa();
			empresa.setIdEmpresa(rs.getInt("idEmpresa"));
			empresa.setRazaoSocial(rs.getString("razaoSocial"));
			empresa.setNomeFantasia(rs.getString("nomeFantasia"));
			empresa.setCnpj(rs.getString("cnpj"));
			lista.add(empresa);
		}
		ps.close();
		rs.close();
		return lista;
	}

	@Override
	public void remover(Empresa empresa) throws SQLException {
		String sql = "DELETE Empresas WHERE idEmpresa =?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, empresa.getIdEmpresa());
		ps.setString(2, empresa.getRazaoSocial());
		ps.setString(3, empresa.getNomeFantasia());
		ps.setString(4, empresa.getCnpj());
		ps.execute();
		ps.close();
	}

}
