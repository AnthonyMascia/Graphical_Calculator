//Anthony Mascia
//Java Programming
//Prof Boothe
//Project 3: Frame RPN Calculator
//February 12, 2012


import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import javax.swing.BoxLayout;

import Numbers.LabelChangerEight;
import Numbers.LabelChangerFive;
import Numbers.LabelChangerFour;
import Numbers.LabelChangerNine;
import Numbers.LabelChangerOne;
import Numbers.LabelChangerPoint;
import Numbers.LabelChangerSev;
import Numbers.LabelChangerSix;
import Numbers.LabelChangerThree;
import Numbers.LabelChangerTwo;
import Numbers.LabelChangerZero;
import Operations.LabelChangerDiv;
import Operations.LabelChangerLPAR;
import Operations.LabelChangerMinus;
import Operations.LabelChangerMult;
import Operations.LabelChangerPlus;
import Operations.LabelChangerRPAR;


@SuppressWarnings("serial")
public class Graphics extends Frame{ //make main a frame.. (button window IS A frame)

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Graphics bw = new Graphics();
		bw.addWindowListener(new Closer());//enables the "X" button to close the window
		bw.setSize(360, 500); //Resize calculator
		bw.setLocationRelativeTo(null);//Set it to the center of the screen
		bw.setTitle("Java Calculator: Anthony Mascia");
		bw.setCursor(1);
		bw.setVisible(true);//Makes frame visible
	}
	
	public Graphics(){ //acts as constructor for Graphics class
		
		super("Buttons"); //super makes "buttons" a frame because parent class is a frame (extends frame)
						  //calls the constructor for the "frame" class
		Label l = new Label("");
		String eq = "";
		l.setFont(new Font("Serif", Font.PLAIN, 30));
		
		//Create custom colors for buttons
		Color numBlue = new Color(113, 183, 240);
		Color opBlue = new Color(24, 137, 228);
		Color bgBlue = new Color(236, 245, 253);
		
		//Set color of label
		l.setBackground(bgBlue);
		
		Button nine = new Button("9");
		Button eight = new Button("8");
		Button sev = new Button("7");
		Button six = new Button("6");
		Button five = new Button("5");
		Button four = new Button("4");
		Button three = new Button("3");
		Button two = new Button("2");
		Button one = new Button("1");
		Button zero = new Button("0");
		Button plus = new Button("+");
		Button minus = new Button("-");
		Button div = new Button("/");
		Button mult = new Button("*");
		Button lpar = new Button("(");
		Button rpar = new Button(")");
		Button point = new Button(".");
		Button equals = new Button("=");
		Button clear = new Button("Clear");
		Button delete = new Button("Del");
		
		
		
		
		//Change color and font of all buttons
		Button[] numColors = {nine, eight, sev, six, five, four, three, two, one, zero,
						      lpar, rpar, point};		
		for(int i = 0; i < numColors.length; i++){
			numColors[i].setBackground(numBlue);
			numColors[i].setFont(new Font("Serif", Font.PLAIN, 25));
		}
		Button[] opColors = {plus, minus, div, clear, mult, equals, delete};
		for(int i = 0; i < opColors.length; i++){
			opColors[i].setBackground(opBlue);
			opColors[i].setFont(new Font("Serif", Font.PLAIN, 25));
			
		}
		
		
		
		
		//Disable operation buttons/right parenthesis for now until user clicks a valid number button
		//if program were to start with an operation... it will crash
		Button[] disableOps = {plus, minus, div, rpar, mult, equals, delete};
		for(int i = 0; i < disableOps.length; i++){
		disableOps[i].setEnabled(false);
		}
		
		
		
		
		//Enable operations and right parenthesis buttons after a number, left parenthesis,
		//or decimal button is hit to avoid starting equation with an operation and then crashing
		Button[] enableOps = {point, delete, zero, one, two, three, four, five, six, sev, eight, nine, lpar};
		for(int i = 0; i < enableOps.length; i++){
		enableOps[i].addActionListener(new EnableButtons(minus,plus,div,mult,rpar,equals,delete));	
		}
		
		
		
		
		
		//This will make sure that anything that goes in to this label will have a vertical layout
		BoxLayout vertical = new BoxLayout(this, BoxLayout.Y_AXIS); //make new box layout consisting of frame f, make it vertical
		this.setLayout(vertical);//set layout the the variable called "vertical"
		
		Container row1 = new Container(); //create new container to hold first row of buttons
		BoxLayout horizontal = new BoxLayout(row1, BoxLayout.X_AXIS); //make the button container align horizontally
		row1.setLayout(horizontal);
		row1.add(sev); //Add Button sev to the CONTAINER
		row1.add(eight); //etc
		row1.add(nine); 
		row1.add(mult);
		
		//Repeat 4 more times
		Container row2 = new Container(); 
		BoxLayout horizontal2 = new BoxLayout(row2, BoxLayout.X_AXIS);
		row2.setLayout(horizontal2);
		row2.add(four);
		row2.add(five);
		row2.add(six);
		row2.add(div);
		
		Container row3 = new Container();
		BoxLayout horizontal3 = new BoxLayout(row3, BoxLayout.X_AXIS);
		row3.setLayout(horizontal3);
		row3.add(one);
		row3.add(two);
		row3.add(three);
		row3.add(minus);
		
		Container row4 = new Container();
		BoxLayout horizontal4 = new BoxLayout(row4, BoxLayout.X_AXIS);
		row4.setLayout(horizontal4);
		row4.add(zero);
		row4.add(lpar);
		row4.add(rpar);
		row4.add(plus);
			
		Container row5 = new Container();
		BoxLayout horizontal5 = new BoxLayout(row5, BoxLayout.X_AXIS);
		row5.setLayout(horizontal5);
		row5.add(point);
		row5.add(delete);
		row5.add(clear);
		row5.add(equals);
		
		this.add(l); //Add label to the frame
		this.add(row1); //Add the first row of buttons in to the label
		this.add(row2); //etc
		this.add(row3);
		this.add(row4);
		this.add(row5);
		
		
		//Implement a class for each Button to make it do its appropriate task depending on which button is pressed
		//All Buttons must pass through both the label(to continually get the string the label produces as each button is pressed)
		//and the 
		nine.addActionListener(new LabelChangerNine(l, eq));
		eight.addActionListener(new LabelChangerEight(l, eq));
		sev.addActionListener(new LabelChangerSev(l, eq));
		six.addActionListener(new LabelChangerSix(l, eq));
		five.addActionListener(new LabelChangerFive(l, eq));
		four.addActionListener(new LabelChangerFour(l, eq));
		three.addActionListener(new LabelChangerThree(l, eq));
		two.addActionListener(new LabelChangerTwo(l, eq));
		one.addActionListener(new LabelChangerOne(l, eq));
		zero.addActionListener(new LabelChangerZero(l, eq));
		plus.addActionListener(new LabelChangerPlus(l, eq));
		minus.addActionListener(new LabelChangerMinus(l, eq));
		div.addActionListener(new LabelChangerDiv(l, eq));
		mult.addActionListener(new LabelChangerMult(l, eq));
		lpar.addActionListener(new LabelChangerLPAR(l, eq));
		rpar.addActionListener(new LabelChangerRPAR(l, eq));
		point.addActionListener(new LabelChangerPoint(l, eq));
		equals.addActionListener(new Equals(l, eq));
		delete.addActionListener(new Delete(l, eq));
		clear.addActionListener(new Clear(l, eq, minus,plus,div,mult,rpar,equals,delete));

		
	}
	



    }