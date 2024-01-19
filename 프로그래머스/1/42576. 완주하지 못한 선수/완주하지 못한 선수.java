import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    
    public static String solution(String[] participant, String[] completion) {

        if(Objects.isNull(participant)||Objects.isNull(completion)){
            throw new IllegalArgumentException("입력값은 null일 수 없습니다.");
        }

        Map<String, Integer> completerFrequencyMap = new HashMap<>();
        for(String completer : completion){
            Objects.requireNonNull(completer, "completer 배열의 요소는 null일 수 없습니다.");
            completerFrequencyMap.compute(completer, (name, frequency)->(frequency==null)? 1:++frequency);
        }
        
        for(String runner: participant){
            Objects.requireNonNull(runner, "participant 배열의 요소는 null일 수 없습니다.");
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

    //스트림버전(성능 안 좋음)
     public String solution(String[] participant, String[] completion){
       Map<String, Long> completerFrequencyMap = Arrays.stream(completion)
               .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));//Fuction.identiy()-->값을 그대로 반환(키로 사용)

       return Arrays.stream(participant)
               .filter(runner->{
                   Long frequency = completerFrequencyMap.getOrDefault(runner, 0L);
                   if(frequency==0L){
                       return true;
                   } else {
                       completerFrequencyMap.put(runner, frequency-1);
                       return false;
                   }
               })
               .findFirst().
               orElse("");
    }
}
