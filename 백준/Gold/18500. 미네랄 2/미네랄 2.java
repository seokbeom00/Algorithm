import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R, C;
    static char[][] board;
    static int[][] di = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(" ");
        R = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int N = Integer.parseInt(br.readLine());
        line = br.readLine().split(" ");
        int[] heights = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < N; i++) {
            int height = heights[i];
            int row = R - height;
            boolean broken = false;

            if (i % 2 == 0) { // left to right
                for (int j = 0; j < C; j++) {
                    if (board[row][j] == 'x') {
                        board[row][j] = '.';
                        check();
                        broken = true;
                        break;
                    }
                }
            } else { // right to left
                for (int j = C - 1; j >= 0; j--) {
                    if (board[row][j] == 'x') {
                        board[row][j] = '.';
                        check();
                        broken = true;
                        break;
                    }
                }
            }

            // nothing broken → skip gravity
            if (!broken) continue;
        }

        // print result
        for (char[] row : board) {
            System.out.println(new String(row));
        }
    }

    public static void check() {
        boolean[][] visit = new boolean[R][C];

        // 바닥에 붙어 있는 미네랄은 모두 방문 표시
        for (int j = 0; j < C; j++) {
            if (board[R - 1][j] == 'x' && !visit[R - 1][j]) {
                bfs(R - 1, j, visit);
            }
        }

        // 떠있는 클러스터 수집
        List<int[]> cluster = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'x' && !visit[i][j]) {
                    cluster.add(new int[]{i, j});
                }
            }
        }

        if (!cluster.isEmpty()) {
            fall(cluster);
        }
    }

    public static void bfs(int sx, int sy, boolean[][] visit) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        visit[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int[] d : di) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (visit[nx][ny] || board[nx][ny] != 'x') continue;

                visit[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }

    public static void fall(List<int[]> cluster) {
        // map[x][y] → 클러스터 위치 확인용
        boolean[][] isCluster = new boolean[R][C];
        for (int[] pos : cluster) {
            isCluster[pos[0]][pos[1]] = true;
            board[pos[0]][pos[1]] = '.';
        }

        int dist = 0;
        outer:
        while (true) {
            for (int[] pos : cluster) {
                int nx = pos[0] + dist + 1;
                int ny = pos[1];

                if (nx >= R) break outer;
                if (board[nx][ny] == 'x' && !isCluster[nx - dist][ny]) break outer;
            }
            dist++;
        }

        for (int[] pos : cluster) {
            int nx = pos[0] + dist;
            int ny = pos[1];
            board[nx][ny] = 'x';
        }
    }
}