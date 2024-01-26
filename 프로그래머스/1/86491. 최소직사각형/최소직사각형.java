import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class Solution {
       public static int solution(int[][] sizes) {

    int maxLongSide=0 , maxShortSide= 0;


    for(int[] size :sizes){
        int longSide =Math.max(size[0],size[1]);
        int shortSide =Math.min(size[0],size[1]);
        
        maxLongSide= Math.max(maxLongSide, longSide);
        maxShortSide= Math.max(maxShortSide, shortSide);
    }

    return maxLongSide*maxShortSide;
    }

//스트림 버전
public int solution(int[][] sizes) {

        int maxLongSide = Arrays.stream(sizes)
                .mapToInt(size->Math.max(size[0], size[1]))
                .max()
                .orElse(0);

        int minLongSide =Arrays.stream(sizes)
                .mapToInt(size->Math.min(size[0], size[1]))
                .max()
                .orElse(0);

        return maxLongSide*minLongSide;
    }

//테스트 케이스
    @DisplayName("모든 명함 크기를 다 맞출 수 있는 최대 크기의 명함을 만들 수 있다.")
    @Test
    void test1(){

        //given
        int[][] size ={{40,50},{50,60}, {70,30}};
        int expected =3500;

        //when
        int actual = solution(size);
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("모든 명함 크기를 다 맞출 수 있는 최대 크기의 명함을 만들 수 있다.(오답)")
    @Test
    void test2(){

        //given
        int[][] size ={{40,50},{50,60}, {70,30}};
        int expected =350;

        //when
        int actual = solution(size);
        //then
        assertThat(actual).isNotEqualTo(expected);
    }

    @DisplayName("모든 명함 크기가 다 똑같아도 필요한 명함의 최대 크기를 계산할 수 있다.")
    @Test
    void test3(){
        //given
        int[][] size ={{40,50},{50,40}};
        int expected =2000;

        //when
        int actual = solution(size);
        //then
        assertThat(actual).isEqualTo(expected);
    }


    @DisplayName("명함의 개수가 최대치에 달해도 필요한 명함의 최대 크기를 계산할 수 있다.")
    @Test
    void test4(){
        //given
        int[][] size = new int[10000][2];

        for(int i=0; i<size.length; i++){
            size[i][0]= i;
            size[i][1]= i%100;
        }
        int expected = 9999*99;

        //when
        int actual = solution(size);
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("명함의 가로 길이가 최대치에 달해도 필요한 명함의 최대 크기를 계산할 수 있다.")
    @Test
    void test5(){
        //given
        int[][] size = {{1000, 10}, {900, 90}};
        int expected = 90000;

        //when
        int actual = solution(size);
        //then
        assertThat(actual).isEqualTo(expected);
    }

}
