package mergesort;

public class MergeSortExample {

    public static void main(String[] args) {

        int[] array = { 100, 25, 38, 46, 53 };
        System.out.println("Initial Array: ");
        printArray(array);

        array = mergeSort(array);
        System.out.println("Sorted Array: ");
        printArray(array);

    }

    private static void printArray(int[] array) {
        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
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
