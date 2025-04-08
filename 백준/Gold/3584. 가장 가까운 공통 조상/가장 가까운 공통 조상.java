import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] parent = new int[n + 1];
            for (int i = 0; i < n - 1; i++) {
                String[] line = br.readLine().split(" ");
                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);
                parent[b] = a;
            }
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            System.out.println(dfs(parent, a, b));
        }
    }

    public static int dfs(int[] parent, int a, int b) {
        int answer = 0;
        boolean[] visit = new boolean[parent.length];
        visit[a] = true;
        while (parent[a] != 0) {
            visit[parent[a]] = true;
            a = parent[a];
        }
        while (true) {
            if (visit[b]) {
                answer = b;
                break;
            }
            b = parent[b];
        }
        return answer;
    }
}
