import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EnableButtons implements ActionListener {
	
	private Button minus, plus, divide, multiply, rightpar, equal, delete;
	
	//Must pass through all buttons that will be enabled
	public EnableButtons(Button min, Button pl, Button div, Button mult, Button rpar,
						 Button equals2, Button del){
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
		//On click: enable following buttons
		minus.setEnabled(true);
		plus.setEnabled(true);
		divide.setEnabled(true);
		multiply.setEnabled(true);
		rightpar.setEnabled(true);
		equal.setEnabled(true);
		delete.setEnabled(true);
	}
	
	


}