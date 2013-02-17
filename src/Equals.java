

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Equals implements ActionListener {
	private Label label; //declarations: private
	private String equation;
	
	
	public Equals(Label l, String eq){
		label = l; 
		equation = eq;
	}	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		equation = label.getText(); //gets what the string equation is currently holding
		Calculator calc = new Calculator(equation, label); //send equation to calculator class to be evaluated
	}


	


}
