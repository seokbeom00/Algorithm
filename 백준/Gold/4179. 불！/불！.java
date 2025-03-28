import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] fire, person;
    static Queue<int[]> fireQueue = new LinkedList<>();
    static Queue<int[]> personQueue = new LinkedList<>();
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        R = Integer.parseInt(rc[0]);
        C = Integer.parseInt(rc[1]);
        map = new char[R][C];
        fire = new int[R][C];
        person = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(fire[i], -1);
            Arrays.fill(person[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'F') {
                    fire[i][j] = 0;
                    fireQueue.offer(new int[]{i, j});
                }
                if (map[i][j] == 'J') {
                    person[i][j] = 0;
                    personQueue.offer(new int[]{i, j});
                }
            }
        }
        // 불 확산시키기
        while (!fireQueue.isEmpty()) {
            int[] now = fireQueue.poll();
            for (int[] d : dir) {
                int dx = now[0] + d[0], dy = now[1] + d[1];
                if (dx < 0 || dx >= R || dy < 0 || dy >= C || fire[dx][dy] != -1 || map[dx][dy] == '#') {
                    continue;
                }
                fire[dx][dy] = fire[now[0]][now[1]] + 1;
                fireQueue.offer(new int[]{dx, dy});
            }
        }

        // 사람 이동시키기
        while (!personQueue.isEmpty()) {
            int[] now = personQueue.poll();
            if (now[0] == 0 || now[1] == 0 || now[0] == R - 1 || now[1] == C - 1) {
                System.out.println(person[now[0]][now[1]] + 1);
                return;
            }
            for (int[] d : dir) {
                int dx = now[0] + d[0], dy = now[1] + d[1];
                if (dx < 0 || dx >= R || dy < 0 || dy >= C || person[dx][dy] != -1 || map[dx][dy] == '#') {
                    continue;
                }
                if (fire[dx][dy] != -1 && fire[dx][dy] <= person[now[0]][now[1]] + 1) {
                    continue;
                }
                person[dx][dy] = person[now[0]][now[1]] + 1;
                personQueue.offer(new int[]{dx, dy});
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}