import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] scoville, int K) {
                int answer = 0;


                Queue<Integer> sortedScoville = new PriorityQueue<>();

                for (int a : scoville) {
                    sortedScoville.offer(a);
                }

                while (!sortedScoville.isEmpty() && sortedScoville.peek() < K) {
                    int a = sortedScoville.poll();
                    if (sortedScoville.isEmpty()) {
                        return -1;
                    }
                    int b = sortedScoville.poll();
                    sortedScoville.offer(a + b*2);
                    answer++;
                }

                return answer;
            }
        }