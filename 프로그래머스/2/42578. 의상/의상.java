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
//테스트코드
          @Test
    void 정상_작동(){

        //given
        String[][] input = {{"aa", "b"}, {"bb", "b"}, {"cc", "a"} , {"dd","d"}};
        int expected = 11;

        //when
        int actual = solution(input);

        //then
      Assertions.assertThat(actual).isEqualTo(expected);


  }

    @Test
    void 정상_작동_오답(){

        //given
        String[][] input = {{"aa", "b"}, {"bb", "b"}, {"cc", "a"} , {"dd","d"}};
        int expected = 112;

        //when
        int actual = solution(input);

        //then
        Assertions.assertThat(actual).isNotEqualTo(expected);


    }

    @Test
    void 빈배열(){

        //given
        String[][] input = {};
        int expected = 0;

        //when
        int actual = solution(input);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);


    }

    @Test
    void 옷_한가지(){

        //given
        String[][] input = {{"AA", "a"}, {"AB", "a"}, {"ABC", "a"}};
        int expected = 3;

        //when
        int actual = solution(input);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);


    }

    @Test
    void 종류마다_옷한개(){

        //given
        String[][] input = {{"aa", "a"}, {"bb", "b"}, {"cc", "c"} , {"dd","d"}};
        int expected = 7;

        //when
        int actual = solution(input);

        //then
        Assertions.assertThat(actual).isNotEqualTo(expected);


    }

    @Test
    void 대규모_데이터(){

        //given
        int numberOfTypes = 30; // 옷의 최대 종류 수
        String[][] input = new String[numberOfTypes][2];

        for (int i = 0; i < numberOfTypes; i++) {
            input[i][0] = "Cloth" + i;
            input[i][1] = "Type" + i;
        }
        int expected = (int)Math.pow(2, numberOfTypes) - 1;


        //when
        int actual = solution(input);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);


    }
        
}
