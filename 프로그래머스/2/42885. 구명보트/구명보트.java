import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Solution {
    public int solution(int[] people, int limit) {
        int answer =0;
        Arrays.sort(people);
        int index=0;

        for(int i=people.length-1; i>=index; i--){
            if(people[index]+people[i]<=limit){
                index++;
                answer++;
            }

            else {
                answer++;
            }
        }

        return answer;
    }

//테스트 케이스
 @DisplayName("사람들이 타는 최소한의 보트 수를 구한다.")
    @Test
    void test1(){
        Solution sut = new Solution();
        int[] input = {20, 30, 10, 50, 70};
        int limit = 40;
        int expected = 4;

        int actual = sut.solution(input, limit);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("사람들이 타는 최소한 보트 수를 구한다.(오답)")
    @Test
    void test2(){
        Solution sut = new Solution();
        int[] input = {20, 30, 10, 50, 70};
        int limit = 40;
        int expected = 2;

        int actual = sut.solution(input, limit);

        assertThat(actual).isNotEqualTo(expected);
    }

    @DisplayName("무거운 순으로 줄 섰을 때 최소한의 보트 수를 구한다")
    @Test
    void test3(){
        Solution sut = new Solution();
        int[] input = {80, 70, 50, 20, 10};
        int limit = 50;
        int expected = 4;

        int actual = sut.solution(input, limit);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("많은 사람들이 줄 섰을 때 최소한의 보트 수를 구한다")
    @Test
    void test4(){
        Solution sut = new Solution();
        int[] input = new int[50000];
        int limit = 100;
        for(int i =0; i<input.length; i++){
            input[i]= 50;
        }
        int expected=input.length/2;

        int actual = sut.solution(input, limit);

        assertThat(actual).isEqualTo(expected);
    }

        @DisplayName("모든 사람들의 무게가 같을 때 필요한 최소 보트 수를 계산한다.")
    @Test
    void test5(){
        Solution sut = new Solution();
        int[] input = new int[10];
        int limit = 60;
        for(int i =0; i<input.length; i++){
            input[i]= 50;
        }
        int expected=10;

        int actual = sut.solution(input, limit);

        assertThat(actual).isEqualTo(expected);
    }

}
