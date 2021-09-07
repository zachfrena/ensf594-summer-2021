public class Node {

    private String info; //class variables
    private Node right;
    private Node left;

    public Node(String info){ //constructor
        setInfo(info);
        setRight(null);
        setLeft(null);
    }

    public void setInfo(String info){
        this.info = info;
    }

    public String getInfo(){
        return this.info;
    }

    public Node getLeft(){ return this.left; }

    public Node getRight(){
        return this.right;
    }

    public void setLeft(Node left){
        this.left = left;
    }

    public void setRight(Node right){
        this.right = right;
    }

    @Override
    public String toString(){ //allowing us to print out contents of node
        return this.info;
    }
}
