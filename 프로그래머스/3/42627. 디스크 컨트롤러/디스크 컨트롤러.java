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
      int timeAfterJobProcessed=0;
      int jobIndex=0;
      int countOfProcessedJobs=0;

      Arrays.sort(jobs,(o1, o2)->o1[START_TIME_INDEX]-o2[START_TIME_INDEX]);
      PriorityQueue<int[]> waitingJobs = new PriorityQueue<>((o1, o2)->o1[PROCESSING_TIME_INDEX]-o2[PROCESSING_TIME_INDEX]);

      while(countOfProcessedJobs<jobs.length){
          while(jobIndex<jobs.length && jobs[jobIndex][START_TIME_INDEX]<=timeAfterJobProcessed) {

              if (jobs[jobIndex] != null) {
                  waitingJobs.add(jobs[jobIndex++]);
              }
          }


          if(waitingJobs.isEmpty()){
              timeAfterJobProcessed= jobs[jobIndex][START_TIME_INDEX];
          } else{
              int[] tmp =waitingJobs.poll();
              elapsedTime +=tmp[PROCESSING_TIME_INDEX] +timeAfterJobProcessed -tmp[START_TIME_INDEX];
              timeAfterJobProcessed +=tmp[PROCESSING_TIME_INDEX];
              countOfProcessedJobs++;
          }



      }

      return (int) Math.floor(elapsedTime/jobs.length);

  }


}
