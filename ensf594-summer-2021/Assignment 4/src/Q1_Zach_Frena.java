import java.io.*;
public class Q1_Zach_Frena {



    public static String getString() throws IOException{ //method to get input from user
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static void main (String[] args){
        String input = "";
        System.out.println("Enter an set of parentheses: "); //prompt user
        System.out.flush();
        try{
            input = getString();
        }
        catch (IOException e){
            System.out.println(e);
        }

        Stack pstack = new Stack(input.length()); //create new stack using length specified by user input
        int z = 0;
        for (int j = 0; j< input.length(); j++) { //loop through user input
            char ch = input.charAt(j);
            if (ch == '(') { // push all open-brackets to the stack
                pstack.push(ch);
            }
            if (ch == ')') { // when a close-bracket is seen, pop from the stack
                if (!pstack.isEmpty()) {
                    pstack.pop();
                } else { //if the stack is empty and you can't pop, update z variable to 1
                    z=1;
                    break; //exit loop
                }
            }
        }
        if(!pstack.isEmpty() || z==1) { // if the stack isn't empty or you tried to pop an empty stack, input was invalid
            System.out.println("This is invalid");
        }
        else{
                System.out.println("This is valid");
            }
    }
}
