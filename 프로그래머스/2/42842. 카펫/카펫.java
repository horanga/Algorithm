public class Solution {

    int a =0;
    int b=0;
    public int[] solution(int brown, int yellow) {
            for(int i =1; i<=brown/2; i++){
                calculate(brown, yellow, i);
                if(a>0&&b>0&&(a-2)*(b-2)==yellow){
                    return new int[]{a,b};
                }
            }

            return new int[]{0,0};
    }


    private void calculate(int brown,int yellow, int index) {

        for(int i =1; i<=index+2; i++){
            if(index>=i){
                if(brown+yellow==(index)*(i)){
                    a=index;
                    b=i;
                    break;

                }

            }
        }
    }
}