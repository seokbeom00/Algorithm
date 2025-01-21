import java.util.*;
class Solution {
    public long solution(int distance, int[] rocks, int n) {
        long answer = 0;
        Arrays.sort(rocks);
        long left = 1;
        long right = distance;
        while(left <= right){
            long mid = (left + right) / 2;
            boolean flag = true;
            int count = n;
            long before = 0;
            for(int i=0; i<rocks.length; i++){
                if(rocks[i] - before < mid){
                    if(count > 0){
                        count -= 1;
                    }else{
                        flag = false;
                        break;
                    }
                }else{
                    before = rocks[i];
                }
            }
            if(distance - before < mid){
                if(count > 0){
                        count -= 1;
                    }else{
                        flag = false;
                    }
            }
            if(!flag){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        answer = right;
        return answer;
    }
}