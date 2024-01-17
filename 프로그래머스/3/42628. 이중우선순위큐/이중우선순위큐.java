
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.PriorityQueue;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(String op : operations) {
            String[] parts = op.split(" ");
            int number = Integer.parseInt(parts[1]);

            if(parts[0].equals("I")) {
                minQueue.offer(number);
                maxQueue.offer(number);
            } else if(!minQueue.isEmpty()) {
                if(number == 1) {
                    int max = maxQueue.poll();
                    minQueue.remove(max);
                } else {
                    int min = minQueue.poll();
                    maxQueue.remove(min);
                }
            }
        }

        int[] answer = {maxQueue.isEmpty() ? 0 : maxQueue.peek(), minQueue.isEmpty() ? 0 : minQueue.peek()};
        return answer;

    }

//테스트코드
 @Test
    @DisplayName("가장 큰 수와 가장 작은 수를 구할 수 있다.")
    void test(){
        //given
        String[] input = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] expected = {333, -45};

        //when
        int[] actual = solution(input);

        //then

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("가장 큰 수와 가장 작은 수를 구할 수 있다.(오답)")
    void test1(){
        //given
        String[] input = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] expected = {333, 0};

        //when
        int[] actual = solution(input);

        //then

        assertThat(actual).isNotEqualTo(expected);
    }

    @Test
    @DisplayName("값이 하나만 있어도 가장 큰 수와 가장 작은 수를 구할 수 있다.")
    void test2(){
        //given
        String[] input = {"I -45"};
        int[] expected = {-45, -45};

        //when
        int[] actual = solution(input);

        //then

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("가장 큰 수와 가장 작은 수는 둘다 0일 수 있다.")
    void test3(){
        //given
        String[] input = {"I -45", "D -1"};
        int[] expected = {0, 0};

        //when
        int[] actual = solution(input);

        //then

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    @DisplayName("큰 데이터도 처리할 수 있다.")
    void test4(){
        //given
        String[] input = new String[10000];

        for(int i =0; i<input.length; i++){
            input[i]= "I "+i;
        }
        input[9999]= "D 1";


        int[] expected ={9997, 0};
        //큐에는 최대 9998까지 숫자가 들어감. 위에서 input[9999]를 D 1으로 변경해줬기 때문.
        //이에 마지막 D 1 명령어로 9998(최대값)이 사라지고, 그 다음 최대값 9997이 나옴.

        //when
        int[] actual = solution(input);

        //then

        assertThat(actual).isEqualTo(expected);
    }
    
    }
