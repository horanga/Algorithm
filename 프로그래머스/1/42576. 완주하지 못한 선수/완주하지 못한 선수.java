import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    
    public static String solution(String[] participant, String[] completion) {

        if(Objects.isNull(participant)||Objects.isNull(completion)){
            throw new IllegalArgumentException("입력값은 null일 수 없습니다.");
        }

        Map<String, Integer> completionRunner = new HashMap<>();
        for(String runner : completion){
            completionRunner.compute(runner, (k, v)->(v==null)? 1:++v);
        }
        
        for(String runner: participant){
            if (completionRunner.containsKey(runner)) {
                completionRunner.put(runner, completionRunner.get(runner)-1);
                if(completionRunner.get(runner)==0){
                    completionRunner.remove(runner);
                }
            } else{
                return runner;
            }
        }
        
        return "  ";
    }
}
