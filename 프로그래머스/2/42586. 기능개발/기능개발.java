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

 //테스트코드

@Test
    void 정상_작동(){
        //given
        int[] progress ={90, 80, 70};
        int[] speeds = {2, 5, 15};
        int[] expected ={3};
        //when
        int[] actual = solution(progress, speeds);

        //then

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 정상_작동_오답(){
        //given
        int[] progress ={90, 80, 70};
        int[] speeds = {10, 10, 11};
        int[] expected ={1, 2};
        //when
        int[] actual = solution(progress, speeds);

        //then

        Assertions.assertThat(actual).isNotEqualTo(expected);
    }

    @Test
    void 속도_동일(){
        //given
        int[] progress ={70, 70, 70};
        int[] speeds = {10, 10, 10};
        int[] expected ={3};
        //when
        int[] actual = solution(progress, speeds);

        //then

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 요소_한개(){
        //given
        int[] progress ={70};
        int[] speeds = {10};
        int[] expected ={1};
        //when
        int[] actual = solution(progress, speeds);

        //then

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 빈_배열(){
        //given
        int[] progress ={};
        int[] speeds = {};
        int[] expected ={};
        //when
        int[] actual = solution(progress, speeds);

        //then

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
