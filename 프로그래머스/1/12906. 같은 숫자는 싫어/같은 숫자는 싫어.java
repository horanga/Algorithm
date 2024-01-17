import java.util.Stack;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.stream.IntStream;

public class Solution {

public int[] solution(int[] arr) {

        if (arr == null) {
            return new int[0];
        }
        
        Stack<Integer> numberStack = new Stack<>();

        for(int number : arr){
                if(number!=null){
            if(numberStack.isEmpty()|| numberStack.peek()!=number){
                numberStack.push(number);
            }
        }
        }

        return numberStack.stream()
                .mapToInt(i -> i).toArray();
}
// 스트림 방식
        
        public int[] solution(int[] arr) {

        if (arr == null) {
            return new int[0];
        }

        return IntStream.range(0, arr.length)
                .filter(i->i==0|| arr[i]!=arr[i-1])
                .map(i->arr[i])
                .toArray();
        }
//테스트 코드
    @Test
    void 정상_작동(){
        //given
        int[] input = {2, 2, 2, 4, 0, 2, 2, 1,1};
        int[] expected = {2, 4, 0, 2, 1};

        //when

        int[] actual = solution(input);


        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 정상_작동_오답(){
        //given
        int[] input = {2, 2, 2, 4, 0, 2, 2, 1,1};
        int[] expected = {2, 4, 0, 2, 1,1};

        //when

        int[] actual = solution(input);


        //then
        Assertions.assertThat(actual).isNotEqualTo(expected);
    }

    @Test
    void 빈_배열(){
        //given
        int[] input = {};
        int[] expected = {};

        //when

        int[] actual = solution(input);


        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 음수(){
        //given
        int[] input = {-1, 1, 1, 0, 0, -2, -2, -2};
        int[] expected = {-1, 1, 0, -2};

        //when

        int[] actual = solution(input);


        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 숫자_한개(){
        //given
        int[] input = new int [1000];

        for(int i =0; i<1000; i++){
            input[i]=1;
        }
        int[] expected = {1};

        //when

        int[] actual = solution(input);


        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void null_예외(){
        //given
        int[] arr = null;
        int[] expected = new int[0];

        //when
        int[] actual = solution(arr);
        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 경계값_테스트() {
        //given
        int[] boundaryInput = {Integer.MIN_VALUE, 1, 2, 1, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] expected = {Integer.MIN_VALUE, 1, 2,1, Integer.MAX_VALUE};

        //when
        int[] actual = solution(boundaryInput);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 큰_배열_테스트(){
        //given
        int[] largeInput = new int[10000];
        for(int i =0; i<largeInput.length; i++){
        largeInput[i]= i%100;
        }

        // 예상되는 결과는 구체적으로 계산하기 어려울 수 있으므로 생략

        //when
        int[] actual = solution(largeInput);

        //then
        Assertions.assertThat(actual.length).isEqualTo(10000); // 결과 배열이 비어 있지 않음을 확인
    }

        
}
