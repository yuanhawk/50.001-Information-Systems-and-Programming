package heapsort;

import java.util.Random;
import java.util.Scanner;

public class HeapSortExample {

    // integer array that is going to hold some integer numbers for sorting
    private int[] array;

    /**
     * Parametrized constructor, receives the size of the array and allocates the array for size + 1
     * the array will be used for heap, the first index is 1 and the last is size.
     * We need to allocate one more element than size to use indices from 1 to size.
     *
     * @param size of the array, precondition is size > 0
     */

    public HeapSortExample(int size) {
        /**
         * allocating the array for heap, the allocation is one more than the actual size
         * so that we can use from index 1 to size
         */
        array = new int[size + 1];
    }

    /**
     * Sorts the arrays using heapsort logic after building heap in place using heapify
     * @return time taken to sort the array in milliseconds
     */
    public long heapSort() {
        long startTime = System.currentTimeMillis();
        // write heap sort
        heapify(); // build heap fr array elements
        int n = array.length - 1;
        for (int i = n; i >= 2; --i) {
            int temp = array[1]; // taking root to temp value
            array[1] = array[i]; // copy last value to the root
            adjust(1, i - 1);
            array[i] = temp;
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Build heap in-place in linear time without using extra space
     */
    private void heapify() { // loop counter for heapify
        int i = 0;
        int n = array.length - 1; // allocated 1 more size for the array
        for (int j = n/2; j >= 1; --j) {
            adjust(j, n);
        }
    }

    /**
     * Adjusts the index i for max heap when at index 2*i (left child a max heap is maintained and also at
     * 2*i + 1 (right child) a max heap is maintained, this method makes sure that at index i a max heap is also
     * maintained
     */
    private void adjust(int i, int n) {
        int j = 2 * i; // index of left child
        int item = array[i];

        while (j <= n) { // as long as j is valid
            if (j < n && array[j] < array[j + 1]) { // if there are 2 nodes & left child node < right child node
                j += 1; // index picks j + 1 (larger)
            }

            if (item >= array[j]) // if parent node is max, break
                break;

            array[j / 2] = array[j]; // else assign child value to parent value
            j = 2 * j; // update j
        }
        array[j / 2] = item;
    }

    /**
     * Fills the instance member array with random integers in the range 0-9999, uses java.util.Random class
     * for generating the integers
     */
    public void fillRandomData() {
        Random random = new Random();                   // instance of Random class
        for (int i = 1; i < array.length; ++i) {        // iterating thru the array
            array[i] = random.nextInt(10000);    // assigning randomly generated integer to the ith element
        }
    }

    /**
     * Method that prints the content of the array into the console
     */
    public void printToConsole() {
        System.out.println("Content of the array: ");
        for (int i = 1; i < array.length; ++i) {
            System.out.printf("%6d", array[i]);
            // after each 10 element is printed, move to new line.
            if (i % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n");
    }

    /**
     * Method to input data for array from keyboard
     */
    public void inputFromConsole() {
        /**
         * Need object of Scanner class to read value from console, System.in is the reference to the keyboard object
         * in java, so passing System.in to the constructor of the Scanner will make the keyboard as source of reading
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Input integers, you would require to input " + array.length + " integers");
        for (int i = 1; i < array.length; ++i) {
            System.out.printf("array[%d] ", i);
            // read the integer and assign that to the ith element of the array.
            array[i] = sc.nextInt();
        }
    }

    /**
     * Method to test if instance member array indeed contains sorted elements in a particular order
     * or not. If it contains sorted elements returns true, otherwise returns false.
     * If the ascendingOrder is true, this method will test if the array is sorted in ascending order,
     * if ascending order is false, this will check if the array contains elements in descending order.
     *
     * Thid method will be useful when we have large number of elements in the array and we want to
     * check whether the array is sorted or not in a particular order, as it will not be possible to check
     * by printing the elements in the console if it contains large number of elements.
     *
     * @param ascendingOrder the order in which the method will check the array. True for ascending order,
     *                       false for descending order
     *
     * @return true if the array is sorted in the order asked for, false otherwise.
     */
    public boolean isSorted(boolean ascendingOrder) {
        //initially we consider that the array is sorted
        boolean sorted = true;
        //iterate as long as there are elements in the array and the array is sorted
        for (int i = 1; i < array.length - 1 && sorted; ++i) {
            /**
             * if we are testing ascendingOrder then every element must be less than its next,
             * if not, that means if any element is larger than its next element the array is not sorted
             * in ascending order
             */

            if (ascendingOrder && array[i] > array[i + 1]) {
                sorted = false;
            }

            /**
             * If we are testing descending order, then every element of the array must be larger than the next,
             * if any element is less than the next one, then the array is not sorted in descending order.
            */
            if (!ascendingOrder && array[i] < array[i + 1]) {
                sorted = false;
            }
        }
        // finally return the sorted flag
        return sorted;
    }

    public static void main(String[] args) {
        int size = 20;
        HeapSortExample objHeapSortExample = new HeapSortExample(size);
        objHeapSortExample.fillRandomData();
        System.out.println("Unsorted array: ");
        objHeapSortExample.printToConsole();

        System.out.println("Going to call merge sort, please wait...");
        long elapsedTime = objHeapSortExample.heapSort();
        if (objHeapSortExample.isSorted(true)) {
            System.out.println("Sorted in ascending order");
        } else {
            System.out.println("Not sorted in ascending order");
        }

        System.out.println("Sorted array: ");
        objHeapSortExample.printToConsole();
        System.out.println("Time taken to sort " + size + " integers using HeapSort is " + elapsedTime + " milliseconds.");
    }
}
