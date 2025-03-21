import java.util.*;
class Solution {
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, words, 0, target);
        if(min == Integer.MAX_VALUE){
            return 0;
        }else{
            return min;
        }
    }
    public static void dfs(String s, String[] words, int cnt, String target){
        if(cnt > min){
            return;
        }
        if(s.equals(target)){
            min = cnt;
            return;
        }
        for(int i=0; i<words.length; i++){
            if(check(s, words[i]) && !visited[i]){
                visited[i] = true;
                dfs(words[i], words, cnt+1, target);
                visited[i] = false;
            }
        }
    }
    public static boolean check(String s1, String s2){
        int cnt = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                cnt ++;
            }
        }
        if(cnt == 1){
            return true;
        }else{
            return false;
        }
    }
}