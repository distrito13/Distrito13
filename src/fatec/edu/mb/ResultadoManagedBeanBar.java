package fatec.edu.mb;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import fatec.edu.dao.implementation.crud.AvaliacaoGraficoDAOImpl;
import fatec.edu.dao.interfaces.crud.AvaliacaoGraficosDAO;
import fatec.edu.models.Avaliacao;

@ManagedBean
@SessionScoped
public class ResultadoManagedBeanBar implements Serializable{

	private static final long serialVersionUID = -1901076222129835811L;
	
	private BarChartModel graficoModel;

	@PostConstruct
    public void init() {
		listar();
    }
	
	
	public BarChartModel getGraficoModel() {
		return graficoModel;
	}

	public void setGraficoModel(BarChartModel graficoModel) {
		this.graficoModel = graficoModel;
	}


	public void listar(){
		AvaliacaoGraficosDAO agDAO;
		List<Avaliacao> lista;
		
		try {
			agDAO = new AvaliacaoGraficoDAOImpl();
			lista = agDAO.retornaScores();
			graficar(lista);
			graficoModel.setTitle("Gráfico dos Scores");
			graficoModel.setLegendPosition("n");
			graficoModel.setShowPointLabels(true);
			
			
			Axis xAxis = graficoModel.getAxis(AxisType.X);
	        xAxis.setLabel("Itens do Tomador");
	         
	        Axis yAxis = graficoModel.getAxis(AxisType.Y);
	        yAxis.setLabel("Score");
	        yAxis.setMin(0);
	        yAxis.setMax(100);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void graficar(List<Avaliacao> lista){
		graficoModel = new BarChartModel();
		
		ChartSeries exerce = new ChartSeries();
		exerce.setLabel("AP=Atividade Profissional");
		ChartSeries renda = new ChartSeries();
		renda.setLabel("R=Score Rendas");
		ChartSeries divida = new ChartSeries();
		divida.setLabel("D=Score de Dividas/Despesas");
		ChartSeries pendencia = new ChartSeries();
		pendencia.setLabel("P=Score de Pendências");
		ChartSeries tomador = new ChartSeries();
		tomador.setLabel("T=Score de Tomador");
		for (Avaliacao avaliacaoL: lista){
			exerce.set("AP",avaliacaoL.getScoreExerceAtividade());
			renda.set("R",avaliacaoL.getScoreRenda());
			divida.set("D",avaliacaoL.getScoreDivida());
			pendencia.set("P",avaliacaoL.getScorePendencia());
			tomador.set("T",avaliacaoL.getScoreTomador());
		}
		graficoModel.addSeries(exerce);
		graficoModel.addSeries(renda);
		graficoModel.addSeries(divida);
		graficoModel.addSeries(pendencia);
		graficoModel.addSeries(tomador);
		
		
	}
	


}
