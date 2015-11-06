package fatec.edu.configuracoes.editarTomador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.QuestionarioPtIII;

@ManagedBean
@SessionScoped
public class ConfiguracoesEditarTomadorManagedBean {

	private QuestionarioPtI questionarioPtIAtual;
	private QuestionarioPtIII questionarioPtIIIAtual;

	private ConfiguracoesEditarTomadorDAO configuracoesEditarTomadorDAO;

	private List<QuestionarioPtI> tomadores;
	private List<QuestionarioPtIII> listaRenda;

	private List<QuestionarioPtI> preencheAbaTomadores;

	private List<QuestionarioPtI> filtrotomadores;

	public ConfiguracoesEditarTomadorManagedBean() {
		questionarioPtIAtual = new QuestionarioPtI();
		questionarioPtIIIAtual = new QuestionarioPtIII();
		tomadores = new ArrayList<QuestionarioPtI>();
		listaRenda = new ArrayList<QuestionarioPtIII>();
		configuracoesEditarTomadorDAO = new ConfiguracoesEditarTomadorDAOImpl();
		try {
			setTomadores(configuracoesEditarTomadorDAO.retornaUsuariodaSessionparaFazerOFiltro());
			setListaRenda(configuracoesEditarTomadorDAO.retornaListadeRendasDoTomador());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void pegarOTomadorParaPreencherAPrimeiraAba() throws SQLException {
		System.out.println("ID SELECIONADO" + questionarioPtIAtual.getId());
		String nome = configuracoesEditarTomadorDAO.buscarNomeTomador(questionarioPtIAtual.getId());
		System.out.println("O nome DO SER VIVO : " + nome);
		questionarioPtIAtual.setNome(nome);

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("editarAbas.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void editarRenda(QuestionarioPtIII q) {
		questionarioPtIIIAtual = q;
		try {
			setListaRenda(configuracoesEditarTomadorDAO.retornaListadeRendasDoTomador());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<QuestionarioPtI> getTomadores() {
		return tomadores;
	}

	public void setTomadores(List<QuestionarioPtI> tomadores) {
		this.tomadores = tomadores;
	}

	public QuestionarioPtI getQuestionarioPtIAtual() {
		return questionarioPtIAtual;
	}

	public void setQuestionarioPtIAtual(QuestionarioPtI questionarioPtIAtual) {
		this.questionarioPtIAtual = questionarioPtIAtual;
	}

	public List<QuestionarioPtI> getFiltrotomadores() {
		return filtrotomadores;
	}

	public void setFiltrotomadores(List<QuestionarioPtI> filtrotomadores) {
		this.filtrotomadores = filtrotomadores;
	}

	public List<QuestionarioPtIII> getListaRenda() {
		return listaRenda;
	}

	public void setListaRenda(List<QuestionarioPtIII> listaRenda) {
		this.listaRenda = listaRenda;
	}

	public QuestionarioPtIII getQuestionarioPtIIIAtual() {
		return questionarioPtIIIAtual;
	}

	public void setQuestionarioPtIIIAtual(QuestionarioPtIII questionarioPtIIIAtual) {
		this.questionarioPtIIIAtual = questionarioPtIIIAtual;
	}

	public List<QuestionarioPtI> getPreencheAbaTomadores() {
		return preencheAbaTomadores;
	}

	public void setPreencheAbaTomadores(List<QuestionarioPtI> preencheAbaTomadores) {
		this.preencheAbaTomadores = preencheAbaTomadores;
	}

}
