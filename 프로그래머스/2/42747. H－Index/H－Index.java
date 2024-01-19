import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
       public int solution(int[] citations) {
        Arrays.sort(citations);

        int maxHIndex = 0;

        for (int i = 0; i < citations.length; i++) {
            int hIndex = Math.min(citations[i], citations.length - i);
            maxHIndex = Math.max(maxHIndex, hIndex);
        }
        return maxHIndex;
    }

//스트림버전
     public int solution(int[] citations) {
         Arrays.sort(citations);

         return IntStream.rangeClosed(0, citations.length-1)
                 .map(i->Math.min(citations[i], citations.length - i))
                 .max()
                 .orElse(0);


    }
//테스트 케이스
    @DisplayName("논문의 인용수를 계산해서 H-index를 계산할 수 있다.")
    @Test
    void test1(){
        //given
        int[] ciations = {2, 1, 1, 2, 2, 3, 4, 5, 6};
        int expected = 3;

        //when
        int actual = solution(ciations);

        //then

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("논문의 인용수를 계산해서 H-index를 계산할 수 있다.(오답)")
    @Test
    void test2(){
        //given
        int[] ciations = {2, 1, 1, 2, 2, 3, 4, 4, 5, 6};
        int expected = 3;

        //when
        int actual = solution(ciations);

        //then

        assertThat(actual).isNotEqualTo(expected);
    }

    @DisplayName("인용수가 모두 같을 때 H-index를 계산할 수 있다.")
    @Test
    void test3(){
        //given
        int[] ciations = {1, 1, 1, 1, 1};
        int expected = 1;

        //when
        int actual = solution(ciations);

        //then

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("인용된 논문이 없을 때 H-index를 계산할 수 있다.")
    @Test
    void test4(){
        //given
        int[] ciations = {};
        int expected = 0;

        //when
        int actual = solution(ciations);

        //then

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("역순 정렬된 논문 인용수를 통해서 H-index를 계산할 수 있다.")
    @Test
    void test5(){
        //given
        int[] ciations = {6, 5, 4, 3, 2, 1, 0};
        int expected = 3;

        //when
        int actual = solution(ciations);

        //then

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("인용 횟수 차이가 크게 나도 H-index를 구할 수 있다.")
    @Test
    void test6(){
        //given
        int[] ciations = {1, 1, 1, 201, 202, 203, 204};
        int expected = 4;

        //when
        int actual = solution(ciations);

        //then

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("논문의 수가 많아도 H-index를 구할 수 있다.")
    @Test
    void test7(){
        //given
        int[] ciations = new int[1000];
        for(int i =0; i<ciations.length; i++){
            ciations[i]=10000-i;
        }
        int expected = 1000;

        //when
        int actual = solution(ciations);

        //then

        assertThat(actual).isEqualTo(expected);
    }
}
