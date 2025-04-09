import java.util.*;
class Solution {
    static Map<Integer, List<Integer>> tree;
    static boolean[] visit;
    static int even, odd, reverseEven, reverseOdd;
    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = new int[2];
        tree = new HashMap<>();
        int max = 0;
        for(int node : nodes){
            max = Math.max(max, node);
            tree.put(node, new ArrayList<>());
        }
        for(int[] edge : edges){
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        visit = new boolean[max+1];
        for(int node : nodes){
            if(visit[node]){
                continue;
            }
            init();
            visit[node] = true;
            visit[node] = true;
            dfs(node);
            if(even == 1 && odd == 0){
                answer[0]++;
            }
            if(odd == 1&& even == 0){
                answer[0]++;
            }
            if(reverseEven == 1 && reverseOdd == 0){
                answer[1]++;
            }
            if(reverseOdd == 1 && reverseEven == 0){
                answer[1]++;
            }
        }
        return answer;
    }
    public static void dfs(int node){
        if(node % 2 == 0 && tree.get(node).size() % 2 == 0){
            even++;
        }
        if(node % 2 == 1 && tree.get(node).size() % 2 == 1){
            odd++;
        }
        if(node % 2 == 0 && tree.get(node).size() % 2 == 1){
            reverseEven++;
        }
        if(node % 2 == 1 && tree.get(node).size() % 2 == 0){
            reverseOdd++;
        }
        for(int next : tree.get(node)){
            if(visit[next]){
                continue;
            }
            visit[next] = true;
            dfs(next);
        }
    }
    public static void init(){
        even = 0;
        odd = 0;
        reverseEven = 0;
        reverseOdd = 0;
    }
}