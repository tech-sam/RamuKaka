package sorting.problems.DutchFlagPartition;

import java.util.Arrays;


/*
Given an array nums with n objects colored red, white, or blue,
sort them in-place so that objects of the same color are adjacent,
with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue,
respectively.
*/

public class DutchFlagPartitionLeetCode {

//    Input: {0, 1, 2, 0, 1, 2}
//    Output: {0, 0, 1, 1, 2, 2}

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 0, 1, 2};

        sortArray(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sortArray(int[] array) {

        int smaller = 0, equal = 0, larger = array.length-1;
        int pivot = 1;

        while (equal <= larger) {
            if (array[equal] < pivot) {
                swap(array, smaller++, equal++);
            } else if (array[equal] == pivot) {
                ++equal;
            } else {
                swap(array, equal, larger--);
            }
        }

    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
