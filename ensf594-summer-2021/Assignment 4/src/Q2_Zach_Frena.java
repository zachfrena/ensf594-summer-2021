import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2_Zach_Frena {

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static Boolean takesPrecedenceOrEqual(char op1, char op2) {
        if (op1 == '+' || op1 == '-') {
            if (op2 == '+' || op2 == '-') {
                return true; //op1 DOESN'T have higher precedence over op2
            }
            if (op2 == '*' || op2 == '/') {
                return false; //op1 DOESN'T have higher precedence over op2
            }
        }
        else if (op1 == '*' || op1 == '/') {
            if (op2 == '+' || op2 == '-') {
                return true; //op1 has higher precedence over op2
            }
            if (op2 == '*' || op2 == '/') {
                return true; //op1 is equal op2 }
            }
        }
    return false;
}

    public static void main(String[] args) {
        String input = "";
        System.out.println("Enter an expression: "); //prompt user for input
        System.out.flush();
        try {
            input = getString();
        } catch (IOException e) {
            System.out.println(e);
        }
        Stack stack = new Stack(input.length());
        StringBuffer postFix = new StringBuffer();
        for(int i =0; i<input.length();i++){ //loop through entire input string
            char ch = input.charAt(i);
            if(ch!='+' && ch!='-' && ch!='/' && ch!='*'){ //if the next character is an operand (i.e. ISN'T an operator)
                postFix.append(ch); //append immediately to the postfix string
            }
            else{
                if(stack.isEmpty()){ //if stack is empty, push operator
                   stack.push(ch);
                }
                else{
                    while(!stack.isEmpty()){ //while the stack isn't empty, pop the top
                        char z = stack.pop();
                        if(!takesPrecedenceOrEqual(z, ch)){ //if top is less than current operator, push top back
                            stack.push(z);
                            break;
                        }
                        if(takesPrecedenceOrEqual(z, ch)){ //if top is greater than or equal to current, add to postfix
                            postFix.append(z);
                        }
                    }
                    stack.push(ch); //push the current operator to stack
                }
            }
        }
        while(!stack.isEmpty()){
            postFix.append(stack.pop()); //pop all remaining operators in stack to postfix string
        }

        System.out.println("The above expression in postfix is: "+ postFix.toString()); //print out postfix
    }
}
