package homework2_4;

import java.util.*;

public class Pset1 {

    public static boolean isAllCharacterUnique(String sIn) {
        int[] array = new int[sIn.length()];
        for (int i = 0; i < sIn.length(); i++) {
            array[i] = sIn.charAt(i);
        }

        boolean[] check = new boolean[10000];
        Arrays.fill(check, false);
        for (int item: array) {
            if (!check[item]) check[item] = true;
            else return false;
        }
        return true;
    }

//    public static boolean isPermutation(String sIn1, String sIn2) {
//        if (sIn1.length() != sIn2.length()) return false;
//
//        char array1[] = sIn1.toCharArray();
//        char array2[] = sIn2.toCharArray();
//
//        Arrays.sort(array1);
//        Arrays.sort(array2);
//
//        for (int i = 0; i < array1.length; i++) {
//            if (array1[i] != array2[i]) return false;
//        }
//
//        return true;
//    }

    public static boolean isPermutation(String sIn1, String sIn2) {
        if (sIn1.length() != sIn2.length()) return false;

        int[] array1 = new int[sIn1.length()];
        int[] array2 = new int[sIn2.length()];

        for (int i = 0; i < sIn1.length(); i++) {
            array1[i] = (int) sIn1.charAt(i);
        }

        for (int j = 0; j < sIn2.length(); j++) {
            array2[j] = (int) sIn2.charAt(j);
        }

        array1 = mergeSort(array1);
        array2 = mergeSort(array2);

        for (int i: array1) {
            System.out.println(i);
        }

        for (int j: array2) {
            System.out.println(j);
        }


        return true;
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

                if (left[leftPointer] > right[rightPointer]) { // defines which sorting (ascending/descending)
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