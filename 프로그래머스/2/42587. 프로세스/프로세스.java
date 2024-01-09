import java.util.*;

class Solution {
      public static int solution(int[] priorities, int location) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int completedJobCount = 0;


        for (int i : priorities) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {

            for (int i = 0; i < priorities.length; i++) {
                if (queue.peek() == priorities[i]) {
                    queue.poll();
                    completedJobCount++;

                    if (location == i) {
                        return completedJobCount;
                    }
                }
            }
        }
        return completedJobCount;
    }

      //테스트코드

       @Test
    void 정상_작동(){
        //given
        int[] input = {1, 1, 9, 1, 1, 1};
        int location= 0;
        int expected = 5;
        //when

        int actual = solution(input, location);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 정상_작동_오답(){
        //given
        int[] input = {2, 2, 2, 4, 5, 6};
        int location= 2;
        int expected = 4;
        //when

        int actual = solution(input, location);

        //then
        Assertions.assertThat(actual).isNotEqualTo(expected);
    }

    @Test
    void 빈_배열(){
        //given
        int[] input = {};
        int location= 0;
        int expected = 0;
        //when

        int actual = solution(input, location);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void null_처리(){
        //given
        int[] input = null;
        int location= 0;
        int expected = 0;
        //when

        int actual = solution(input, location);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 숫자_한개(){
        //given
        int[] input = {1};
        int location= 1;
        int expected = 1;
        //when

        int actual = solution(input, location);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 숫자_중복(){
        //given
        int[] input = {1,1,1,1,1,1};
        int location= 6;
        int expected = 6;
        //when

        int actual = solution(input, location);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 경계값(){
        //given
        int[] input = new int[100];
        for(int i =0; i<input.length;i++){
            input[i] =(i%9)+1;
        }

        int location= 98;
        int expected = 11;
        //when

        int actual = solution(input, location);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
