package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//
// Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
public class MultiplyTwoArbitraryPrecisionIntegers {

    public static void main(String[] args) {
        Stream<Integer> num1Stream = Stream.of(1, 9, 3, 7, 0, 7, 7, 2, 1);
        List<Integer> num1 = num1Stream.collect(Collectors.toList());

        Stream<Integer> num2Stream = Stream.of(-7, 6, 1, 8, 3, 8, 2, 5, 7, 2, 8, 7);
        List<Integer> num2 = num2Stream.collect(Collectors.toList());
        //System.out.println(multiply(num1, num2));
        System.out.println(multiply("0", "0"));
    }

    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;
        num1.set(0, Math.abs(num1.get(0)));
        num2.set(0, Math.abs(num2.get(0)));
        List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));
        for (int i = num1.size() - 1; i >= 0; --i) {
            for (int j = num2.size() - 1; j >= 0; --j) {
                result.set(i + j + 1, result.get(i + j + 1) + num1.get(i) * num2.get(j));
                result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);
                result.set(i + j + 1, result.get(i + j + 1) % 10);


            }
        }
        int first_not_zero = 0;
        while (first_not_zero < result.size() && result.get(first_not_zero) == 0) {
            ++first_not_zero;
        }

        result = result.subList(first_not_zero, result.size());
        if (result.isEmpty()) {
            return Arrays.asList(0);
        }
        result.set(0, result.get(0) * sign);
        return result;
    }

    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        List numList1 = num1.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList());
        List numList2 = num2.chars().mapToObj(e -> (char) e).collect(Collectors.toList());

        List<Integer> result = new ArrayList(Collections.nCopies(numList1.size() + numList2.size(), 0));
        for (int i = numList1.size() - 1; i >= 0; --i) {
            for (int j = numList2.size() - 1; j >= 0; --j) {
                result.set(i + j + 1, result.get(i + j + 1) + Character.getNumericValue((Character) numList1.get(i)) * Character.getNumericValue((Character) numList2.get(j)));
                result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);
                result.set(i + j + 1, result.get(i + j + 1) % 10);
            }

        }
        int first_not_zero = 0;
        while (first_not_zero < result.size() && result.get(first_not_zero) == 0) {
            ++first_not_zero;
        }
        if (result.isEmpty()) {
            return "0";
        }
        result = result.subList(first_not_zero, result.size());
        return result.stream().map(e -> String.valueOf(e)).collect(Collectors.joining());

    }
}
