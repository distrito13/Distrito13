package fatec.edu.dao.implementation.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIDAO;
import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.Sexo;

public class QuestionarioPtIDAOImpl implements QuestionarioPtIDAO{

	Connection conection;
	private static int contador = 0;

	public QuestionarioPtIDAOImpl(){
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}
	
	
	@Override
	public void manter(QuestionarioPtI questionarioPtI) throws SQLException {
		String sql = "insert into Tomadores Values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		
		SexoDAOImpl sex = new SexoDAOImpl();
		Sexo sexy = new Sexo();
		
//		questionarioPtI.setSexo(sex.pesquisar().toString());
		
		
	questionarioPtI.setSexo(sexy.getSexo());

	System.out.println(questionarioPtI.getSexo());
		
		
//		
//		ps.setString(1, questionarioPtI.getCpf());
//		ps.setString(2, questionarioPtI.getNome());
//		ps.setDate(3,new java.sql.Date(questionarioPtI.getData().getTime()));
//		ps.setString(4, questionarioPtI.getFiliacaoI());
//		ps.setString(5, questionarioPtI.getFiliacaoII());
//		ps.setString(6, questionarioPtI.getSexo());
//		ps.setInt(7, questionarioPtI.getEstadoCivil());
//		ps.setInt(8, questionarioPtI.getRegimeCasamento());
//		ps.setString(9, questionarioPtI.getIdEstado());
//		ps.setString(10, questionarioPtI.getIdCidade());
		
		ps.execute();
		ps.close();
		
	}


	@Override
	public List<Sexo> buscarSexo() throws SQLException {

		List<Sexo> lista = new ArrayList<Sexo>();
		String sql = "SELECT sexo FROM Sexos";
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Sexo sexo = new Sexo();
			sexo.setSexo(rs.getString("sexo"));
			lista.add(sexo);
			contador +=1;
			
			
		}
		System.out.println("A quantidade de Registros é : "+contador);
		ps.close();
		rs.close();
		return lista;
	}

	

}
