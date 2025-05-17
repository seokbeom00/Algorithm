import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] color; // 0: 흰색, 1: 빨간색, 2: 파란색
    static ArrayList<Integer>[][] map; // 각 칸에 쌓여 있는 말들의 번호
    static int[][] knights; // [i] = {x, y, d}
    static int[][] dir = { {0,1}, {0,-1}, {-1,0}, {1,0} }; // 우좌상하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);

        color = new int[N][N];
        map = new ArrayList[N][N];
        knights = new int[K][3];

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                color[i][j] = Integer.parseInt(line[j]);
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < K; i++) {
            line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]) - 1;
            int y = Integer.parseInt(line[1]) - 1;
            int d = Integer.parseInt(line[2]) - 1;
            knights[i] = new int[] {x, y, d};
            map[x][y].add(i);
        }

        int turn = 1;
        while (turn <= 1000) {
            for (int i = 0; i < K; i++) {
                if (move(i)) {
                    System.out.println(turn);
                    return;
                }
            }
            turn++;
        }

        System.out.println(-1);
    }

    static boolean move(int idx) {
        int x = knights[idx][0];
        int y = knights[idx][1];
        int d = knights[idx][2];

        ArrayList<Integer> curStack = map[x][y];
        int pos = curStack.indexOf(idx);
        List<Integer> moving = new ArrayList<>(curStack.subList(pos, curStack.size()));
        curStack.subList(pos, curStack.size()).clear();

        int nx = x + dir[d][0];
        int ny = y + dir[d][1];

        if (!inRange(nx, ny) || color[nx][ny] == 2) {
            // 방향 바꾸기
            d = reverseDir(d);
            knights[idx][2] = d;
            nx = x + dir[d][0];
            ny = y + dir[d][1];

            if (!inRange(nx, ny) || color[nx][ny] == 2) {
                map[x][y].addAll(moving);
                return false;
            }
        }

        if (color[nx][ny] == 1) Collections.reverse(moving); // 빨간색

        for (int m : moving) {
            knights[m][0] = nx;
            knights[m][1] = ny;
            map[nx][ny].add(m);
        }

        return map[nx][ny].size() >= 4;
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static int reverseDir(int d) {
        if (d == 0) return 1;
        if (d == 1) return 0;
        if (d == 2) return 3;
        return 2;
    }
}