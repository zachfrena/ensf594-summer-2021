public class Tree {
    private Node root; //class variables for root node and current cursor
    private Node cursor;

    public Tree(){
        setRoot(null); //constructor creates an empty tree
    }

    public Boolean compareName(String n, String cursor){
        String nSubString = n.substring(7,31); //only compare student names
        String cursorSubString = cursor.substring(7,31);
        if (nSubString.compareToIgnoreCase(cursorSubString)>0){ //positive value means that cursor name is larger than new node name
            return false;
        }
        else { // negative value means that new node name is larger than cursor name
            return true;
        } //value of zero means that the substrings are equal
    }

    public void insert(Node n){
        if (n == null){ //can't insert an empty node
            return;
        }
        n.setLeft(null); //set the newly inserted node's children to null values
        n.setRight(null);

        if (isEmpty()){
            this.root = n; //adding node as root if tree is empty
        }

        else{
            Node cursor = root; //start at root of tree
            while(true){ //traverse tree until return statement
                Node parent = cursor; //set the parent node to the current cursor
                if(compareName(n.getInfo(), cursor.getInfo())){ //check if you need to travel down the left side
                    cursor=cursor.getLeft(); //update cursor to point to the left child
                    if(cursor == null){
                        parent.setLeft(n); //insert new node into left child
                        return; //exit while loop
                    }
                }
                else if(!compareName(n.getInfo(), cursor.getInfo())){ //check if you need to travel down right side
                    cursor=cursor.getRight(); //update cursor to point at right child
                    if(cursor==null){
                        parent.setRight(n); //insert new node into right child
                        return;
                    }
                }
            }
        }
    }

    public void setRoot(Node root){
        this.root = root;
    }

    public Node getRoot(){
        return this.root;
    }

    public boolean isEmpty(){
        if(getRoot()==null){
            return true;
        }
        return false;
    }

    public void inOrderTraverse(Node cursor) {
        if (cursor!=null) {
            inOrderTraverse(cursor.getLeft());
            System.out.println(cursor);
            inOrderTraverse(cursor.getRight());
        }
    }


    public Node[] levelOrderTraverse(Node cursor){
        Queue q = new Queue(10); //create new Queue of length 10
        Node[] n = new Node[1000]; //create an array of nodes, arbitrary limit to capture all nodes
        q.enqueue(cursor); //push cursor into queue
        int i=0; //create counter variable
        while(!q.isEmpty()){ //complete the following while q isn't empty
            cursor = q.dequeue(); //dequeue an item in the queue
            n[i]=cursor; //insert the dequeued node into the node array
            i++; //increment counter
            if(cursor.getLeft() != null){ //enqueue children of the cursor
                q.enqueue(cursor.getLeft());
            }
            if(cursor.getRight() != null){
                q.enqueue(cursor.getRight());
            }
        }
        return n; //return node array containing nodes in level order
    }

}
