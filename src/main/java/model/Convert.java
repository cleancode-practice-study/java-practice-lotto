package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Convert {
    // 지난 주 당첨번호 String > String[] 스플릿
    public static String[] splitNumbers(String number) {
        return number.split(",");
    }

    // string[] > list<Integer>
    public static List<Integer> changeStringArrayToList(String[] number) {
        int[] numbers = Arrays.stream(number).mapToInt(Integer::parseInt).toArray(); // string[] > int[]

        return IntStream.of(numbers).boxed().collect(Collectors.toList());
    }
}
