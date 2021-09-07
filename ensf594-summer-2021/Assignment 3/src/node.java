public class node {
    private String id; //class variables
    private node next;

    public String getID() { //getter method for ID
        return this.id;
    }

    public node (String id) { //node constructor using only ID
        setID(id);
    }

    public node (String id, node n) { //node constructor using both ID and node
        setID(id);
        setNext(n);
    }

    public void setID(String id) { //setter method for ID
        this.id = id;
    }

    public void setNext (node next) { //setting method for next node
        this.next = next;
    }

    public node getNext() { //getter method to get next node
        return this.next;
    }
}
