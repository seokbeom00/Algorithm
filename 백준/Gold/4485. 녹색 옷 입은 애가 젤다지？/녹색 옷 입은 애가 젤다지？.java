import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static int[][] di = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int cnt = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }
            int minCost = dijkstra(n);
            sb.append("Problem ").append(cnt++).append(": ").append(minCost).append("\n");
        }
        System.out.println(sb);
    }

    public static int dijkstra(int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        pq.offer(new int[]{0, 0, map[0][0]});
        dist[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int x = arr[0], y = arr[1], cost = arr[2];

            if (x == n - 1 && y == n - 1) {
                return cost;
            }

            for (int[] d : di) {
                int dx = x + d[0], dy = y + d[1];

                if (0 <= dx && dx < n && 0 <= dy && dy < n) {
                    int newCost = cost + map[dx][dy];

                    if (newCost < dist[dx][dy]) {
                        dist[dx][dy] = newCost;
                        pq.offer(new int[]{dx, dy, newCost});
                    }
                }
            }
        }
        return -1; // 도달 불가능한 경우
    }
}