import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, cnt, total, ans;
    static List<List<Integer>> graph;
    static int[] color;
    static boolean[] visit;
    static boolean flag;
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        graph = new ArrayList<>();
        visit = new boolean[n + 1];
        color = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                total = 0;
                cnt = 0;
                dfs(-1, i);
                ans += Math.max(total - cnt, cnt);
            }
        }
        if (flag) {
            System.out.println(-1);
            return;
        }
        System.out.println(ans);
    }

    public static void dfs(int num, int node) {
        color[node] = num;
        total++;
        if (num > 0) {
            cnt++;
        }
        for (int next : graph.get(node)) {
            if (color[next] == color[node]) {
                flag = true;
            }
            if (!visit[next]) {
                visit[next] = true;
                dfs(-num, next);
            }
        }
    }
}
