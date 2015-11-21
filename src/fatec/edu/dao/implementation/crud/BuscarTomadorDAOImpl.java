package fatec.edu.dao.implementation.crud;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.BuscaEditarTomadorDAO;
import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.QuestionarioPtII;
import fatec.edu.models.QuestionarioPtIII;
import fatec.edu.models.QuestionarioPtIV;
import fatec.edu.models.QuestionarioPtV;

public class BuscarTomadorDAOImpl implements BuscaEditarTomadorDAO, Serializable {

	private static final long serialVersionUID = 7023196465446915909L;
	Connection conection;
	private String PA_NOME;
	private String Atividade, Empresa, Cargo;
	private Date dataAdm;
	private Double salario;

	public BuscarTomadorDAOImpl() {
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public List<QuestionarioPtI> listarTomadoresCadastrados() throws SQLException {

		List<QuestionarioPtI> lista = new ArrayList<QuestionarioPtI>();
		String sql = "SELECT * FROM Tomadores where idTomador = 9";
		PreparedStatement ps = conection.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			QuestionarioPtI questionarioPtI = new QuestionarioPtI();
			questionarioPtI.setId(rs.getInt("idTomador"));
			questionarioPtI.setCpf(rs.getString("cpf"));
			questionarioPtI.setNome(rs.getString("nome"));
			questionarioPtI.setData(rs.getDate("dataNasc"));
			questionarioPtI.setFiliacaoI(rs.getString("filiacaoResp1"));
			questionarioPtI.setFiliacaoII(rs.getString("filiacaoResp2"));
			questionarioPtI.setSexo(rs.getInt("idSexo"));
			questionarioPtI.setEstadoCivil(rs.getString("estadoCivil"));
			questionarioPtI.setRegimeCasamento(rs.getString("regimeCasamento"));
			questionarioPtI.setIdEstado(rs.getInt("idEstado"));
			questionarioPtI.setCidade(rs.getString("cidade"));
			questionarioPtI.setEscolaridade(rs.getString("escolaridade"));

			lista.add(questionarioPtI);
		}
		ps.close();
		rs.close();
		return lista;

	}

