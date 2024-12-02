import java.util.*;
import java.io.*;

class Solution {
    private int bfs(ArrayList<ArrayList<Integer>> list, boolean[] visited){
        int answer = 0;
        int max_dis = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] {1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int node = arr[0];
            int dis = arr[1];
            if(dis == max_dis){
                        answer += 1;
                    }
                    else if(dis > max_dis){
                        max_dis = dis;
                        answer = 1;
                    }
            for (int i = 0; i < list.get(node).size(); i++) {
                int temp = list.get(node).get(i);
                if (!visited[temp]) {
                    visited[temp] = true;
                    queue.offer(new int[] {temp, dis + 1});
                }
            }
        }
        return answer;
    }
    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i = 0 ; i <= n ; i++) list.add(new ArrayList<>());
        for(int i=0; i<edge.length; i++){
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        boolean[] visited = new boolean[n+1];
        return bfs(list, visited);
    }
}