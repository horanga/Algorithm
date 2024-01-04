import java.util.HashMap;
import java.util.Map;


class Solution {
public int solution(String[][] clothes) {
        Map<String, Integer> clothMap = new HashMap<>();


        for(int i =0; i<clothes.length; i++) {
            String clothType = clothes[i][1];
            clothMap.compute(clothType, (type, occurrences) -> (occurrences == null) ? 1 : ++occurrences);
        }

        int noClothes=1;
        int answer=1;

        for(Map.Entry<String, Integer> entry: clothMap.entrySet()) {
            answer *= (entry.getValue() + noClothes);
        }

        int withOutAllClothCase= 1;
        answer -= withOutAllClothCase;

        return answer;
}
}