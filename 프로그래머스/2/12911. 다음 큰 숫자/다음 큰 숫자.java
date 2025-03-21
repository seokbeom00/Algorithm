import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int target = check(n);
        for(int i=n+1; i<1000001; i++){
            if(check(i) == target){
                answer = i;
                break;
            }
        }
        return answer;
    }
    public static int check(int num){
        int count = 0;
        while(true){
            if(num == 1){
                count++;
                break;
            }
            if(num == 0){
                break;
            }
            if(num%2 == 1){
                count++;
            }
            num /= 2;
        }
        return count;
    }
}