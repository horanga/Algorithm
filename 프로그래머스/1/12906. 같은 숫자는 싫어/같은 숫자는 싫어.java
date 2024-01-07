import java.util.Stack;

public class Solution {

public int[] solution(int[] arr) {

        Stack<Integer> numberStack = new Stack<>();

        for(int number : arr){
            if(numberStack.isEmpty()|| numberStack.peek()!=number){
                numberStack.push(number);
            }
        }

        return numberStack.stream()
                .mapToInt(i -> i).toArray();


    }
}