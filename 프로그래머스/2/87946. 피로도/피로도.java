public class Solution {

    boolean[] visited;
    int count=0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        combination(dungeons, k, 0);
        return count;

    }

    public void combination(int[][] dungeons, int k, int depth) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                combination(dungeons, k - dungeons[i][1], depth + 1);
                visited[i] = false;
            }
        }
        count=Math.max(count, depth);

        }

}
