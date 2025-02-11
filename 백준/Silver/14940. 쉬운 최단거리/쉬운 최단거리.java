import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[][] board = new int[n][m];
        int sx = 0;
        int sy = 0;
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(parts[j]);
                if (num == 2) {
                    sx = i;
                    sy = j;
                }
                if (num == 1) {
                    board[i][j] = -1;
                }else{
                    board[i][j] = num;
                }
            }
        }
        board[sx][sy] = 0;
        int[][] di = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        check(board, sx, sy, di, n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void check(int[][] board, int sx, int sy, int[][] di, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});
        visited[sx][sy] = true;
        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];
            for (int[] d : di) {
                int dx = x + d[0];
                int dy = y + d[1];
                if (0 <= dx && dx < n && 0 <= dy && dy < m && board[dx][dy] != 0 && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    board[dx][dy] = board[x][y] + 1;
                    q.add(new int[]{dx, dy});
                }
            }
        }
    }
}