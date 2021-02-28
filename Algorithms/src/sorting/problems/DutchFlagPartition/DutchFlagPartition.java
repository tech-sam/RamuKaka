package sorting.problems.DutchFlagPartition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Reorder the array so that all elements less than the pivot appear first,
followed by elements equal to the pivot,
followed by elements greater than the pivot.
This is known as Dutch national flag partitioning,
because the Dutch national flag consists of three horizontal bands,
each in a different color.
*/
public class DutchFlagPartition {
    public enum Color {RED, WHITE, BLUE}

    public static void main(String[] args) {
        Stream<Color> colorStream = Stream.of(Color.BLUE, Color.RED, Color.WHITE,
                Color.RED, Color.WHITE, Color.BLUE,
                Color.WHITE, Color.BLUE, Color.RED);

        List<Color> colors = colorStream.collect(Collectors.toList());

        // dutchFlagPartition(Color.WHITE.ordinal(), colors);
        dutchFlagPartitionTricky(Color.WHITE.ordinal(), colors);
        //  System.out.println(colors);
    }

    public static void dutchFlagPartitionOn2(int pivotIndex, List<Color> A) {
        Color pivot = A.get(pivotIndex);
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(j).ordinal() < pivot.ordinal()) {
                    Collections.swap(A, i, j);
                    break;
                }
            }
        }

        for (int i = A.size() - 1; i >= 0 && A.get(i).ordinal() > pivot.ordinal(); i--) {
            for (int j = i - 1; j >= 0 && A.get(j).ordinal() > pivot.ordinal(); j--) {
                if (A.get(j).ordinal() > pivot.ordinal()) {
                    Collections.swap(A, j, i);
                    break;
                }
            }
        }
        //System.out.println(A);
    }


/*
    Write a program that takes an array A and an index i into A,
    and rearranges the elements such that all elements less than A[i] (the "pivot") appear first,
    followed by elements equal to the pivot, followed by elements greater than the pivot.
*/

    public static void dutchFlagPartition(int pivotIndex, List<Color> A) {
        Color pivot = A.get(pivotIndex);
        int smaller = 0;

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i).ordinal() < pivot.ordinal()) {
                Collections.swap(A, i, smaller++);
            }

        }
        int larger = A.size() - 1;
        for (int i = A.size() - 1; i >= 0 && A.get(i).ordinal() >= pivot.ordinal(); i--) {
            if (A.get(i).ordinal() > pivot.ordinal()) {
                Collections.swap(A, larger--, i);
            }
        }
    }


    /*            Keep the following invariants during partitioning:
     *            bottom group: A.subList(SI, smaller).
     *            middle group: A.subList (smaller , equal).
     *            unclassified group: A.subList(equal , larger).
     *            top group: A .subList (larger , A .size ()) .
     */


/*    Each iteration decreases the size of unclassified by 1,
      and the time spent within each iteration is 0(1),
      implying the time complexity is 0(n). The space complexity is clearly 0(1).
*/

    public static void dutchFlagPartitionTricky(int pivotIndex, List<Color> A) {

        Color pivot = A.get(pivotIndex);

        int smaller = 0, equal = 0, larger = A.size() - 1;

        while (equal < larger) {
            if (A.get(equal).ordinal() < pivot.ordinal()) {
                Collections.swap(A, smaller++, equal++);
            } else if (A.get(equal).ordinal() == pivot.ordinal()) {
                equal++;
            } else {
                Collections.swap(A, equal, larger--);
            }
        }
        System.out.println(A);
    }
}