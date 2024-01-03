public class Solution {

    public static void main(String[] args) {
        String[] aa ={"119", "97674223", "1195524421"};
        solution(aa);
    }

    public static boolean isContained(String longerNumber, String shortNumber){
        for(int i=0; i<shortNumber.length(); i++){
            if(longerNumber.charAt(i)!=shortNumber.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        String a="";
        String b="";

        for(int i =0; i<phone_book.length; i++){
            a= phone_book[i];
            for(int j =i+1; j<phone_book.length;j++){
                b= phone_book[j];

                if(b.indexOf(a)!=-1) {
                    if(isContained(b, a)) {
                        answer=false;
                        break;
                    }
                } else if(a.indexOf(b)!=-1){
                   if(isContained(a, b)) {
                       answer = false;
                       break;
                   }

                }
            }
            if(!answer){
                break;
            }
        }

        return answer;
    }
}