import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int solution(int[] nums) {
        int answer = 0;
        final int MAX_UNIQUE = nums.length / 2;

        Set<Integer> uniquePokemons = new HashSet<>();
        
        for(int i =0; i<nums.length&& answer < MAX_UNIQUE; i++){
            if(uniquePokemons.add(nums[i])){
                answer++;
            } 
            
        }
        return answer;
    }
}
