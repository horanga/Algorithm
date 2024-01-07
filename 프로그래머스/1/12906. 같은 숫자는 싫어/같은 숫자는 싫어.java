import java.util.Stack;

public class Solution {

public int[] solution(int[] arr) {

        if (arr == null) {
            return new int[0];
        }
        
        Stack<Integer> numberStack = new Stack<>();

        for(int number : arr){
                if(number!=null){
            if(numberStack.isEmpty()|| numberStack.peek()!=number){
                numberStack.push(number);
            }
        }
        }

        return numberStack.stream()
                .mapToInt(i -> i).toArray();


    }
}
