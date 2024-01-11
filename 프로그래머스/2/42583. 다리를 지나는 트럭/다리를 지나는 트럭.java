import java.util.LinkedList;
import java.util.Queue;

public class Solution {
     public static int solution(int bridge_length, int weight, int[] truck_weights) {


        Queue<Integer> bridge = new LinkedList<>();
        int totalWeights = 0;
        int timeElapsed = 0;

        for (int i =0; i<bridge_length; i++){
            bridge.add(0);
        }

        for(int truck :truck_weights){
            while((totalWeights+truck-bridge.peek())>weight){
                totalWeights -=bridge.remove();
                bridge.add(0);
                timeElapsed++;
            }
totalWeights -=bridge.remove();
            totalWeights +=truck;
            bridge.add(truck);
            timeElapsed++;
        }

    return timeElapsed+bridge_length;
    }
}
