import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] board;
    static boolean[][] visit;
    static int[][] di = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        int max_height = 0;
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(line[j]);
                max_height = Math.max(max_height, board[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < max_height; i++) {
            ans = Math.max(ans, implement(i));
        }
        System.out.println(ans);
    }

    public static int implement(int height) {
        visit = new boolean[n][n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && board[i][j] > height) {
                    visit[i][j] = true;
                    bfs(i, j, height);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void bfs(int sx, int sy, int height) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int x = arr[0], y = arr[1];
            for (int[] d : di) {
                int dx = x + d[0], dy = y + d[1];
                if (0 <= dx && dx < n && 0 <= dy && dy < n && !visit[dx][dy] && board[dx][dy] > height) {
                    visit[dx][dy] = true;
                    q.offer(new int[]{dx, dy});
                }
            }
        }
    }
}
