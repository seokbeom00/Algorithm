import java.util.*;
class Solution {
    public String solution(long n, String[] bans) {
        ArrayList<String> ban_list = new ArrayList<>(Arrays.asList(bans));
        ban_list.sort((b1, b2) -> {
            if(b1.length() != b2.length()){
                return Integer.compare(b1.length(), b2.length());
            }else{
                return b1.compareTo(b2);
            }
        });
        for(String ban : ban_list){
            if(strToNum(ban) > n){
                break;
            }else{
                n++;
            }
        }
        return numToStr(n);
    }
    public static String numToStr(long num){
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            num--;
            char c = (char)(num % 26 + 'a');
            sb.append(c);
            num/=26;
        }
        return sb.reverse().toString();
    }
    
    public static long strToNum(String string){
        long num = 0;
        int len = string.length();
        for(int i=0; i<string.length(); i++){
            num += (string.charAt(len - i - 1) - 'a' + 1) * Math.pow(26, i);
        }
        return num;
    }
}