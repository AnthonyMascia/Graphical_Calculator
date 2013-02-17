package Numbers;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LabelChangerSev implements ActionListener {
	private Label label; //declarations: private
	private String equation;
	
	
	public LabelChangerSev(Label l, String eq){
		label = l; 
		equation = eq;
	}	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		equation = label.getText(); //gets what the string equation is currently holding
		label.setText(equation + "7"); //display on the label the equation so far plus to appropriate num/operator
		equation = label.getText(); //add on the last pressed num/operation to the equation
	}
	


}
