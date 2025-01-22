import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]); // 세로 크기
        int m = Integer.parseInt(line[1]); // 가로 크기
        int[][] board = new int[n][m];

        // 행렬 입력
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(parts[j]);
            }
        }

        // DP 배열 (3차원)
        int[][][] dp = new int[n][m][3];

        // 초기값 설정 (첫 행 그대로 사용)
        for (int j = 0; j < m; j++) {
            Arrays.fill(dp[0][j], board[0][j]);
        }

        // DP 수행
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 왼쪽 아래 방향 (j-1에서 오는데, 같은 방향이었던 경우 제외)
                if (j > 0) {
                    dp[i][j][0] = board[i][j] + Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]);
                } else {
                    dp[i][j][0] = Integer.MAX_VALUE; // 경계 처리
                }

                // 아래 방향 (j에서 오는 경우, 같은 방향이었던 경우 제외)
                dp[i][j][1] = board[i][j] + Math.min(dp[i - 1][j][0], dp[i - 1][j][2]);

                // 오른쪽 아래 방향 (j+1에서 오는 경우, 같은 방향이었던 경우 제외)
                if (j < m - 1) {
                    dp[i][j][2] = board[i][j] + Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]);
                } else {
                    dp[i][j][2] = Integer.MAX_VALUE; // 경계 처리
                }
            }
        }

        // 마지막 행에서 최소값 찾기
        int minFuel = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            for (int d = 0; d < 3; d++) {
                minFuel = Math.min(minFuel, dp[n - 1][j][d]);
            }
        }

        System.out.println(minFuel);
    }
}