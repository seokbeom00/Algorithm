import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, p, k;
    static List<List<int[]>> graph;
    static boolean flag;
    static boolean[] visit;
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        p = Integer.parseInt(line[1]);
        k = Integer.parseInt(line[2]);
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < p; i++) {
            line = br.readLine().split(" ");
            int n1 = Integer.parseInt(line[0]);
            int n2 = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);
            graph.get(n1).add(new int[]{n2, cost});
            graph.get(n2).add(new int[]{n1, cost});
        }

        int left = 0;
        int right = 1000000;
        while (left <= right) {
            int mid = (left + right) / 2;
            flag = false;
            visit = new boolean[n + 1];
            visit[1] = true;
            bfs(mid);
            if (flag) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left >= 1000000 ? -1 : left);
    }

    public static void bfs(int maxCost) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean[] visited = new boolean[n + 1];
        q.offer(new int[]{1, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int cnt = cur[1];
            if (node == n) {
                flag = cnt <= k;
                return;
            }
            if (visited[node]) continue;
            visited[node] = true;

            for (int[] next : graph.get(node)) {
                int nextNode = next[0];
                int nextCnt = cnt + (next[1] > maxCost ? 1 : 0);
                if (!visited[nextNode]) {
                    q.offer(new int[]{nextNode, nextCnt});
                }
            }
        }
    }
}
