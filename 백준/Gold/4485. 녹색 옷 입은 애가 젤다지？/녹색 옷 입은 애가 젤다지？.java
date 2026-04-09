import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static int[][] di = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        while (true) {
            cnt++;
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            if (n == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(line[j]);
                }
            }
            int ans = dijkstra();
            System.out.println("Problem " + cnt + ": " + ans);
        }
    }
    static int dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int[] init = {0, 0, board[0][0]};
        pq.offer(init);
        int[][] dist = new int[n][n];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int x = arr[0], y = arr[1], cost = arr[2];
            for (int[] d : di) {
                int dx = x + d[0], dy = y + d[1];
                if (dx < 0 || dy < 0 || dx >= n || dy >= n || dist[dx][dy] <= cost + board[dx][dy]) {
                    continue;
                }
                dist[dx][dy] = cost + board[dx][dy];
                pq.offer(new int[]{dx, dy, cost + board[dx][dy]});
            }
        }
        return dist[n - 1][n - 1];
    }
}
