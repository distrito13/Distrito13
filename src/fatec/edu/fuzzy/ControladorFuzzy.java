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

public class ControladorFuzzy {
	private FIS fis ;


	public ControladorFuzzy() throws IOException{
		
		/*ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Properties properties = new Properties();
		properties.load(classLoader.getResourceAsStream("default.fcl"));*/
				
		

		/*File dir1 = new File ("");  
		StringBuffer sb = new StringBuffer();
		//sb.append(dir1.getCanonicalPath());
		sb.append(dir1.getAbsolutePath());
		sb.append("\\src\\default.fcl");*/
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
	    URL url = loader.getResource("..\\default.fcl");
	    System.out.println("url:"+url);
	    File fclFile = null;
	    fclFile = new File(url.getPath());
	    System.out.println(fclFile.getAbsolutePath());
 
		this.fis = FIS.load(fclFile.toString(), true);
		System.out.println("após carregar arquivo");
	}
	

	public ControladorFuzzy(String nomeArquivo){

		File dir1 = new File ("");  
		StringBuffer sb = new StringBuffer();
		try {
			sb.append(dir1.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//sb.append("\\src\\"+nomeArquivo);
		sb.append(nomeArquivo);

		this.fis = FIS.load(sb.toString(), true);
	}	


	public double getScoreSalario (QuestionarioPtII salario , double tempotrab , int estabilidade ){
			System.out.println("entrou em getScoreSalario:somasalario:"+salario.getSalario()+"-tempotrab:"+tempotrab+"estab:"+estabilidade);
		FunctionBlock blocosalario= fis.getFunctionBlock("SalarioTomador");
		System.out.println("chamablocosalario do fuzzy");
		blocosalario.setVariable("salario", salario.getSalario());
		blocosalario.setVariable("estabilidade", estabilidade);
		blocosalario.setVariable("tempoTrabalhando",tempotrab);
		System.out.println("define as variaveis de bloco");
		blocosalario.evaluate();
		System.out.println("evaluate:"+"variavel salario do bloco"+blocosalario.getVariable("salario"));
		double scoreRenda = blocosalario.getVariable("scorePorcentagem").getValue();

		System.out.println("pegaporcentagem a partir de bloco salario:"+scoreRenda);
		System.out.println("antes do return");
		return scoreRenda ;
		




	}
	public double getScoreRenda (QuestionarioPtIII renda){
		
		FunctionBlock blocorenda= fis.getFunctionBlock("RendaTomador");
		blocorenda.setVariable("renda", renda.getValor());
		blocorenda.setVariable("periodo", Double.parseDouble(renda.getPeriodo()));
		blocorenda.evaluate();
		double scoreRenda = blocorenda.getVariable("scorePorcentagem").getValue();
		
		
		
		return scoreRenda ;
		
		
		
		
	}
	
	public double getScoreCapital (double scoreRenda , double scoreSalario){
		FunctionBlock blocoCapital= fis.getFunctionBlock("CapitalTomador");
		blocoCapital.setVariable("renda", scoreRenda);
		blocoCapital.setVariable("salario", scoreSalario);
		blocoCapital.evaluate();
		double scoreCapital = blocoCapital.getVariable("scorePorcentagem").getValue();
		return scoreCapital;
		
		
	}
	
	public double getScoreDivida ( QuestionarioPtIV divida){
		FunctionBlock blocodivida= fis.getFunctionBlock("DividaTomador");
		blocodivida.setVariable("divida", divida.getValor());
		blocodivida.evaluate();
		double scoreDivida = blocodivida.getVariable("scorePorcentagem").getValue();
		
		return scoreDivida;
	}
	
	public double getScorePedencia (QuestionarioPtV pendencia , int atraso ){
		FunctionBlock blocoPendencia= fis.getFunctionBlock("PendenciaTomador");
		blocoPendencia.setVariable("pendencia", pendencia.getValor());
		blocoPendencia.setVariable("atraso", atraso);
		blocoPendencia.setVariable("periodo", Double.parseDouble(pendencia.getPeriodo()));
		blocoPendencia.evaluate();
		double scoreCapital = blocoPendencia.getVariable("scorePorcentagem").getValue();
		return scoreCapital;
		
		
	}
	
	
	public double getScoreGastos (double scoreDivida , double scorePendencia){
		
		FunctionBlock blocogastos= fis.getFunctionBlock("GastosTomador");
		blocogastos.setVariable("divida", scoreDivida);
		blocogastos.setVariable("pendencia", scorePendencia);
		
		blocogastos.evaluate();
		double scoreGastos = blocogastos.getVariable("scorePorcentagem").getValue();
		
		return scoreGastos;
		
	}
	
	
	public double getScoreTomador (double scoreCapital , double scoreGastos){
		
		FunctionBlock blocoTomador= fis.getFunctionBlock("ScoreTomador");
		blocoTomador.setVariable("capital", scoreCapital);
		blocoTomador.setVariable("gastos", scoreGastos);
		
		blocoTomador.evaluate();
		double scoreTomador = blocoTomador.getVariable("scorePorcentagem").getValue();
		
		return scoreTomador;
		
	}
	
	
	public double getScoreTomadorFinal (double scoreTomador , double valorEmprestimo){
		
		FunctionBlock blocoTomador= fis.getFunctionBlock("EmprestimoTomador");
		blocoTomador.setVariable("Tomador", scoreTomador);
		blocoTomador.setVariable("Emprestimo", valorEmprestimo);
		
		blocoTomador.evaluate();
		double scoreTomadorFinal = blocoTomador.getVariable("scorePorcentagem").getValue();
		
		return scoreTomadorFinal;
		
	}

}
