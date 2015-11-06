package fatec.edu.dao.generic;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDAO implements Serializable{
	
	private static final long serialVersionUID = 4338567378340678479L;
	private Connection con;

	public Connection getConnection() {

		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			con = DriverManager
					.getConnection(
							"jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=FuzzyTCC2;namedPipe=true",
							"SaFuzzy", "123456");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public void fechaConexao() {
		try {
			if (con != null)
				con.close();
			con = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
