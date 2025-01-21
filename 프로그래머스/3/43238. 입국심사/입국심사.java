import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 1;
        long right = times[times.length-1] * (long)n;
        while(left <= right){
            long mid = (left + right) / 2;
            long done = 0;
            for(int i=0; i<times.length; i++){
                done += mid / times[i];
            }
            if(done >= n){
                right = mid - 1;
                answer = mid;
            }else{
                left = mid + 1;
            }
        }
        return answer;
    }
}