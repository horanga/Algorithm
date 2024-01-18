import java.util.Arrays;

class Solution {
       public static String solution(int[] numbers) {

        String[] numberToString = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(numberToString, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (numberToString[0].equals("0")) {
            return "0";
        }

        return String.join("", numberToString);
    }
}
