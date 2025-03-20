import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static  int[][] di = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int ans = 1;
    static int r, c;
    static boolean[] visited = new boolean[26];
    static char[][] board;
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);
        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                board[i][j] = arr[j];
            }
        }
        visited[board[0][0] - 'A'] = true;
        backtracking(0, 0, 1);
        System.out.println(ans);
    }

    public static void backtracking(int x, int y, int len) {
        ans = Math.max(ans, len);
        for (int[] d : di) {
            int dx = x + d[0], dy = y + d[1];
            if (0 <= dx && dx < r && 0 <= dy && dy < c && !visited[board[dx][dy] - 'A']) {
                visited[board[dx][dy] - 'A'] = true;
                backtracking(dx, dy, len + 1);
                visited[board[dx][dy] - 'A'] = false;
            }
        }
    }
}