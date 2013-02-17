import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Delete implements ActionListener {
	private Label label; //declarations: private
	private static String equation;
	
	
	public Delete(Label l, String eq){
		label = l; 
		equation = eq;
	}	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		equation = label.getText(); //gets what the string equation is currently holding
		String del = equation.substring(0, equation.length()-1);
		label.setText(del); //display on the label the equation so far plus to appropriate num/operator
		equation = label.getText(); //add on the last pressed num/operation to the equation
	}
	
	


}
