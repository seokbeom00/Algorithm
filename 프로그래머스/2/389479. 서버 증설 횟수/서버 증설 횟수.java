import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        List<Integer> servers = new ArrayList<>();
        for(int player : players){
            for(int i = servers.size() - 1; i>=0; i--){
                int s = servers.get(i) - 1;
                if(s == 0){
                    servers.remove(i);
                }else{
                    servers.set(i, s);
                }
            }
            int server = servers.size();
            int need = player / m;
            if(server < need){
                answer += need - server;
                for(int i = 0; i< need - server; i++){
                    servers.add(k);
                }
            }
            // System.out.println();
        }
        return answer;
    }
}