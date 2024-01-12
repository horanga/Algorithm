class Solution {
public int[] solution(int[] prices) {
   int pricesLength=prices.length;
        int[] holdingTimes = new int[pricesLength];
        ArrayDeque<Integer> indiceStack = new ArrayDeque<>();

        for(int index =0; index<pricesLength; index++){
            while(!indiceStack.isEmpty() && prices[index]<prices[indiceStack.peek()]){
            int lastIndex= indiceStack.pop();
            holdingTimes[lastIndex] = index-lastIndex;

            }
        indiceStack.push(index);
        }


        while(!indiceStack.isEmpty()){
            int lastIndex=indiceStack.pop();
            holdingTimes[lastIndex] =pricesLength-lastIndex-1;
        }

        return holdingTimes;
    }

    @DisplayName("주식 가격이 떨어지지 않은 기간을 계산할 수 있다.")
    @Test
    void countSecond(){
        //given
        int[] prices = {2, 3, 1, 0,2};
        int[] expected ={2, 1, 1, 1, 0};

        //when
        int[] actual = solution(prices);

        //then
        assertThat(actual).isEqualTo(expected);
    }
    @DisplayName("주식 가격이 떨어지지 않은 기간을 계산할 수 있다.(실패케이스)")
    @Test
    void countSecondWithFalseExpedted(){
        //given
        int[] prices = {2, 3, 1, 0,2};
        int[] expected ={2, 1, 1, 1, 1};

        //when
        int[] actual = solution(prices);

        //then
        assertThat(actual).isNotEqualTo(expected);
    }
    @DisplayName("주식가격이 모두 동일할 때 가격이 떨어지지 않은 기간을 계산할 수 있다.")
    @Test
    void countSecondWithSamePrices(){
        //given
        int[] prices = {3, 3, 3, 3,3};
        int[] expected ={4, 3, 2, 1, 0};

        //when
        int[] actual = solution(prices);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("주식가격이 계속 떨어질 때 가격이 떨어지지 않은 기간을 계산할 수 있다.")
    @Test
    void countSecondWithDecreasingPrices(){
        //given
        int[] prices = {5, 4, 3, 2,1};
        int[] expected ={1, 1, 1, 1, 0};

        //when
        int[] actual = solution(prices);

        //then
        assertThat(actual).isEqualTo(expected);
    }
    @DisplayName("주식가격이 계속 올라갈 때 가격이 떨어지지 않은 기간을 계산할 수 있다.")
    @Test
    void countSecondWithIncreasingPrices(){
        //given
        int[] prices = {1, 2, 3, 4,5};
        int[] expected ={4, 3, 2, 1, 0};

        //when
        int[] actual = solution(prices);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("갖고 있는 주식이 없을 때는 주식이 떨어지지 않는 기간을 계산할 수 없다.")
    @Test
    void countSecondWithEmptyArray(){
        //given
        int[] prices = { };
        int[] expected ={ };

        //when
        int[] actual = solution(prices);

        //then
        assertThat(actual).isEqualTo(expected);
    }
    @DisplayName("100,000초 동안 주식 가격이 떨어지지 않은 기간을 구할 수 있다.")
    @Test
    void countSecondWithLargeData(){
        //given
        int[] prices = new int[100000];
        Arrays.fill(prices, 100);//모든 가격을 동일하게 설정


        //when
        int[] actual = solution(prices);

        //then
        for(int i = 0; i < 100000; i++){
            assertThat(99999 - i).isEqualTo(actual[i]);
        }
    }

}
