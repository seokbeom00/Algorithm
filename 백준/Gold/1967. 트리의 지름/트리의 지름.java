import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<List<int[]>> tree;
    static boolean[] visit;
    static int farNode = 0, max = 0;
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);
            tree.get(a).add(new int[]{b, c});
            tree.get(b).add(new int[]{a, c});
        }
        visit = new boolean[n + 1];
        visit[1] = true;
        dfs(1, 0);
        visit = new boolean[n + 1];
        visit[farNode] = true;
        dfs(farNode, 0);
        System.out.println(max);
    }

    public static void dfs(int node, int sum) {
        if (sum > max) {
            farNode = node;
            max = sum;
        }
        for (int[] next : tree.get(node)) {
            if (visit[next[0]]) {
                continue;
            }
            visit[next[0]] = true;
            dfs(next[0], sum + next[1]);
        }
    }
}