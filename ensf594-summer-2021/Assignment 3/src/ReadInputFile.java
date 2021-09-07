import java.io.*;
public class ReadInputFile {

    public String[] arr;
    public int length;


    public ReadInputFile(String f) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(f)); // new bufferedReader object
        this.length = 0; //initialize length to 0
        while (br.readLine() != null) {
            this.length++; //count items in list and update length variable
        }
        arr = new String[this.length]; //create new string array with length equal to elements in input file
        BufferedReader br1 = new BufferedReader(new FileReader(f)); //new bufferedReader object
        String line;
        int i = 0;
        while ((line = br1.readLine()) != null) {
            this.arr[i] = line; //append elements in input file to the array
            i++;
        }
    }
}
