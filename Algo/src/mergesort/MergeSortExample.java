package mergesort;

import java.util.Random;

public class MergeSortExample {

    private int[] array;

    public static void main(String[] args) {

        int[] array = { 100, 25, 38, 46, 53 };
        System.out.println("Initial Array: ");
        printArray(array);

        long startTime = System.currentTimeMillis();
        array = mergeSort(array);
        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Sorted Array: ");
        printArray(array);

        System.out.println("Time taken to sort " + array.length + " integers using MergeSort is " + elapsedTime + " milliseconds.");
    }

    private static void printArray(int[] array) {
        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void fillRandomData() {
        Random random = new Random();                   // instance of Random class
        for (int i = 1; i < array.length; ++i) {        // iterating thru the array
            array[i] = random.nextInt(10000);    // assigning randomly generated integer to the ith element
        }
    }

    private static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int midpoint = array.length / 2;

        int[] left = new int[midpoint];
        int[] right;

        if (array.length % 2 == 0) { //right array may not be the same length as left array
            right = new int[midpoint];
        } else {
            right = new int[midpoint + 1];
        }

        // populate array
        for (int i = 0; i < midpoint; i++) {
            left[i] = array[i];
        }

        for (int j = 0; j < right.length; j++) {
            right[j] = array[midpoint + j];
        }

        // set result that will be returned
        int[] result = new int[array.length];

        left = mergeSort(left);
        right = mergeSort(right);

        result = merge(left, right); // After returned, merge

        return result;
    }

    private static int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length]; // result will be returned

        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        while (leftPointer < left.length || rightPointer < right.length) { // while elements in left/right array

            if (leftPointer < left.length && rightPointer < right.length) { // if elements in left & right array, which is the smallest

                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }

            } else if (leftPointer < left.length) { // if elements remain in the left array
                result[resultPointer++] = left[leftPointer++];
            } else if (rightPointer < right.length) { // if elements remain in the right array
                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;
    }
}
