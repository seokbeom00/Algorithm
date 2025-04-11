import java.util.*;
class Solution {
    static int N, M;
    static int[][] Info;
    static int answer = Integer.MAX_VALUE;
    static Set<String> visit = new HashSet<>();
    public int solution(int[][] info, int n, int m) {
        N = n;
        M = m;
        Info = info;
        dfs(0, 0, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    public static void dfs(int index, int A, int B){
        if(A >= N || B >= M || A > answer){
            return;
        }
        if(index == Info.length){
            answer = Math.min(answer, A);
            return;
        }
        String key = A + "," + B + "," + index;
        if(visit.contains(key)){
            return;
        }else{
            visit.add(key);
        }
        dfs(index+1, A + Info[index][0], B);
        dfs(index+1, A, B + Info[index][1]);
    }
}