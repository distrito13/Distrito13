package fatec.edu.fuzzy;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import fatec.edu.models.ExercAtividade;
import fatec.edu.models.QuestionarioPtII;
import fatec.edu.models.QuestionarioPtIII;
import fatec.edu.models.QuestionarioPtIV;
import fatec.edu.models.QuestionarioPtV;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class ControladorFuzzy2 {
	private FIS fis;

	public ControladorFuzzy2() throws IOException {

		/*
		 * ClassLoader classLoader =
		 * Thread.currentThread().getContextClassLoader(); Properties properties
		 * = new Properties();
		 * properties.load(classLoader.getResourceAsStream("default.fcl"));
		 */

		/*
		 * File dir1 = new File (""); StringBuffer sb = new StringBuffer();
		 * //sb.append(dir1.getCanonicalPath());
		 * sb.append(dir1.getAbsolutePath()); sb.append("\\src\\default.fcl");
		 */

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("..\\default2.fcl");
		System.out.println("url:" + url);
		File fclFile = null;
		fclFile = new File(url.getPath());
		System.out.println(fclFile.getAbsolutePath());

		this.fis = FIS.load(fclFile.toString(), true);
		System.out.println("após carregar arquivo");
	}

	public ControladorFuzzy2(String nomeArquivo) {

		File dir1 = new File("");
		StringBuffer sb = new StringBuffer();
		try {
			sb.append(dir1.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// sb.append("\\src\\"+nomeArquivo);
		sb.append(nomeArquivo);

		this.fis = FIS.load(sb.toString(), true);
	}

	public double getScoreSalario(double salario, double tempotrab, int estabilidade) {

		FunctionBlock blocosalario = fis.getFunctionBlock("SalarioTomador");
		blocosalario.setVariable("salario", salario);
		blocosalario.setVariable("estabilidade", estabilidade);
		blocosalario.setVariable("tempoTrabalhando", tempotrab);
		blocosalario.evaluate();
		
		double scoreSalario = blocosalario.getVariable("scorePorcentagem").getValue();

		return scoreSalario;
	}

	public double getScoreRenda(double valor, double periodo) {

		FunctionBlock blocorenda = fis.getFunctionBlock("RendaTomador");
		blocorenda.setVariable("renda", valor);
		blocorenda.setVariable("periodo", periodo);
		blocorenda.evaluate();
		
		double scoreRenda = blocorenda.getVariable("scorePorcentagem").getValue();

		return scoreRenda;
	}

	public double getScoreCapital(double scoreRenda, double scoreSalario) {
		FunctionBlock blocoCapital = fis.getFunctionBlock("CapitalTomador");
		blocoCapital.setVariable("renda", scoreRenda);
		blocoCapital.setVariable("salario", scoreSalario);
		blocoCapital.evaluate();
		
		double scoreCapital = blocoCapital.getVariable("scorePorcentagem").getValue();
		
		return scoreCapital;
	}

	public double getScoreDivida(double valor) {
		FunctionBlock blocodivida = fis.getFunctionBlock("DividaTomador");
		blocodivida.setVariable("divida", valor);
		blocodivida.evaluate();
		
		double scoreDivida = blocodivida.getVariable("scorePorcentagem").getValue();

		return scoreDivida;
	}

	public double getScorePendencia(double valor, double periodo, int atraso) {
		FunctionBlock blocoPendencia = fis.getFunctionBlock("PendenciaTomador");
		blocoPendencia.setVariable("pendencia", valor);
		blocoPendencia.setVariable("periodo", periodo);
		blocoPendencia.setVariable("atraso", atraso);
		blocoPendencia.evaluate();
		
		double scorePendencia = blocoPendencia.getVariable("scorePorcentagem").getValue();
		
		return scorePendencia;
	}

	public double getScoreGastos(double scoreDivida, double scorePendencia) {

		FunctionBlock blocogastos = fis.getFunctionBlock("GastosTomador");
		blocogastos.setVariable("divida", scoreDivida);
		blocogastos.setVariable("pendencia", scorePendencia);
		blocogastos.evaluate();
		
		double scoreGastos = blocogastos.getVariable("scorePorcentagem").getValue();

		return scoreGastos;
	}

	// score referente a quantidade de automoveis/imoveis/terrenos
	public double getScoreAtivos(double veiculos, double imoveis, double terrenos) {

		FunctionBlock blocoTomador = fis.getFunctionBlock("AtivosTomador");
		blocoTomador.setVariable("veiculos", veiculos);
		blocoTomador.setVariable("imoveis", imoveis);
		blocoTomador.setVariable("terrenos", terrenos);
		blocoTomador.evaluate();
		
		double scoreAtivosTomador = blocoTomador.getVariable("scorePorcentagem").getValue();

		return scoreAtivosTomador;
	}

	// score referente a valor
	public double getScoreCapitalAtivos(double SomaAtivos, double salario) {

		FunctionBlock blocoTomador = fis.getFunctionBlock("CapitalAtivos");
		blocoTomador.setVariable("SomaAtivo", SomaAtivos);
		blocoTomador.setVariable("salario", salario);
		blocoTomador.evaluate();
		
		double scoreCapitalAtivos = blocoTomador.getVariable("scorePorcentagem").getValue();

		return scoreCapitalAtivos;
	}
	
	//score formado por capital(renda+salario) com gastos(divida+pendencia)
	public double getScoreTomador1(double scoreCapital, double scoreGastos) {

		FunctionBlock blocoTomador = fis.getFunctionBlock("ScoreTomador1");
		blocoTomador.setVariable("capital", scoreCapital);
		blocoTomador.setVariable("gastos", scoreGastos);
		blocoTomador.evaluate();
		
		double scoreTomador1 = blocoTomador.getVariable("scorePorcentagem").getValue();

		return scoreTomador1;
	}

	//score Ativos-formado por score de valor e score de numero de ativos-automoveis,imoveis,terrenos
	public double getScoreTomador2(double scoreCapitalAtivos, double scoreAtivoTomador) {

		FunctionBlock blocoTomador = fis.getFunctionBlock("ScoreTomador2");
		blocoTomador.setVariable("scoreCapitalAtivos", scoreCapitalAtivos);
		blocoTomador.setVariable("scoreAtivosTomador", scoreAtivoTomador);
		blocoTomador.evaluate();
		
		double scoreTomador2 = blocoTomador.getVariable("scorePorcentagem").getValue();

		return scoreTomador2;
	}
	
	//
	public double getScoreTomador3(double scoreTomador2, double escolaridade) {

		FunctionBlock blocoTomador = fis.getFunctionBlock("ScoreTomador3");
		blocoTomador.setVariable("scoreTomador2", scoreTomador2);
		blocoTomador.setVariable("escolaridade", escolaridade);
		blocoTomador.evaluate();
		
		double scoreTomador3 = blocoTomador.getVariable("scorePorcentagem").getValue();

		return scoreTomador3;
	}

	// score Tomador -FINAL
	public double getScoreTomadorFinal(double scoreTomador1, double scoreTomador3) {

		FunctionBlock blocoTomador = fis.getFunctionBlock("ScoreTomadorFinal");
		blocoTomador.setVariable("scoreTomador1", scoreTomador1);
		blocoTomador.setVariable("scoreTomador3", scoreTomador3);
		blocoTomador.evaluate();
		
		double scoreTomadorFinal = blocoTomador.getVariable("scorePorcentagem").getValue();

		return scoreTomadorFinal;
	}

	// score final após adicionar valor de emprestimo
	public double getScoreTomadorFinalEmprestimo(double scoreTomador, double valorEmprestimo) {

		FunctionBlock blocoTomador = fis.getFunctionBlock("EmprestimoTomador");
		blocoTomador.setVariable("Tomador", scoreTomador);
		blocoTomador.setVariable("Emprestimo", valorEmprestimo);
		blocoTomador.evaluate();
		
		double scoreTomadorFinal = blocoTomador.getVariable("scorePorcentagem").getValue();

		return scoreTomadorFinal;
	}

}
