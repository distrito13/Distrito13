package fatec.edu.mb;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fatec.edu.dao.implementation.crud.SexoDAOImpl;
import fatec.edu.dao.interfaces.crud.SexoDAO;
import fatec.edu.models.Sexo;

@ManagedBean
@SessionScoped
public class SexoManagedBean {

	private Sexo sexoAtual;
	private SexoDAO sexoDAO;
	private List<Sexo> sexos;

	
	public SexoManagedBean(){
		setSexoAtual (new Sexo());
		sexoDAO = new SexoDAOImpl();
		try {
			setSexos(sexoDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String adicionarSexo(){
		try {
			sexoDAO.manter(getSexoAtual());
			sexoAtual = new Sexo();
			setSexos(sexoDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	public void remover(Sexo sexo){
		try {
			sexoDAO.remover(sexoAtual);
			setSexos(sexoDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editar(Sexo sexo){
		sexoAtual = sexo;
	}
	
	public List<Sexo> getSexos() {
		return sexos;
	}

	public void setSexos(List<Sexo> sexos) {
		this.sexos = sexos;
	}

	public SexoDAO getSexoDAO() {
		return sexoDAO;
	}

	public void setSexoDAO(SexoDAO sexoDAO) {
		this.sexoDAO = sexoDAO;
	}

	public Sexo getSexoAtual() {
		return sexoAtual;
	}

	public void setSexoAtual(Sexo sexoAtual) {
		this.sexoAtual = sexoAtual;
	}

}