	@Override
	public List<QuestionarioPtI> buscaTomador(int idTomador) throws SQLException {
		List<QuestionarioPtI> lista = new ArrayList<QuestionarioPtI>();
		String sql = "SELECT cpf, nome, dataNasc, filiacaoResp1, filiacaoResp2, idSexo, estadoCivil, idEstado, cidade,escolaridade FROM Tomadores WHERE idTomador = idTomador";
		PreparedStatement ps = conection.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			QuestionarioPtI questionarioPtI = new QuestionarioPtI();
			questionarioPtI.setCpf(rs.getString("cpf"));
			questionarioPtI.setNome(rs.getString("nome"));
			questionarioPtI.setData(rs.getDate("dataNasc"));
			questionarioPtI.setFiliacaoI(rs.getString("filiacaoResp1"));
			questionarioPtI.setFiliacaoII(rs.getString("filiacaoResp2"));
			questionarioPtI.setSexo(rs.getInt("idSexo"));
			questionarioPtI.setEstadoCivil(rs.getString("estadoCivil"));
			questionarioPtI.setIdEstado(rs.getInt("idEstado"));
			questionarioPtI.setCidade(rs.getString("cidade"));
			questionarioPtI.setEscolaridade(rs.getString("escolaridade"));

			lista.add(questionarioPtI);
		}
		ps.close();
		rs.close();
		return lista;

	}

	@Override
	public String buscarNomeTomador(int idTomador) throws SQLException {
		String sql = "SELECT  nome FROM Tomadores WHERE idTomador =" + idTomador;
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			QuestionarioPtI qpti = new QuestionarioPtI();
			qpti.setNome(rs.getString("nome"));
			PA_NOME = qpti.getNome();
		}
		ps.close();
		rs.close();
		return PA_NOME;
	}

	@Override
	public String atividade(int idTomador) throws SQLException {
		String sql = "SELECT Atividade FROM ExerceAtividade WHERE idTomador =" + idTomador;
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			QuestionarioPtII qptii = new QuestionarioPtII();
			qptii.setIdAtividade(rs.getString("Atividade"));
			Atividade = qptii.getIdAtividade();
		}
		ps.close();
		rs.close();
		return Atividade;
	}

	@Override
	public String Empresa(int idTomador) throws SQLException {
		String sql = "SELECT Empresa FROM ExerceAtividade WHERE idTomador =" + idTomador;
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			QuestionarioPtII qptii = new QuestionarioPtII();
			qptii.setIdEmpresa(rs.getString("Empresa"));
			Empresa = qptii.getIdEmpresa();
		}
		ps.close();
		rs.close();
		return Empresa;
	}

	@Override
	public Date dataAdmissao(int idTomador) throws SQLException {
		String sql = "SELECT dataAdmissao FROM ExerceAtividade WHERE idTomador =" + idTomador;
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			QuestionarioPtII qptii = new QuestionarioPtII();
			qptii.setDataAdmissao(rs.getDate("dataAdmissao"));
			dataAdm = qptii.getDataAdmissao();
		}
		ps.close();
		rs.close();
		return dataAdm;
	}

	@Override
	public String cargo(int idTomador) throws SQLException {
		String sql = "SELECT cargo FROM ExerceAtividade WHERE idTomador =" + idTomador;
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			QuestionarioPtII qptii = new QuestionarioPtII();
			qptii.setIdCargo(rs.getString("cargo"));
			Cargo = qptii.getIdCargo();
		}
		ps.close();
		rs.close();
		return Cargo;
	}

	@Override
	public String salario(int idTomador) throws SQLException {
		String sql = "SELECT salario FROM ExerceAtividade WHERE idTomador =" + idTomador;
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			QuestionarioPtII qptii = new QuestionarioPtII();
			qptii.setSalario(rs.getDouble("salario"));
			salario = qptii.getSalario();
		}
		ps.close();
		rs.close();
		
		String sal;
		sal = String.valueOf(salario);
		return sal;
	}

	@Override
	public List<QuestionarioPtIII> buscarPorRenda(int idTomador) throws SQLException {
		List<QuestionarioPtIII> lista = new ArrayList<QuestionarioPtIII>();
		String sql = "SELECT valor,tipoRenda,periodo FROM Rendas where idTomador = " + idTomador;
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			QuestionarioPtIII questionarioPtIII = new QuestionarioPtIII();
			questionarioPtIII.setValor(rs.getDouble("valor"));
			questionarioPtIII.setTipoRenda(rs.getString("tipoRenda"));
			questionarioPtIII.setPeriodo(rs.getString("periodo"));
			lista.add(questionarioPtIII);
		}
		ps.close();
		rs.close();
		return lista;
	}

	@Override
	public List<QuestionarioPtIV> buscaroPorDivida(int idTomador) throws SQLException {
		List<QuestionarioPtIV> lista = new ArrayList<QuestionarioPtIV>();
		String sql = "SELECT valor, tipoDivida FROM Dividas where idTomador = " + idTomador;
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			QuestionarioPtIV questionarioPtIV = new QuestionarioPtIV();
			questionarioPtIV.setValor(rs.getDouble("valor"));
			questionarioPtIV.setTipoDivida(rs.getString("tipoDivida"));

			lista.add(questionarioPtIV);
		}
		ps.close();
		rs.close();
		return lista;
	}

	@Override
	public List<QuestionarioPtV> buscarPorPendencia(int idTomador) throws SQLException {
		List<QuestionarioPtV> lista = new ArrayList<QuestionarioPtV>();
		String sql = " SELECT dataAtraso, tipoPendencia, valor, periodo FROM Pendencias where idTomador = " + idTomador;
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			QuestionarioPtV questionarioPtV = new QuestionarioPtV();
			questionarioPtV.setDataAtraso(rs.getDate("dataAtraso"));
			questionarioPtV.setTipoPendencia(rs.getString("tipoPendencia"));
			questionarioPtV.setValor(rs.getDouble("valor"));
			questionarioPtV.setPeriodo(rs.getString("periodo"));
			lista.add(questionarioPtV);
		}
		ps.close();
		rs.close();
		return lista;
	}

	@Override
	public void darUpdateTomador(int idTomador) throws SQLException {
		
	
	}
}
