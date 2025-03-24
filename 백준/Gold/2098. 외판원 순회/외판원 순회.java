import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] cost;
    static int[][] dp;
    static final int INF = Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(line[j]);
            }
        }

        dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(tsp(0, 1));
    }

    public static int tsp(int current, int visited) {
        if (visited == (1 << n) - 1) {
            // 모든 도시를 방문한 경우, 시작점으로 돌아가는 비용이 있어야 함
            return cost[current][0] == 0 ? INF : cost[current][0];
        }

        if (dp[current][visited] != -1) {
            return dp[current][visited];
        }

        int min = INF;

        for (int i = 0; i < n; i++) {
            // i번째 도시를 아직 방문하지 않았고, current → i로 갈 수 있는 경우
            if ((visited & (1 << i)) == 0 && cost[current][i] != 0) {
                int temp = tsp(i, visited | (1 << i));
                if (temp != INF) {
                    min = Math.min(min, temp + cost[current][i]);
                }
            }
        }

        dp[current][visited] = min;
        return min;
    }
}