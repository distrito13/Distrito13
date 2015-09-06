package fatec.edu.mb;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fatec.edu.dao.implementation.crud.CargoDAOImpl;
import fatec.edu.dao.interfaces.crud.CargoDAO;
import fatec.edu.models.Cargo;

@ManagedBean
@SessionScoped
public class CargoManagedBean {

	private Cargo cargoAtual;
	private CargoDAO cargoDAO;
	private List<Cargo> cargos;

	public CargoManagedBean() {
		setCargoAtual(new Cargo());
		cargoDAO = new CargoDAOImpl();
		try {
			setCargos(cargoDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String adicionarTipo(){
		try {
			cargoDAO.manter(getCargoAtual());
			cargoAtual = new Cargo();
			setCargos(cargoDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public void remover(Cargo cargo){
		try {
			cargoDAO.remover(cargoAtual);
			setCargos(cargoDAO.pesquisar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editar(Cargo cargo){
		cargoAtual = cargo;
	}
	
	public Cargo getCargoAtual() {
		return cargoAtual;
	}

	public void setCargoAtual(Cargo cargoAtual) {
		this.cargoAtual = cargoAtual;
	}

	public CargoDAO getCargoDAO() {
		return cargoDAO;
	}

	public void setCargoDAO(CargoDAO cargoDAO) {
		this.cargoDAO = cargoDAO;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

}
