import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] board;
    static int n, l, r;
    static int[][] di = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean flag = true;
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        l = Integer.parseInt(line[1]);
        r = Integer.parseInt(line[2]);
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }
        int ans = 0;
        while (true) {
            flag = true;
            int[][] mergeBoard = new int[n][n];
            boolean[][] visited = new boolean[n][n];
            List<int[]> sum = new ArrayList<>();
            for (int i = 0; i < n * n + 1; i++) {
                sum.add(new int[]{0, 0});
            }
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        mergeBoard[i][j] = cnt;
                        sum.get(cnt)[0] += board[i][j];
                        sum.get(cnt)[1] += 1;
                        merge(i, j, cnt, mergeBoard, visited, sum);
                        cnt += 1;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (sum.get(mergeBoard[i][j])[0] > 0) {
                        board[i][j] = sum.get(mergeBoard[i][j])[0] / sum.get(mergeBoard[i][j])[1];
                    }
                }
            }
            if (flag) {
                break;
            }
            ans += 1;
//            System.out.println("========");
//            for (int[] b : mergeBoard) {
//                System.out.println(Arrays.toString(b));
//            }
//            for (int[] b : board) {
//                System.out.println(Arrays.toString(b));
//            }
        }
        System.out.println(ans);
    }

    public static void merge(int x, int y, int cnt, int[][] mergeBoard, boolean[][] visited, List<int[]> sum) {
        for (int[] d : di) {
            int dx = x + d[0], dy = y + d[1];
            if (0 <= dx && dx < n && 0 <= dy && dy < n && !visited[dx][dy]) {
                int diff = Math.abs(board[x][y] - board[dx][dy]);
                if (l <= diff && diff <= r) {
                    flag = false;
                    visited[dx][dy] = true;
                    mergeBoard[dx][dy] = cnt;
                    sum.get(cnt)[0] += board[dx][dy];
                    sum.get(cnt)[1] += 1;
                    merge(dx, dy, cnt, mergeBoard, visited, sum);
                }
            }
        }
    }
}
