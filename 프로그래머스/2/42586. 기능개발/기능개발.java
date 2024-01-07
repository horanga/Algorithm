import java.util.*;

public class Solution {

 public static int[] solution(int[] progresses, int[] speeds) {

        if(progresses==null){
            return new int[0];
        }

        Stack<Integer> completionDays = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        int count=1;

        for(int i=0; i<progresses.length; i++){
            int daysToCompletion= (int) Math.ceil((100.0-progresses[i])/speeds[i]);

             if(completionDays.isEmpty()){
                completionDays.push(daysToCompletion);
            } else if(completionDays.peek()>=daysToCompletion){
                count++;
            } else if(completionDays.peek()<daysToCompletion){
                answer.add(count);
                count=1;
                completionDays.pop();
                completionDays.push(daysToCompletion);
            }
            
        }

        if(!completionDays.isEmpty()){
            answer.add(count);
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}