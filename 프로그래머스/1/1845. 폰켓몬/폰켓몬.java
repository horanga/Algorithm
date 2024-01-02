import java.util.HashSet;
import java.util.Set;

public class Solution {


    public int solution(int[] nums) {
        int answer = 0;

        Set<Integer> phoneKetMonType = new HashSet<>();
        
        for(int i =0; i<nums.length; i++){
            if(answer>=nums.length/2){
                break;
            }
            if(phoneKetMonType.add(nums[i])){
                answer++;
            } 
            
        }


        return answer;
    }
}