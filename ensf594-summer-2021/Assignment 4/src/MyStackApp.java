public class MyStackApp {

    public static void main (String[] args){
        Stack theStack = new Stack(10);
        theStack.push('a');
        theStack.push('b');
        theStack.push('c');
        theStack.push('d');

        while(!theStack.isEmpty()){
            System.out.println(theStack.pop());
        }
    }


}
