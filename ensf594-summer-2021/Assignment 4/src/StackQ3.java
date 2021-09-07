public class StackQ3 {
        private int maxSize;
        private int[] stackValues;
        private int top;

        public StackQ3(int s){
            maxSize = s;
            stackValues = new int[maxSize];
            top = -1;
        }

        void push (int j){
            stackValues[++top] = j; //++top is a pre-increment operator
        }

        public int pop(){
            return stackValues[top--];
        }
        public int peek(){
            return stackValues[top];
        }

        public boolean isEmpty(){
            return(top==-1);
        }

        public boolean isFull(){
            return (top == maxSize-1);
        }

}
