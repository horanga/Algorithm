class Solution {
       public static int solution(int[][] sizes) {

    int maxLongSide=0 , maxShortSide= 0;


    for(int[] size :sizes){
        int longSide =Math.max(size[0],size[1]);
        int shortSide =Math.min(size[0],size[1]);
        
        maxLongSide= Math.max(maxLongSide, longSide);
        maxShortSide= Math.max(maxShortSide, shortSide);
    }

    return maxLongSide*maxShortSide;
    }
}