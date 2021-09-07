import java.io.*;
public class WriteOutputFile {

    public WriteOutputFile(SinglyLinkedList[] linkedListArrayToPrint) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 0; i < linkedListArrayToPrint.length; i++){
            if (linkedListArrayToPrint[i].size != 0){ //only write the linked lists that are not empty
                node n = linkedListArrayToPrint[i].head; //assign new node that is equal to the head
                while(n.getNext()!= null) { //while not the tail, write to the output file
                    pw.print(n.getID()+" ");
                    n=n.getNext(); //assign n to the next node
                }
                pw.print(n.getID()); //write the tail node to the file
                pw.println();
            }
        }
        pw.close();//close the print writer
    }
}
