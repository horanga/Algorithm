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
}
