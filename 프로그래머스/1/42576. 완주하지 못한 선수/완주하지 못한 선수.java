import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    
    public static String solution(String[] participant, String[] completion) {

        if(Objects.isNull(participant)||Objects.isNull(completion)){
            throw new IllegalArgumentException("입력값은 null일 수 없습니다.");
        }

        Map<String, Integer> completerFrequencyMap = new HashMap<>();
        for(String completer : completion){
            completerFrequencyMap.compute(completer, (name, frequency)->(frequency==null)? 1:++frequency);
        }
        
        for(String runner: participant){
            if (completerFrequencyMap.containsKey(runner)) {
               completerFrequencyMap.put(runner, completerFrequencyMap.get(runner)-1);
                if(completerFrequencyMap.get(runner)==0){
                    completerFrequencyMap.remove(runner);
                }
            } else{
                return runner;
            }
        }
        
        return "";
    }
}
