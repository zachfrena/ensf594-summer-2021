import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3_Zach_Frena {

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static int Evaluate(int operand1, int operand2, char op) { //method that evaluates expression
        if (op == '+') {
            return (operand1 + operand2); //perform calculation and return value
        } else if (op == '-') {
            return (operand1 - operand2);
        } else if (op == '*') {
            return (operand1 * operand2);
        } else {
            return (operand1 / operand2);
        }
    }

    public static void main(String[] args) {
        String input = "";
        System.out.println("Enter an expression: "); //user input
        System.out.flush();
        try {
            input = getString();
        } catch (IOException e) {
            System.out.println(e);
        }
        StackQ3 stack = new StackQ3(100); //create new large stack of input values
        StringBuffer answer = new StringBuffer();
        for (int i =0 ; i<input.length(); i++){ //looping through the input
            char ch = input.charAt(i);
            if(ch!='+' && ch!='-' && ch!='/' && ch!='*'){ // if an operand
                stack.push(Integer.parseInt(String.valueOf(ch))); //converting from char--> string--> int, then pushing
            }
            else{ //if an operator
                int b = stack.pop(); //pop to get the 2 latest operands
                int a = stack.pop();
                int combine = Evaluate(a,b,ch); // evaluate the operands using the operator
                stack.push(combine); //push evaluated expression back to stack
            }
        }
        while(!stack.isEmpty()){
            answer.append(stack.pop()); //pop remaining stack values and append to answer
        }
        System.out.println(answer); //print to terminal
    }
}
