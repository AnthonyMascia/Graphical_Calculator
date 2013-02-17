
import java.awt.Label;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Calculator{

	//Function that will determine which element goes in to which stack and when
	private static void classify(String readp[], Queue <String> outQueue, Stack <String> op){
		
		for(int i=0; i < readp.length; i++){
			
			
		if(readp[i].equals("+") || readp[i].equals("-")){
				if(op.size() == 0){ //If nothings in the operation stack, dont worry about anything
					op.push(readp[i]);//and just push the operation
				}
				else if(op.size() > 0 && (op.peek().equals("+") || op.peek().equals("-")
									   || op.peek().equals("*") || op.peek().equals("/"))){
					outQueue.add(op.pop()); //If the operation on the top of the stack is of greater
					op.push(readp[i]); //or equal precedence, push the top of the op stack to the
									   //output queue to be later interpreted with rpn function
				}
				else{
					op.push(readp[i]); //If the operation at the top of the stack is a
									   // "("... dont pop, but just push the operation so the parenthesis
									   //can be later popped by the right parenthesis
				}
		}
		
		
		else if(readp[i].equals("*") || readp[i].equals("/")){
				if(op.size() == 0){
					op.push(readp[i]); 
				}
				else if(op.size() > 0 && (op.peek().equals("*") || op.peek().equals("/"))){
					outQueue.add(op.pop());//Only pop if top of op stack is * or / because they are
					op.push(readp[i]);     //of equal precedence. + and - are not
				}
				else{
					op.push(readp[i]); //Dont pop if top of op stack is a (
				}
			}
		
		
		else if(readp[i].equals("(")){
				op.push(readp[i]);
		}
		
		
		else if(readp[i].equals(")")){
			while(!op.peek().equals("(")){
				outQueue.add(op.pop()); //This ensures that (equation) is done first in equation
										//By not popping operations before ()
			}
			
			op.pop(); //Remove left parenthesis from the operator stack
			
		}
		
		
		
		else{
			outQueue.add(readp[i]);//If the element is not an operator (a number)... static cast it
			   }										   //as a double to push it on to the stack...as a double, it is able
														   //to correctly do calculations because a string can obviously not
														   //make calculations
				
			
			
		}//End FOR Loop
		
		while(op.size() > 0){
			outQueue.add(op.pop()); //Clean out the operation stack
		}
		
			
		}
			
	
		
		
	
	
	
	//Calculate function that takes output queue and converts it into a solvable RPN equation
	private static void calculate(Queue <String> outQueue1, Stack <String> op1, Stack <Double> ans, String equa2, Label l2){		
		
		while(outQueue1.size() > 0){
			
			if(outQueue1.peek().equals("+")){
				outQueue1.remove(); //Remove head of queue so it doesnt get read again
				ans.push(ans.pop() + ans.pop()); //Push answer in to a stack of DOUBLE (NO CONSTANT PARSING)
			}
			else if((outQueue1.peek().equals("*"))){
				outQueue1.remove();
				ans.push(ans.pop() * ans.pop());
			}
			else if((outQueue1.peek().equals("-"))){
				outQueue1.remove();
				double b = ans.pop();
				double a = ans.pop();
				ans.push(a-b);
				}
			else if((outQueue1.peek().equals("/"))){
				outQueue1.remove();
				double b = ans.pop();
				double a = ans.pop();
				if(b == 0){
					l2.setText("ERROR: No Division by 0"); //Displays to user they cant / by 0
				}
				else
				ans.push(a/b);
				}
			else{
				ans.push(Double.parseDouble(outQueue1.remove())); //If the element is a number,
															//parse it to a double and push it in
															//to the Double stack
			}
			
		}
		
		l2.setText(Double.toString(ans.peek()));//show answer to equation
		
	}
	


	public Calculator(String equa, Label l) {
		
		Queue<String>output = new LinkedList<String>(); //Output queue that will keep track of operands/pushed operations
		Stack<String>operator = new Stack<String>();//Operator stack that will keep track of operations
		Stack<Double>rpn = new Stack<Double>();//Stack that will have doubles pushed in to it
											   //to make calculations
		String read = equa;
		String[] array = read.split(" ");//Create new variable called array to .split user's equation after every space
										 //This makes an array of strings... the array is filled with every element after
										 //every space.. in this case.. every element will become a string
		
		try{ //go through both rpn functions
			classify(array, output, operator);
			calculate(output, operator, rpn, equa, l);			
		}
		catch(NumberFormatException nfe){ //if user enters an equation incorrectly, catch the exception
										  //and display to user so they can clear and try again
  			l.setText("Invalid Equation");
  		}catch(EmptyStackException ese){ //when user enters too few numbers...
  			l.setText("Invalid Equation");
  		}
		
	}
			
}



