import java.util.*;

public class Solution {


    Set<Integer> numSet = new HashSet<>();
    boolean[] visited = new boolean[7];

    public int solution(String numbers) {
        combination(numbers, new StringBuilder(), 0);
        int answer =0;

        for(Integer number : numSet){
            if(isPrime(number)){
                answer++;
            }
        }
        return answer;
    }

    private void combination(String numbers, StringBuilder current, int index) {

        if (index ==numbers.length()) {
            return ;
        }


        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.append(numbers.charAt(i));
                numSet.add(Integer.parseInt(current.toString()));
                combination(numbers, current, index + 1);
                current.deleteCharAt(current.length() - 1);
                visited[i] = false;
            }
        }
    }

    private static boolean isPrime(int number) {
        if(number<2){
            return false;
        }
        int len = (int) Math.sqrt(number);
        for (int i = 2; i <= len; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}