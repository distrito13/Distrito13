package fatec.edu.mb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import fatec.edu.dao.implementation.crud.CidadeDAOImpl;
import fatec.edu.dao.implementation.crud.EstadoDAOImpl;
import fatec.edu.dao.implementation.crud.QuestionarioPtIDAOImpl;
import fatec.edu.dao.implementation.crud.SexoDAOImpl;
import fatec.edu.dao.interfaces.crud.CidadeDAO;
import fatec.edu.dao.interfaces.crud.EstadoDAO;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIDAO;
import fatec.edu.dao.interfaces.crud.SexoDAO;
import fatec.edu.enumeration.RegimeCasamento;
import fatec.edu.models.Cidade;
import fatec.edu.models.Estado;
import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.Sexo;

@ManagedBean
@SessionScoped
// @RequestScoped

public class QuestionarioPtIMB {

	private QuestionarioPtI questionarioPtIAtual;
	private QuestionarioPtIDAO questionarioPtIDAO;
	private List<Sexo> sexos;
	private List<Estado> estados;
	private SexoDAO sexoDAO;
	private CidadeDAO cidadesDAO;
	private EstadoDAO estadoDAO;
	private List<Cidade> cidades;
	private SelectItem[] regimeCasamento;
	
	private List  regimesCasamento;

	public QuestionarioPtIMB() {
		questionarioPtIAtual = new QuestionarioPtI();
		questionarioPtIDAO = new QuestionarioPtIDAOImpl();
		sexoDAO = new SexoDAOImpl();
		cidadesDAO = new CidadeDAOImpl();
		estadoDAO = new EstadoDAOImpl();

		try {
			setSexos(sexoDAO.pesquisar());
			setEstados(estadoDAO.pesquisar());
			setCidades(cidadesDAO.pesquisar());
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	
	@PostConstruct
	 public void init() {
		regimesCasamento = Arrays.asList(RegimeCasamento.values());
	 }
	 
	
	
	public String adicionar() {
		try {
			questionarioPtIDAO.manter(getQuestionarioPtIAtual());
			questionarioPtIAtual = new QuestionarioPtI();
			System.out.println("Esse é o id :D"+questionarioPtIDAO.pesquisarUltimoId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

	public QuestionarioPtIDAO getQuestionarioPtIDAO() {
		return questionarioPtIDAO;
	}

	public void setQuestionarioPtIDAO(QuestionarioPtIDAO questionarioPtIDAO) {
		this.questionarioPtIDAO = questionarioPtIDAO;
	}

	public QuestionarioPtI getQuestionarioPtIAtual() {
		return questionarioPtIAtual;
	}

	public void setQuestionarioPtIAtual(QuestionarioPtI questionarioPtIAtual) {
		this.questionarioPtIAtual = questionarioPtIAtual;
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

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public CidadeDAO getCidadesDAO() {
		return cidadesDAO;
	}

	public void setCidadesDAO(CidadeDAO cidadesDAO) {
		this.cidadesDAO = cidadesDAO;
	}

	public EstadoDAO getEstadoDAO() {
		return estadoDAO;
	}

	public void setEstadoDAO(EstadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public SelectItem[] getRegimeCasamento() {
		SelectItem[] items = new SelectItem[RegimeCasamento.values().length];
		int i = 0;
		for (RegimeCasamento regime : RegimeCasamento.values()) {
			items[i++] = new SelectItem(regime, regime.name());
		}
		return items;

	}

	public void setRegimeCasamento(SelectItem[] regimeCasamento) {
		this.regimeCasamento = regimeCasamento;
	}

	public List getRegimesCasamento() {
		return regimesCasamento;
	}

	public void setRegimesCasamento(List regimesCasamento) {
		this.regimesCasamento = regimesCasamento;
	}

}
