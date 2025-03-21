import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(int n) {
        for(int i=1; i<=n; i++){
            dfs(i, n, i);
        }
        return answer;
    }
    public static void dfs(int sum, int target, int num){
        if(sum > target){
            return;
        }
        if(sum == target){
            answer++;
            return;
        }
        dfs(sum+num+1, target, num+1);
    }
}