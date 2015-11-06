package fatec.edu.mb;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fatec.edu.dao.implementation.crud.BuscarTomadorDAOImpl;
import fatec.edu.dao.interfaces.crud.BuscaEditarTomadorDAO;
import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.QuestionarioPtII;
import fatec.edu.models.QuestionarioPtIII;
import fatec.edu.models.QuestionarioPtIV;
import fatec.edu.models.QuestionarioPtV;

@ManagedBean
@SessionScoped
public class BuscaEditarTomadorManagedBean implements Serializable {

	private static final long serialVersionUID = 9035634014240879661L;
	private QuestionarioPtI questionarioPtIAtual;
	private QuestionarioPtII questionarioPtIIAtual;
	private QuestionarioPtIII questionarioPtIIIAtual;
	private QuestionarioPtIV questionarioPtIVAtual;
	private QuestionarioPtV questionarioPtVAtual;
	private List<QuestionarioPtI> buscarTomadores;
	private BuscaEditarTomadorDAO buscarTomadorDAO;
	private QuestionarioPtI questionarioPtISelecionado;
	private List<QuestionarioPtI> filtrobuscarTomadores;
	private List<QuestionarioPtIII> buscarRendas;
	private List<QuestionarioPtIV> buscarDividas;
	private List<QuestionarioPtV> buscarPendencias;
	private String Atividade, Empresa, Cargo;
	private Date dataAdm;
	private String salario;

	public BuscaEditarTomadorManagedBean() {
		questionarioPtIAtual = new QuestionarioPtI();
		questionarioPtIIAtual = new QuestionarioPtII();
		buscarTomadorDAO = new BuscarTomadorDAOImpl();
		buscarTomadores = new ArrayList<QuestionarioPtI>();
		filtrobuscarTomadores = new ArrayList<QuestionarioPtI>();
		try {
			setBuscarTomadores(buscarTomadorDAO.listarTomadoresCadastrados());
			setFiltrobuscarTomadores(buscarTomadorDAO.listarTomadoresCadastrados());
			setBuscarRendas(buscarTomadorDAO.buscarPorRenda(questionarioPtIAtual.getId()));
			setBuscarDividas(buscarTomadorDAO.buscaroPorDivida(questionarioPtIAtual.getId()));
			setBuscarPendencias(buscarTomadorDAO.buscarPorPendencia(questionarioPtIAtual.getId()));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		questionarioPtIIAtual.setIdAtividade(Atividade);
		questionarioPtIIAtual.setIdEmpresa(Empresa);
		questionarioPtIIAtual.setDataAdmissao(dataAdm);
		questionarioPtIIAtual.setIdCargo(Cargo);
		// --------------deu PAU questionarioPtIIAtual.setSalario(salario);
	}

	public void editarAE() throws SQLException {

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("editarAbas.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<QuestionarioPtI> getbuscarTomadores() {
		return buscarTomadores;
	}

	public void setBuscarTomadores(List<QuestionarioPtI> buscarTomadores) {
		this.buscarTomadores = buscarTomadores;
	}

	public void setquestionarioPtIAtual(QuestionarioPtI questionarioPtIAtual) {

		this.questionarioPtIAtual = questionarioPtIAtual;

	}

	public QuestionarioPtI getQuestionarioPtIAtual() {
		return questionarioPtIAtual;
	}

	public void setBuscarTomadorDAO(BuscaEditarTomadorDAO buscarTomadorDAO) {
		this.buscarTomadorDAO = buscarTomadorDAO;
	}

	public BuscaEditarTomadorDAO getBuscarTomadorDAO() {
		return buscarTomadorDAO;
	}

	public QuestionarioPtI getQuestionarioPtISelecionado() {
		return questionarioPtISelecionado;
	}

	public void setQuestionarioPtISelecionado(QuestionarioPtI questionarioPtISelecionado) {
		this.questionarioPtISelecionado = questionarioPtISelecionado;
	}

	public List<QuestionarioPtI> getFiltrobuscarTomadores() {
		return filtrobuscarTomadores;
	}

	public void setFiltrobuscarTomadores(List<QuestionarioPtI> filtrobuscarTomadores) {
		this.filtrobuscarTomadores = filtrobuscarTomadores;
	}

	public QuestionarioPtII getQuestionarioPtIIAtual() {
		return questionarioPtIIAtual;
	}

	public void setQuestionarioPtIIAtual(QuestionarioPtII questionarioPtIIAtual) {
		this.questionarioPtIIAtual = questionarioPtIIAtual;
	}

	public String getAtividade() throws SQLException {
		return buscarTomadorDAO.atividade(questionarioPtIAtual.getId());
	}

	public void setAtividade(String atividade) {
		Atividade = atividade;
	}

	public String getEmpresa() throws SQLException {
		return buscarTomadorDAO.Empresa(questionarioPtIAtual.getId());
	}

	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}

	public Date getDataAdm() throws SQLException {
		return buscarTomadorDAO.dataAdmissao(questionarioPtIAtual.getId());
	}

	public void setDataAdm(Date dataAdm) {
		this.dataAdm = dataAdm;
	}

	public String getCargo() throws SQLException {
		return buscarTomadorDAO.cargo(questionarioPtIAtual.getId());
	}

	public void setCargo(String cargo) {
		Cargo = cargo;
	}

	
	public QuestionarioPtIII getQuestionarioPtIIIAtual() {
		return questionarioPtIIIAtual;
	}

	public void setQuestionarioPtIIIAtual(QuestionarioPtIII questionarioPtIIIAtual) {
		this.questionarioPtIIIAtual = questionarioPtIIIAtual;
	}

	public List<QuestionarioPtIII> getBuscarRendas() throws SQLException {
		return buscarTomadorDAO.buscarPorRenda(questionarioPtIAtual.getId());
	}

	public void setBuscarRendas(List<QuestionarioPtIII> buscarRendas) {
		this.buscarRendas = buscarRendas;
	}

	public List<QuestionarioPtIV> getBuscarDividas() throws SQLException {
		return buscarTomadorDAO.buscaroPorDivida(questionarioPtIAtual.getId());
	}

	public void setBuscarDividas(List<QuestionarioPtIV> buscarDividas) {
		this.buscarDividas = buscarDividas;
	}

	public List<QuestionarioPtV> getBuscarPendencias() throws SQLException {
		return buscarTomadorDAO.buscarPorPendencia(questionarioPtIAtual.getId());
	}

	public void setBuscarPendencias(List<QuestionarioPtV> buscarPendencias) {
		this.buscarPendencias = buscarPendencias;
	}

	public QuestionarioPtV getQuestionarioPtVAtual() {
		return questionarioPtVAtual;
	}

	public void setQuestionarioPtVAtual(QuestionarioPtV questionarioPtVAtual) {
		this.questionarioPtVAtual = questionarioPtVAtual;
	}

	public QuestionarioPtIV getQuestionarioPtIVAtual() {
		return questionarioPtIVAtual;
	}

	public void setQuestionarioPtIVAtual(QuestionarioPtIV questionarioPtIVAtual) {
		this.questionarioPtIVAtual = questionarioPtIVAtual;
	}

	public String getSalario() throws SQLException {
		return buscarTomadorDAO.salario(questionarioPtIAtual.getId());
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	

}
