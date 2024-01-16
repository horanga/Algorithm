import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Solution {
 public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>(commands.length);

        for(int[] command :commands){
            List<Integer> list = new ArrayList<>();
            int startIndex=command[0]-1;
            int endIndex =command[1]-1;

            for(int i =startIndex; i<=endIndex; i++){
                list.add(array[i]);
            }

            Collections.sort(list);
            int k = list.get(command[2]-1);
            answer.add(k);
        }

        return answer.stream()
                .mapToInt(i->i)
                .toArray();
    }
}