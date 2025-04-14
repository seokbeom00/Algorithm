import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        dp = new int[n][m];
        dp[0][0] = map[0][0];
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + map[0][j];
        }

        for (int i = 1; i < n; i++) {
            int[] left = new int[m];
            int[] right = new int[m];

            // 왼쪽 -> 오른쪽
            left[0] = dp[i - 1][0] + map[i][0];
            for (int j = 1; j < m; j++) {
                left[j] = Math.max(left[j - 1], dp[i - 1][j]) + map[i][j];
            }

            // 오른쪽 -> 왼쪽
            right[m - 1] = dp[i - 1][m - 1] + map[i][m - 1];
            for (int j = m - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1], dp[i - 1][j]) + map[i][j];
            }

            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }

        System.out.println(dp[n - 1][m - 1]);
    }
}