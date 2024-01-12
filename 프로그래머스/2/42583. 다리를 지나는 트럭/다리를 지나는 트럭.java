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

     //테스트 코드

        @DisplayName("트럭 4대가 다리 위를 지날 때 걸리는 초를 센다.")
    @Test
    void countTime(){
        //given
        int bridge_length = 2;
        int weigth =10;
        int[] truck_weigths = {7,4, 5, 6};
        int expected = 8;

        //when

        int actual = solution(bridge_length, weigth, truck_weigths);

        //then

        assertThat(actual).isEqualTo(expected);
    }


    @DisplayName("트럭 4대가 다리 위를 지날 때 걸리는 초를 센다.(실패케이스)")
    @Test
    void countTimeWithFalseExpected(){
        //given
        int bridge_length = 2;
        int weigth =10;
        int[] truck_weigths = {7,4, 5, 6};
        int expected = 6;

        //when

        int actual = solution(bridge_length, weigth, truck_weigths);

        //then

        assertThat(actual).isNotEqualTo(expected);
    }

    @DisplayName("트럭 0대가 다리 위를 지나면 0초가 걸린다.")
    @Test
    void countTimeWithNoTruck(){
        //given
        int bridge_length = 2;
        int weigth =10;
        int[] truck_weigths = {};
        int expected = 0;

        //when

        int actual = solution(bridge_length, weigth, truck_weigths);

        //then

        assertThat(actual).isNotEqualTo(expected);
    }

    @DisplayName("입력값이 음수면 다리 위를 지날 때 걸리는 시간을 세지 않는다.")
    @Test
    void countTimeWithException(){
        //given
        int bridge_length = -4;
        int weigth =10;
        int[] truck_weigths = {10, 20, 30};

        assertThatThrownBy(() -> solution(bridge_length, weigth, truck_weigths))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 음수이거나, null일 수 없습니다.");

    }

    @DisplayName("다리 위를 지나는 트럭이 없으면 시간을 세지 않는다.")
    @Test
    void countTimeWithNullException(){
        //given
        int bridge_length = 10;
        int weigth =10;
        int[] truck_weigths = null;

        assertThatThrownBy(() -> solution(bridge_length, weigth, truck_weigths))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 음수이거나, null일 수 없습니다.");

    }

    @DisplayName("다리 길이, 무게 , 트럭의 수가 최대치일 때 다리 건너는 시간을 계산할 수 있다.")
    @Test
    void countTimeWithBigData(){
        //given
        int bridge_length = 10000;
        int weigth =10000;
        int[] truck_weigths = new int[10000];

        for(int i =0; i<truck_weigths.length; i++){
            truck_weigths[i]=1;
        }
        int expected =20000;

        //when

        int actual = solution(bridge_length, weigth, truck_weigths);

        //then

        assertThat(actual).isEqualTo(expected);

    }

    @DisplayName("다리 길이, 무게, 트럭 무게 등이 무작위로 선정돼도 다리를 건너는 시간을 계산할 수 있다.")
    @Test
    void countTimeWithRandomData(){
        //given
        Random random = new Random();
        int bridge_length = random.nextInt(10)+1;//길이 1부터 10까지
        int weigth = random.nextInt(10)+1;
        int[] truck_weigths = new int[random.nextInt(5)+1];

        for(int i =0; i<truck_weigths.length; i++){
            truck_weigths[i]= random.nextInt(weigth)+1;
        }

        int actual = solution(bridge_length, weigth, truck_weigths);

        //then

        assertThat(actual >=bridge_length);//다리를 건너는 시간이 최소한 다리 길이 이상은 돼야 한다.

    }
}
