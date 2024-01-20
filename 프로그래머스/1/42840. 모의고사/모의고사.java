import java.util.ArrayList;

import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    public int[] solution(int[] answers) {
        int[] firstAnswer = {1,2,3,4,5};
        int[] secondAnswer = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdAnswer ={3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = new int[3];

        for(int i=0; i<answers.length; i++){
            if(firstAnswer[i%5] ==answers[i]) scores[0]++;
            if(secondAnswer[i%8] ==answers[i]) scores[1]++;
            if(thirdAnswer[i%10] ==answers[i]) scores[2]++;
        }

        int maxScore= IntStream.of(scores).max().orElse(0);

        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<scores.length; i++){
            if(scores[i]==maxScore){
                answer.add(i+1);
            }
        }
        return answer
                .stream().mapToInt(i->i)
                        .toArray();

    }
}