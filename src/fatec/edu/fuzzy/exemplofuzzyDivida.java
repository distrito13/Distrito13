package fatec.edu.fuzzy;

import javax.swing.JOptionPane;

import fatec.edu.models.Divida;
import fatec.edu.models.ExercAtividade;
import fatec.edu.models.Renda;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class exemplofuzzyDivida {
	private FIS fis;
	
	public void Fuzzy() {

		String fileName = "rules.fcl"; 
										
		fis = FIS.load(fileName, true);
		

		if (fis == null) {

			
			JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo .fcl");
		}
	}
	public double  getScore(ExercAtividade atividade , Renda rend) {

	
		FunctionBlock qi = fis.getFunctionBlock("fuzzyficarDivida");

		
		qi.setVariable("dificuldade", atividade.getSalario());
		qi.setVariable("porMTM", rend.getValor());


		qi.evaluate();

		return qi.getVariable("scorePorcentagem").getValue();
	}


}
