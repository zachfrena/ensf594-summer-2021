import java.io.IOException;

public class AnagramApp {

    public void insertionSort(char arr[]) //sorting char array using insertion sort process
    { //“Insertion Sort,” GeeksforGeeks, 08-Jul-2021. [Online]. Available: https://www.geeksforgeeks.org/insertion-sort/. [Accessed: 20-Jul-2021].
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            char key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public String sortAlpha(String s) { //sorts string alphabetically
        char charArray[] = s.toCharArray(); //create new array of char type
        insertionSort(charArray); //call sorting algorithm on array
        return new String(charArray); //return new string composed of sorted chars
    }

    public static void main(String[] args) throws IOException {
        //creates ReadInputFile object which reads input text file and creates an array of strings
        ReadInputFile r = new ReadInputFile("input.txt");
//        for (int i = 0; i < r.length; i++) { //test printout of input array
//            System.out.println(r.arr[i]);
//        }
        AnagramApp a = new AnagramApp(); //new AnagramApp object
        String[] alphaArray = new String[r.arr.length]; //new string array of length equal to input word array length
        for (int i = 0; i < r.arr.length; i++) { //looping through each string in array and sorting alphabetically
            alphaArray[i] = a.sortAlpha(r.arr[i]); //assigning alphabetically sorted strings to newly created array
        }
//        for (String element : alphaArray) {
//            System.out.println(element); //test print-out of array of sorted elements
//        }
        SinglyLinkedList[] arraysOfLists = new SinglyLinkedList[r.arr.length]; //creating array of singly linked lists
        for (int i = 0; i < r.arr.length; i++){
            arraysOfLists[i] = new SinglyLinkedList(); //determining size of linkedList array
        }

        int z=0; //counter for array index
        for (int i = 0 ; i<r.arr.length; i++){
            if (alphaArray[i] != "anagram") { //skip over previously collected elements (later assigned to "anagram" to prevent doubling up)
                arraysOfLists[z].push(r.arr[i]); //push the word to the array, regardless of whether it has anagrams
                for (int j = i+1 ; j<r.arr.length; j++){ //checking the subsequent words in the list for anagrams
                        if (alphaArray[i].equals(alphaArray[j])){
                            arraysOfLists[z].push(r.arr[j]); //if anagrams are found, push them to linked-list in the same array index
                            alphaArray[j] = "anagram"; //assign the subsequent anagrams to a string value for identification
                        }
                    }
            }
            z++; //increment counter to traverse indices in array
        }
//        System.out.println("final below: "); //used to print out terminal-representation of array
//        for (int i = 0; i < arraysOfLists.length; i++){
//            if (arraysOfLists[i].size != 0){ //skip empty linked lists in array
//                arraysOfLists[i].show();
//                System.out.println();
//            }
//        }
        WriteOutputFile w = new WriteOutputFile(arraysOfLists); //write the array of lists to the output file
    }
}
