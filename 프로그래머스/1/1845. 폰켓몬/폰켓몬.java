import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {


    public int solution(int[] nums) {

        if(Objects.isNull(nums)){
            throw new IllegalArgumentException("입력값은 null을 참조할 수 없습니다.");
        }

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
    //스트림 버전
    public long solution2(int[] nums) {

        if (Objects.isNull(nums)) {
            throw new IllegalArgumentException("입력값은 null을 참조할 수 없습니다.");
        }

        final int MAX_UNIQUE = nums.length / 2;
        return Arrays.stream(nums)
                .distinct()
                .limit(MAX_UNIQUE)
                .count();
    }



//테스트코드

    @Test
    void 정확성_검사_정답(){
        //given
        int[] nums = {3, 3, 3, 3, 3, 3};
        int expected= 1;

        //when
        long actual = solution(nums);

        //then

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void 정확성_검사_오답(){
        //given
        int[] nums = {3, 3, 3, 3, 3, 3};
        int expected= 0;

        //when
        long actual = solution(nums);

        //then

        assertThat(actual).isNotEqualTo(expected);

    }

    @Test
    void 정확성_검사_빈배열(){
        //given
        int[] nums = {};
        int expected= 0;

        //when
        long actual = solution(nums);

        //then

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void 최대치_초과(){
        //given
        int[] nums = {1,2,1,3,5,6,7};
        int expected= 3;

        //when
        long actual = solution(nums);

        //then

        assertThat(actual).isEqualTo(expected);
        
}
}
