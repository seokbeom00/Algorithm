import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0, 1});
        int[][] di = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][][] visit = new boolean[N][M][2];
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] info = q.poll();
            int x = info[0], y = info[1], isBreak = info[2], cnt = info[3];

            if (x == N - 1 && y == M - 1) {
                System.out.println(cnt);
                return;
            }

            for (int[] d : di) {
                int dx = x + d[0], dy = y + d[1];
                if (dx < 0 || dx >= N || dy < 0 || dy >= M) continue;

                if (map[dx][dy] == 0 && !visit[dx][dy][isBreak]) {
                    visit[dx][dy][isBreak] = true;
                    q.offer(new int[]{dx, dy, isBreak, cnt + 1});
                }

                if (map[dx][dy] == 1 && isBreak == 0 && !visit[dx][dy][1]) {
                    visit[dx][dy][1] = true;
                    q.offer(new int[]{dx, dy, 1, cnt + 1});
                }
            }
        }
        System.out.println(-1);
    }
}
