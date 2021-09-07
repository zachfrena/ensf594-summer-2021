import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.lang.*;

public class AlgoEval {
    private String order; //declaring class variables
    private String algorithm;
    private int size;
    private String outputfile;

    /**
     * This method prompts the user to enter in values for the order, size, algorithm type, and output file name
     * and saves them to the class variables.
     */
    public void getUserInput() {
        Scanner keyboard = new Scanner(System.in); //Scanner object
        System.out.println("Enter the order of the array (ascending, descending, or random): ");
        this.order = keyboard.next();
        System.out.println("Enter the size of the array: ");
        this.size = Integer.parseInt(keyboard.next());
        System.out.println("Enter the type of algorithm (bubble, insertion, merge, quick): ");
        this.algorithm = keyboard.next();
        System.out.println("Enter the name of the output file (include the .txt): ");
        this.outputfile = keyboard.next();
    }

    /**
     * quick sort algorithm sorts input array in ascending order using a pivot point
     * @param arr input array to be sorted
     * @param low index of lower bound
     * @param high index of upper bound
     * @author none stated. https://www.geeksforgeeks.org/quick-sort/
     * @accessed 07/15/2021 5pm
     */
    static void quickSort(int[] arr, int low, int high) //low and high could be 0 and arr.length-1
    {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high); //calling partition helper method

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1); //calling quicksort on lower sub-array
            quickSort(arr, pi + 1, high); //calling quicksort on upper sub-array
        }
    }

    /**
     * this method is used to place all smaller items (with respect to the pivot) before
     * the pivot index, and then place all larger items after the pivot index.
     * @param arr array to be sorted
     * @param low
     * @param high
     * @return index
     * @author none stated. https://www.geeksforgeeks.org/quick-sort/
     * @accessed 07/15/2021 5pm
     */
    public static int partition(int[] arr, int low, int high)
    {
        // pivot
        int pivot = arr[high]; //this could be randomized instead of placed at end

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }


    /**
     * helper method used by partition() method to swap objects
     * @param arr array being accessed
     * @param i index of item to be swapped out of
     * @param j index of item to be swapped into
     */
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * merge sort algorithm sorts input array
     * @param arr input array
     * @param n size of array
     * @author none stated. https://www.baeldung.com/java-merge-sort
     * @accessed 07/15/2021 5pm
     */
    public void mergeSort(int[] arr, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = arr[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(arr, l, r, mid, n - mid);
    }

    /**
     * takes in the input and both the sub-arrays and the starting and end
     * indices of both the sub arrays. The function compares the elements of both sub-arrays
     * one by one and places the smaller element into the input array.
     * @param a
     * @param l
     * @param r
     * @param left
     * @param right
     * @author none stated. https://www.baeldung.com/java-merge-sort
     * @accessed 07/15/2021 6pm
     */
    public void merge(int[] a, int[] l, int[] r, int left, int right) {//

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }


    /**
     * insertion sort used to sort input array
     * @param arr input array
     * @author none stated. https://www.geeksforgeeks.org/insertion-sort/
     * @accessed 07/15/2021 5pm
     */
    public void insertionSort(int[] arr) {//https://www.geeksforgeeks.org/insertion-sort/
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
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

    /**
     * bubble sort used to sort input array
     * @param arr input array
     * @author none stated. https://www.geeksforgeeks.org/bubble-sort/
     * @accessed 07/15/2021 6pm
     */
    public void bubbleSort(int[] arr) { //https://www.geeksforgeeks.org/bubble-sort/
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    /**
     * This method generates a random array
     * @param s end size of random array
     * @return arr random array
     */
    public int[] createRandomArray(int s) {
        Random rd = new Random(); // creating Random object
        int[] arr = new int[s];
        for (int i = 0; i < s; i++) {
            arr[i] = rd.nextInt(); // storing random integers in an array
        }
        return arr;
    }

    /**
     * Method to write each element in the array into an input file
     * @param file name of file to create and write to
     * @param arr array which elements will be written
     */
    public void writeToFile(String file, int arr[]) {

        file = this.outputfile;
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        for (int element : arr) {
            pw.println(element);
        }
        pw.close();
    }


    public static void main(String[] args) {
        AlgoEval algo = new AlgoEval(); //creation of new AlgoEval object
        algo.getUserInput(); //calling method to collect information from user
        int[] RandomArray = algo.createRandomArray(algo.size); //creating new random array using information from user
//        for (int i = 0; i < RandomArray.length; i++) { //printout used for checking the input array
//            System.out.println(RandomArray[i]);
//        }
        int[] UnsortedArray;
        if (algo.order.equals("ascending")) { //based on user input, sort array accordingly
            algo.mergeSort(RandomArray, RandomArray.length);
            UnsortedArray = RandomArray; //assign sorted array to the newly created input array
        } else if (algo.order.equals("descending")) {
            algo.mergeSort(RandomArray, RandomArray.length);
            for (int i = 0; i < RandomArray.length / 2; i++) {
                int temp = RandomArray[i];
                RandomArray[i] = RandomArray[RandomArray.length - i - 1];
                RandomArray[RandomArray.length - i - 1] = temp;
            }
            UnsortedArray = RandomArray;
        } else {
            UnsortedArray = RandomArray;
        }
        long start; //create variables to store time
        long end;
        if (algo.algorithm.equals("bubble")) { //based on user input, sort array and measure sorting time
            start = System.currentTimeMillis();
            algo.bubbleSort(UnsortedArray);
            end = System.currentTimeMillis();
        }
        else if (algo.algorithm.equals("insertion")) {
            start = System.currentTimeMillis();
            algo.insertionSort(UnsortedArray);
            end = System.currentTimeMillis();
        }
        else if (algo.algorithm.equals("quick")) {
            start = System.currentTimeMillis();
            algo.quickSort(UnsortedArray,0,UnsortedArray.length-1);
            end = System.currentTimeMillis();
        }
        else {
            start = System.currentTimeMillis();
            algo.mergeSort(UnsortedArray, UnsortedArray.length);
            end = System.currentTimeMillis();
        }

        int[] SortedArray = UnsortedArray; //create final sorted array
        algo.writeToFile(algo.outputfile, SortedArray); //write to output file specified by user
        System.out.printf("The time taken to run the %s algorithm for %d items in %s order is %d milliseconds.", algo.algorithm, algo.size, algo.order, (end-start));

    }
}
