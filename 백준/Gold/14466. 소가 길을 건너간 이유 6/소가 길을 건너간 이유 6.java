import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }


        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k, r;
    static Set<Point>[][] load;
    static List<int[]> cows;
    static boolean[][] visit;
    static int[][] di = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int answer;
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);
        r = Integer.parseInt(line[2]);
        load = new HashSet[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                load[i][j] = new HashSet<>();
            }
        }
        cows = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);
            int d = Integer.parseInt(line[3]);
            load[a][b].add(new Point(c, d));
            load[c][d].add(new Point(a, b));
        }
        for (int i = 0; i < k; i++) {
            line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            cows.add(new int[]{x, y});
        }
        answer = 0;
        for (int i = 0; i < cows.size() - 1; i++) {
            bfs(i);
        }
        System.out.println(answer);
    }

    public static void bfs(int idx) {
        int sx = cows.get(idx)[0];
        int sy = cows.get(idx)[1];
        visit = new boolean[n + 1][n + 1];
        visit[sx][sy] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int x = arr[0], y = arr[1];
            for (int[] d : di) {
                int dx = x + d[0], dy = y + d[1];
                if (1 <= dx && dx <= n && 1 <= dy && dy <= n && !visit[dx][dy]) {
                    if (!load[x][y].contains(new Point(dx, dy))) {
                        visit[dx][dy] = true;
                        q.offer(new int[]{dx, dy});
                    }
                }
            }
        }
        for (int i = idx + 1; i < cows.size(); i++) {
            int x = cows.get(i)[0];
            int y  = cows.get(i)[1];
            if (!visit[x][y]) {
                answer++;
            }
        }
    }
}
