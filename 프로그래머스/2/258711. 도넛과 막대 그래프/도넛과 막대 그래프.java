import java.io.*;
import java.util.*;
class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static int createNode = 0;
    static boolean[] visited;
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        for(int i=0; i<1000001; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[1000001];
        int[] indegree = new int[1000001];
        int[] outdegree = new int[1000001];
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            outdegree[edge[0]]++;
            indegree[edge[1]]++;
        }
        for(int i=1; i<1000001; i++){
            if (outdegree[i] >= 2 && indegree[i] == 0) {
                createNode = i;
                break;
            }
        }
        answer[0] = createNode;
        visited[createNode] = true;
        for(int start : graph.get(createNode)){
            int[] cnt = new int[2];
            checkCnt(start, cnt);
            if(cnt[0] == cnt[1]){
                answer[1] += 1;
            }else if(cnt[0] - 1 == cnt[1] - 2){
                answer[3] += 1;
            }else if(cnt[0] - 1 == cnt[1]){
                answer[2] += 1;
            }
        }
        return answer;
    }
    public static void checkCnt(int node, int[] cnt){
        cnt[0] += 1;
        cnt[1] += graph.get(node).size();
        visited[node] = true;
        for(int next : graph.get(node)){
            if(!visited[next]){
                checkCnt(next, cnt);
            }
        }
    }
}