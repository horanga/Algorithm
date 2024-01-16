import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
        
    public static final int START_TIME_INDEX=0;
    public static final int PROCESSING_TIME_INDEX=1;

    public static int solution(int[][] jobs){
      
      if(jobs==null||jobs.length==0){
          throw new IllegalArgumentException("입력값이 부적절합니다.");
      }
      int elapsedTime=0;
      int currentJobStartTime=0;
      int jobIndex=0;
      int countOfProcessedJobs=0;

      Arrays.sort(jobs,(o1, o2)->o1[START_TIME_INDEX]-o2[START_TIME_INDEX]);
      PriorityQueue<int[]> waitingJobs = new PriorityQueue<>((o1, o2)->o1[PROCESSING_TIME_INDEX]-o2[PROCESSING_TIME_INDEX]);

      while(countOfProcessedJobs<jobs.length){
          while(jobIndex<jobs.length && jobs[jobIndex][START_TIME_INDEX]<=currentJobStartTime) {

              if (jobs[jobIndex] != null) {
                  waitingJobs.add(jobs[jobIndex++]);
              }
          }


          if(waitingJobs.isEmpty()){
              currentJobStartTime= jobs[jobIndex][START_TIME_INDEX];
          } else{
              int[] tmp =waitingJobs.poll();
              elapsedTime +=tmp[PROCESSING_TIME_INDEX] +currentJobStartTime -tmp[START_TIME_INDEX];
              currentJobStartTime +=tmp[PROCESSING_TIME_INDEX];
              countOfProcessedJobs++;
          }

      return (int) Math.floor(elapsedTime/jobs.length);

  }

//테스트코드
            
  @DisplayName("작업들의 대기시간 최소 평균을 계산할 수 있다.")
  @Test
    void testSolution(){
      //given
      int[][] input ={{0, 3}, {1, 9}, {2, 6}};
      int expected =9;
      //when

      int actual = solution(input);

      //then
      assertThat(actual).isEqualTo(expected);
  }

    @DisplayName("작업들의 대기시간 최소 평균을 계산할 수 있다.(오답)")
    @Test
    void testSolutionWithfalseEXpected(){
        //given
        int[][] input ={{0, 2}, {1, 3}, {2, 6}};
        int expected =9;
        //when

        int actual = solution(input);

        //then
        assertThat(actual).isNotEqualTo(expected);
    }
    @DisplayName("빈 배열을 예외처리할 수 있다.")
    @Test
    void testSolutionWithEmptyArray(){
        //given
        int[][] input ={};
        assertThatThrownBy(()->solution(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 부적절합니다.");


  }

    @DisplayName("같은 시간에 들어온 작업들의 최소 평균 대기시간을 계산할 수 있다.")
    @Test
    void testSolutionWithSameInt(){
        //given
        int[][] input ={{0, 1}, {0, 2}, {0, 3}};
        int expected =3;
        //when

        int actual = solution(input);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("작업하나의 평균 대기 시간을 계산할 수 있다.")
    @Test
    void testSolutionWithOneElement(){
        //given
        int[][] input ={{0, 6}};
        int expected =6;
        //when

        int actual = solution(input);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("경계값에 속하는 작업수의 최소 평균 대기 시간을 계산할 수 있다.")
    @Test
    void testSolutionWithBigData(){
        //given

        Random rand = new Random();
        int[][] input = new int[500][2];


        for(int i =0; i<500; i++){
           input[i][0]=rand.nextInt(1001);
           input[i][1]=1 + rand.nextInt(1000);
        }

        //when

        int actual = solution(input);

        //then
        assertThat(actual).isGreaterThan(200);
  }

    @DisplayName("대기 시간이 최대치인 경우에도 최소 평균 시간을 처리할 수 있다.")
    @Test
    void testSolutionWith최고대기시간(){
        //given

        int[][] input = {{0, 1000}, {1,900}, {3, 1000}};
        int expected = 1932;
        //when

        int actual = solution(input);

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
