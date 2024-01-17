import java.util.Arrays;

class Solution {
 public int[] solution(int[] array, int[][] commands) {

	 if(array==null ||commands==null){
            throw new IllegalArgumentException("입력값은 null일 수 없습니다.");
        }
	 
       int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]); 
            					   // 원본 배열, 복사할 시작인덱스, 복사할 끝인덱스

			Arrays.sort(temp); // 배열 오름차순 정렬
			answer[i] = temp[commands[i][2] - 1];
		}
		return answer;
	}

//stream 버전(첫번째보다 3초정도씩 느림)

	public int[] solution(int[] array, int[][] commands) {

        return Arrays.stream(commands)
                .mapToInt(command -> {
                    int[] temp = Arrays.copyOfRange(array, command[0]-1, command[1]);
                    Arrays.sort(temp);
                    return temp[command[2] - 1];

                })
                .toArray();
    }

//테스트케이스
    @Test
    @DisplayName("정해진 범위에서 특정 위치에 있는 숫자를 찾을 수 있다.")
    void test(){
        //given
        int[] input = {1,6,2,7,3};
        int[][] command = {{1, 3, 2}, {2,3, 2}};
        int[] expected = {2, 6};

        //when
        int[] actual =solution(input,command);
        //then
        assertThat(actual).isEqualTo(expected);


    }

    @Test
    @DisplayName("정해진 범위에서 특정 위치에 있는 숫자를 찾을 수 있다.(실패)")
    void test1(){
        //given
        int[] input = {1,6,2,7,3};
        int[][] command = {{1, 3, 2}, {2, 3, 1}};
        int[] expected = {2, 3};

        //when
        int[] actual =solution(input,command);
        //then
        assertThat(actual).isNotEqualTo(expected);
    }

    @Test
    @DisplayName("입력값이 null일 때 계산을 하지 않는다.")
    void test3(){
        //given
        int[] input = null;
        int[][] command = null;

    assertThatThrownBy(()->solution(input, command))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력값은 null일 수 없습니다.");
    }

    @Test
    @DisplayName("값이 1개여도 계산할 수 있다.")
    void test4(){
        //given
        int[] input = {1};
        int[][] command = {{1,1,1}};
        int[] expected = {1};
        //when
        int[] actual = solution(input, command);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("값이 모두 동일해도 계산할 수 있다.")
    void test5(){
        //given
        int[] input = {1,1,1,1,1};
        int[][] command = {{1,4,2}, {2, 5, 1}};
        int[] expected = {1,1};
        //when
        int[] actual = solution(input, command);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("역순으로 들어온 값도 계산할 수 있다.")
    void test6(){
        //given
        int[] input = {6,5,4,3,2};
        int[][] command = {{1,4,2}, {2, 5, 1}};
        int[] expected = {4,2};
        //when
        int[] actual = solution(input, command);

        //then
        assertThat(actual).isEqualTo(expected);
    }
 @Test
    @DisplayName("입력값이 경계값에 있어도 계산할 수 있다.")
    void test7(){
        //given
        int[] input = new int[100];
        int[][] command = new int[50][3];

        for(int i =1; i<100; i++){
            input[i-1]=i;
        }

        for (int i = 0; i < 50; i++) {
            command[i][0] = Math.max(1, i); // 시작 인덱스 (1부터 시작해야 하므로)
            command[i][1] = Math.min(100, i + 10); // 종료 인덱스 (100을 넘지 않도록)
            command[i][2] = 2; // k번째 요소 (예시로 1을 사용)
        }

        int expected1 =2;
        int expected49=50;

        //when

        int[] result = solution(input, command);

        //then
        assertThat(result).hasSize(50); // 검사가 복잡하므로 결과 배열의 길이 검증
        assertThat(result[0]).isEqualTo(expected1);
        assertThat(result[49]).isEqualTo(expected49);

    }

}
