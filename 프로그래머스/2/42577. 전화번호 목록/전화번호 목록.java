public class Solution {

    import java.util.HashSet;
import java.util.Set;

public class Solution {


    public static boolean solution(String[] phone_book) {


        Set<String> phoneNumber = new HashSet<>();
        for(int i =0; i< phone_book.length; i++){
            phoneNumber.add(phone_book[i]);
        }

        for(int i =0; i<phone_book.length; i++){
            for(int j =0; j<phone_book[i].length(); j++)
                if(phoneNumber.contains(phone_book[i].substring(0, j)))
                    return false;
            }
        return true;
        }
}
