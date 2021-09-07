import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SinglyLinkedList {
    public node head; //class variables
    private node tail;

    public int size = 0; //initialize size to 0

    public int size() { //getter method for size
        return size;
    }

    public SinglyLinkedList() {
        //create an empty linked list
    }

    public boolean isEmpty() { //check if list empty
        return size == 0;
    }

    //add id to the front of the list
    public void addFirst(String n) {
        head = new node(n, head);//head is created by installing a new node with int n as value, and head as next node
        if (size==0) {
            tail = head; //only 1 node in linkedlist
        }
        size++; //increase size
    }

    //another way to add id to front of list

    public void push(String id) {
        node newest = new node(id); //creating a node with int ID value
        newest.setNext(head); //setting pointer to the head
        head = newest; //updating head to newly created node

        if (size==0) {
            tail = head;// only 1 node in linkedlist
        }
        size++; //increment size
    }

    //adding id to the end of the list

    public void addLast(String n) {
        node newest = new node(n,null); //create node with value n, and null pointer

        if (isEmpty()) { //if the linkedlist is empty
            head = newest; //head is equal to new node
        }
        else {
            tail.setNext(newest); //update previous tail to point to new node
        }
        tail = newest; //update tail to point to new node
        size++;
    }

    //remove first node (id) from list
    public String remFirst() {
        if (isEmpty()) {
            return "isEmpty";
        }
        String answer = head.getID();//ID of head node
        head = head.getNext();//update head to equal next node
        size--; //reduce size
        if (size==0) {
            tail = null; //if size was
        }
        return answer; //return first value after removal
    }
    public void show() {
        node n = head; //new node that is head
        while(n.getNext()!=null) { //while not the tail, print out the IDs
            System.out.print(n.getID()+" ");
            n = n.getNext();
        }
        System.out.print(n.getID()+" ");//printing out tail ID
    }

}
