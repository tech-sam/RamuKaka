package sorting.quicksort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] unsortedArray = {44, 2, 33, 12, 45, 1, 9, 13};
        quickSort(unsortedArray, 0, unsortedArray.length - 1);
        System.out.println(Arrays.toString(unsortedArray));
    }

    public static void quickSort(int[] unsortedArray, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(unsortedArray, start, end);
            quickSort(unsortedArray, start, pivotIndex - 1);
            quickSort(unsortedArray, pivotIndex + 1, end);
        }
    }

    public static int partition(int[] unsortedArray, int start, int end) {
        int pivot = unsortedArray[end];
        int j = start;
        int i = j - 1;
        while (j <= end) {

            if (unsortedArray[j] <= pivot) {
                i++;
                int temp = unsortedArray[i];
                unsortedArray[i] = unsortedArray[j];
                unsortedArray[j] = temp;
            }
            j++;
        }
        return i;
    }
}
