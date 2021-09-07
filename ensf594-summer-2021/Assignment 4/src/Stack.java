public class Stack {
    private int maxSize;
    private char[] stackValues;
    private int top;

    public Stack(int s){
        maxSize = s;
        stackValues = new char[maxSize];
        top = -1;
    }

    void push (char j){
        stackValues[++top] = j; //++top is a pre-increment operator
    }

    public char pop(){
        return stackValues[top--];
    }
    public char peek(){
        return stackValues[top];
    }

    public boolean isEmpty(){
        return(top==-1);
    }

    public boolean isFull(){
        return (top == maxSize-1);
    }

}
