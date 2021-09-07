public class Queue {

    private int maxSize;
    private Node[] qArray;
    private int front; //also called head
    private int rear; //also called tail
    private int nItems;

    public Queue(int s){
        this.maxSize=s;
        qArray = new Node[this.maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void enqueue(Node z){
        if (rear == maxSize - 1){
            rear = -1;
        }
        qArray[++rear] = z;
        nItems++;
    }

    public Node dequeue(){
       Node temp = qArray[front++];
        if (front == maxSize){
            front = 0;
        }
        nItems--;
        return temp;
    }

    public Node peekFront(){
        return qArray[front];
    }

    public boolean isEmpty(){
        return (nItems==0);
    }

    public boolean isFull(){
        return (nItems==maxSize);
    }

    public int size(){
        return nItems;
    }


}
