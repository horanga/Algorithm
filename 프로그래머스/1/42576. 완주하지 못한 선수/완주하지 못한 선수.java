import java.util.HashMap;
import java.util.Map;

public class Solution {
    
    public static String solution(String[] participant, String[] completion) {

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