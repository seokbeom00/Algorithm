import java.util.*;
class Solution {
    static int answer;
    static boolean[] visited;
    static Set<Set<String>> result = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        dfs(new HashSet<>(), 0, user_id, banned_id);
        return result.size();
    }
    
    public static void dfs(HashSet<String> set, int idx, String[] user_id, String[] banned_id){
        if(set.size() == banned_id.length){
            result.add(new HashSet<>(set));
            return;
        }
        for(int i=0; i<user_id.length; i++){
            if(check(user_id[i], banned_id[idx]) && !visited[i]){
                visited[i] = true;
                set.add(user_id[i]);
                dfs(set, idx+1, user_id, banned_id);
                visited[i] = false;
                set.remove(user_id[i]);
            }
        }
    }
    
    public static boolean check(String user, String ban){
        if(user.length() != ban.length()){
            return false;
        }
        for(int i=0; i<user.length(); i++){
            if(ban.charAt(i) == '*'){
                continue;
            }
            if(user.charAt(i) != ban.charAt(i)){
                return false;
            }
        }
        return true;
    }
}