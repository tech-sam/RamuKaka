package array;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Write a program which takes as input an array of digits encoding a decimal number D
 * and updates the array to represent the number D+1 , example is the input is
 * {1,2,9} then you should update the array to {1,3,0}. Algorithm should work even
 * if it is implemented in a language that has finite-precision arithmetic.
 *
 * */
public class IncrementArbitraryPrecisionInteger {

    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 9);
        List<Integer> integers = integerStream.collect(Collectors.toList());
        System.out.println(plusOne(integers));
    }

    public static List plusOne(List<Integer> integers) {
        int n = integers.size() - 1;
        integers.set(n, integers.get(n) + 1);
        for (int i = n; i > 0 && integers.get(i) == 10; --i) {
            integers.set(i, 0);
            integers.set(i - 1, integers.get(i - 1) + 1);
        }
        if (integers.get(0) == 10) {
            integers.set(0, 0);
            integers.add(0, 1);
        }
        return integers;
    }
}
