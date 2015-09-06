package fatec.edu.mb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fatec.edu.dao.implementation.crud.AtivoDAOImpl;
import fatec.edu.dao.interfaces.crud.AtivoDAO;
import fatec.edu.models.Ativo;

@ManagedBean
@SessionScoped
public class AtivoManagedBean {

	private Ativo ativoAtual;
	private List<Ativo> ativos;
	private AtivoDAO ativoDao;

	public AtivoManagedBean() {
		setAtivoAtual(new Ativo());
		setAtivoDao(new AtivoDAOImpl());
		setAtivos(new ArrayList<Ativo>());
	}
	
	public String adicionarAtivo(){
		try {
			getAtivoDao().manter(getAtivoAtual());
			setAtivoAtual(new Ativo());
			setAtivos(getAtivoDao().pesquisar());
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "";
	}
	

	public Ativo getAtivoAtual() {
		return ativoAtual;
	}

	
	public void remover(Ativo ativo){
		try {
			ativoDao.remover(ativo);
			setAtivos(getAtivoDao().pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Passei aqui");
	}
	
	
	
	
	
	public void editar(Ativo ativo){
		setAtivoAtual(ativo);
	}

	

	public List<Ativo> getAtivos() {
		return ativos;
	}

	public void setAtivos(List<Ativo> ativos) {
		this.ativos = ativos;
	}

	public AtivoDAO getAtivoDao() {
		return ativoDao;
	}

	public void setAtivoDao(AtivoDAO ativoDao) {
		this.ativoDao = ativoDao;
	}

	public void setAtivoAtual(Ativo ativoAtual) {
		this.ativoAtual = ativoAtual;
	}



}
