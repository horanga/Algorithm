import java.util.HashMap;
import java.util.Map;


class Solution {
public int solution(String[][] clothes) {
        Map<String, Integer> clothMap = new HashMap<>();


        for(int i =0; i<clothes.length; i++) {
            
            
            String clothType = clothes[i][1];
            if (!clothType.equals("")){
            clothMap.compute(clothType, (type, count) -> (count == null) ? 1 : ++count);
            }
            }

        final int eachTypeNoClothing=1;
        int combination=1;

        for (int options : clothMap.values()) {
            combination *= (options + eachTypeNoClothing);
        }

        final int excludeAllNoClothing= 1;//모든 옷 종류에서 '아무것도 안 입음'을 선택한 케이스를 빼준다.
        combination -= excludeAllNoClothing;

        return combination;
}
}
