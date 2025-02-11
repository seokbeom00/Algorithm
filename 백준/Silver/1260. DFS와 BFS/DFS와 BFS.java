import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int v = Integer.parseInt(line[2]);
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 1; i < n + 1; i++) {
            Collections.sort(graph.get(i));
        }
        boolean[] visited = new boolean[n + 1];
        System.out.print(v + " ");
        visited[v] = true;
        dfs(graph, visited, v);
        System.out.println();
        bfs(graph, v);
    }

    public static void bfs(List<List<Integer>> graph, int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        visited[start] = true;
        q.add(start);
        System.out.print(start + " ");
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int n : graph.get(node)) {
                if (!visited[n]) {
                    visited[n] = true;
                    System.out.print(n + " ");
                    q.add(n);
                }
            }
        }
    }

    public static void dfs(List<List<Integer>> graph, boolean[] visited, int start) {
        for (int node : graph.get(start)) {
            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");
                dfs(graph, visited, node);
            }
        }
    }
}