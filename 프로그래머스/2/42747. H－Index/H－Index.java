import java.util.Arrays;

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
}