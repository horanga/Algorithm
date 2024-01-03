public class Solution {

import java.util.HashSet;
import java.util.Set;

public class Solution {


        public static boolean solution(String[] phone_book) {


        Set<String> phoneNumberSet = new HashSet<>();
        for(String phone: phone_book){
            phoneNumberSet.add(phone);
        }

        //substring(startIndex, endIndex)는 startIndex부터 endIndex-1까지를 반환한다. 그래서, 시작점은 j=1로 잡아주었다. 
        for(String phone: phone_book){
            for(int j =1; j<phone.length(); j++)
                if(phoneNumberSet.contains(phone.substring(0, j)))
                    return false;
            }
        return true;
        }
}
