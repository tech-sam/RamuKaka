# Quick Sort

 QuickSort is a Divide and Conquer algorithm.This algorithm is quite efficient for large-sized data sets as its average and worst-case complexity are O(n2), respectively.


* Inventor: Tony Hoare
*  Worst complexity: n^2
*  Average complexity: n*log(n)
*  Best complexity: n*log(n)
*  Method: Partitioning
*  Stable: No
*  Class: Comparison sort

## Confused code

```
 public static int partition(int[] inputArray, int start, int end) {
        int pivot = inputArray[end];
        int i = start - 1;
        // with this loop all values less then pivot on the left side
        for (int j = start; j <= end - 1; j++) {
            if (inputArray[j] <= pivot) {
                i++;
                int ivalue = inputArray[i];
                int jvalue = inputArray[j];
                inputArray[i] = jvalue;
                inputArray[j] = ivalue;
            }
        }
        
        // why this code is required 
        int ival = inputArray[i + 1];
        inputArray[end] = ival;
        inputArray[i + 1] = pivot;

        return i + 1;
    }
```
