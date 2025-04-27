import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, Q;
    static int count;
    static List<List<int[]>> graph;
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        Q = Integer.parseInt(line[1]);
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            line = br.readLine().split(" ");
            int p = Integer.parseInt(line[0]);
            int q = Integer.parseInt(line[1]);
            int r = Integer.parseInt(line[2]);
            graph.get(p).add(new int[]{q, r});
            graph.get(q).add(new int[]{p, r});
        }
        for (int i = 0; i < Q; i++) {
            line = br.readLine().split(" ");
            int k = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            count = 0;
            boolean[] visit = new boolean[N + 1];
            visit[v] = true;
            dfs(Integer.MAX_VALUE, k, visit, v);
            System.out.println(count);
        }
    }

    public static void dfs(int min, int k, boolean[] visit, int node) {
        for (int[] next : graph.get(node)) {
            if (!visit[next[0]] && Math.min(next[1], min) >= k) {
                visit[next[0]] = true;
                count++;
                dfs(Math.min(next[1], min), k, visit, next[0]);
            }
        }
    }
}
