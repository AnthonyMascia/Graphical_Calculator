import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Clear implements ActionListener {
	private Label label; //declarations: private
	private static String equation;
	private Button minus, plus, divide, multiply, rightpar, equal, delete;
	
	
	public Clear(Label l, String eq, Button min, Button pl, Button div,
			     Button mult, Button rpar, Button equals2, Button del){
		label = l; 
		equation = eq;
		minus = min;
		plus = pl;
		divide = div;
		multiply = mult;
		rightpar = rpar;
		equal = equals2;
		delete = del;
	}	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		label.setText(""); //what ever is currently in label.. essentially delete
		equation = label.getText(); //declare empty string as the new equation string to start over
		
		//Disable operator buttons again so user cant enter an invalid operation first
		minus.setEnabled(false);
		plus.setEnabled(false);
		divide.setEnabled(false);
		multiply.setEnabled(false);
		rightpar.setEnabled(false);
		equal.setEnabled(false);
		delete.setEnabled(false);
	}
	
	


}