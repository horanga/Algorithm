
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {


    public int[] solution(String[] operations) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(String str: operations){
            String[] splits = str.split(" ");
            int a = Integer.parseInt(splits[1]);

            switch (splits[0]){
                case "I" : queue.offer(a);
                    break;
                case "D" :

                    if(a==1 && !queue.isEmpty()){
                        queue.remove(Collections.max(queue));

                    } else if(a==-1 && !queue.isEmpty()){
                        queue.remove(Collections.min(queue));

                    }
                    break;
             }
        }
        

           int[] answer = new int[2];
        if(queue.isEmpty()){
            return answer;
        }

        answer[0]= Collections.max(queue);
        answer[1]=Collections.min(queue);

    return answer;




    }
    }

