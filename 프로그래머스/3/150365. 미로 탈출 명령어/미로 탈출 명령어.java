import java.util.*;

class Solution {
    static int[][] di = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}}; // "d", "l", "r", "u"
    static String[] command = {"d", "l", "r", "u"};
    static int N, M, K, R, C;
    static String answer = "impossible";

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        K = k;
        R = r;
        C = c;

        // 남은 거리 확인하여 도달 불가능한 경우 바로 반환
        if ((Math.abs(x - R) + Math.abs(y - C)) % 2 != K % 2 || Math.abs(x - R) + Math.abs(y - C) > K) {
            return "impossible";
        }

        dfs("", x, y);
        return answer;
    }

    public static void dfs(String path, int x, int y) {
        if (!answer.equals("impossible")) return; // 정답을 찾으면 더 이상 탐색하지 않음

        // 남은 거리가 남은 이동 횟수보다 크면 가지치기
        if (Math.abs(x - R) + Math.abs(y - C) > K - path.length()) return;

        if (path.length() == K) {
            if (x == R && y == C) {
                answer = path;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int dx = x + di[i][0];
            int dy = y + di[i][1];

            if (1 <= dx && dx <= N && 1 <= dy && dy <= M) {
                dfs(path + command[i], dx, dy);
            }
        }
    }
}