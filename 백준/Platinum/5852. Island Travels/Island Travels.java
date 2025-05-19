import java.io.*;
import java.util.*;

public class Main {
    static int r, c, n;
    static char[][] board;
    static boolean[][] visit;
    static int[][] di = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static List<List<int[]>> islands; // 좌표 저장
    static int[][] dist; // 섬 간 거리 저장
    static int[][] dp;   // Bitmask DP
    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);
        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // 1. 섬 분리
        islands = new ArrayList<>();
        visit = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visit[i][j] && board[i][j] == 'X') {
                    List<int[]> island = new ArrayList<>();
                    bfsIsland(i, j, island);
                    islands.add(island);
                }
            }
        }

        n = islands.size();
        dist = new int[n][n];
        for (int[] d : dist) Arrays.fill(d, INF);

        // 2. 섬 간 거리 계산
        for (int i = 0; i < n; i++) {
            dijkstra(i);
        }

        // 3. Bitmask DP (TSP)
        dp = new int[1 << n][n];
        for (int[] d : dp) Arrays.fill(d, INF);

        // 시작 지점을 모든 섬으로 설정
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = 0;
        }

        for (int mask = 1; mask < (1 << n); mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) == 0) continue;
                for (int v = 0; v < n; v++) {
                    if ((mask & (1 << v)) != 0) continue; // 이미 방문한 섬
                    dp[mask | (1 << v)][v] = Math.min(
                            dp[mask | (1 << v)][v],
                            dp[mask][u] + dist[u][v]
                    );
                }
            }
        }

        int result = INF;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, dp[(1 << n) - 1][i]);
        }

        System.out.println(result);
    }

    // 섬 연결 탐색
    public static void bfsIsland(int x, int y, List<int[]> island) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        island.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int[] d : di) {
                int dx = now[0] + d[0], dy = now[1] + d[1];
                if (0 <= dx && dx < r && 0 <= dy && dy < c && !visit[dx][dy] && board[dx][dy] == 'X') {
                    visit[dx][dy] = true;
                    q.offer(new int[]{dx, dy});
                    island.add(new int[]{dx, dy});
                }
            }
        }
    }

    // 다익스트라로 i번 섬에서 다른 섬까지의 최소 거리 계산
    public static void dijkstra(int idx) {
        int[][] min = new int[r][c];
        for (int i = 0; i < r; i++) Arrays.fill(min[i], INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for (int[] pos : islands.get(idx)) {
            pq.offer(new int[]{pos[0], pos[1], 0});
            min[pos[0]][pos[1]] = 0;
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], cost = cur[2];
            if (min[x][y] < cost) continue;

            for (int[] d : di) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (board[nx][ny] == '.') continue;

                int nextCost = (board[nx][ny] == 'S') ? cost + 1 : cost;
                if (min[nx][ny] > nextCost) {
                    min[nx][ny] = nextCost;
                    pq.offer(new int[]{nx, ny, nextCost});
                }
            }
        }

        // 다른 섬까지 거리 저장
        for (int j = 0; j < n; j++) {
            if (j == idx) continue;
            int best = INF;
            for (int[] pos : islands.get(j)) {
                best = Math.min(best, min[pos[0]][pos[1]]);
            }
            dist[idx][j] = best;
        }
    }
}