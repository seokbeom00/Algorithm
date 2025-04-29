import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[][] di = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // 우 좌 상 하
    static int[][] board;
    static int[][] knight;
    static boolean flag;
    static List<Integer>[][] map_knight;
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }
        knight = new int[K][3];
        map_knight = new ArrayList[N][N];
        for (int i = 0; i < K; i++) {
            line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int d = Integer.parseInt(line[2]);
            knight[i] = new int[]{x - 1, y - 1, d};
            map_knight[x - 1][y - 1] = new ArrayList<>();
            map_knight[x - 1][y - 1].add(i);
        }
        int turn = 0;
        while (true) {
            turn++;
            for (int i = 0; i < K; i++) {
                int[] info = knight[i];
                int x = info[0], y = info[1], d = info[2];
                if (map_knight[x][y].get(0) != i) { //맨 밑에 없으면 건너뜀
                    continue;
                }
                int dx = x + di[d][0], dy = y + di[d][1];
                if (dx < 0 || dx >= N || dy < 0 || dy >= N) { // 파란색
                    move(i, 2, x, y, dx, dy, d);
                } else if (board[dx][dy] == 0) { // 하얀색
                    move(i, 0, x, y, dx, dy, d);
                } else if (board[dx][dy] == 1) { // 빨간색
                    move(i, 1, x, y, dx, dy, d);
                } else if (board[dx][dy] == 2) { // 파란색
                    move(i, 2, x, y, dx, dy, d);
                }
            }
            if (flag) {
                System.out.println(turn);
                return;
            }
            if (turn > 1000) {
                System.out.println(-1);
                return;
            }
        }
    }

    public static int reverse_direction(int d) {
        if (d == 1) {
            return 2;
        } else if (d == 2) {
            return 1;
        } else if (d == 3) {
            return 4;
        }else{
            return 3;
        }
    }

    public static void move(int number, int color, int x, int y, int dx, int dy, int d) {
        if (color == 2) {
            int nd = reverse_direction(d);
            dx = x + di[nd][0];
            dy = y + di[nd][1];
            knight[number][2] = nd;
            if (0 <= dx && dx < N && 0 <= dy && dy < N && board[dx][dy] != 2) {
                if (map_knight[dx][dy] == null) {
                    map_knight[dx][dy] = new ArrayList<>();
                }
                List<Integer> list = map_knight[x][y];
                if (board[dx][dy] == 1) {
                    Collections.reverse(list);
                }
                map_knight[dx][dy].addAll(list);
                map_knight[x][y].clear();
                if (map_knight[dx][dy].size() >= 4) {
                    flag = true;
                }
                for (int num : map_knight[dx][dy]) {
                    knight[num][0] = dx;
                    knight[num][1] = dy;
                }
            }
        } else { //하얀색이나 빨간색
            List<Integer> list = map_knight[x][y];
            if (color == 1) {
                Collections.reverse(list);
            }
            if (map_knight[dx][dy] == null) {
                map_knight[dx][dy] = new ArrayList<>();
            }
            map_knight[dx][dy].addAll(map_knight[x][y]);
            map_knight[x][y].clear();
            for (int num : map_knight[dx][dy]) {
                knight[num][0] = dx;
                knight[num][1] = dy;
            }
            if (map_knight[dx][dy].size() >= 4) {
                flag = true;
            }
        }
    }
}
