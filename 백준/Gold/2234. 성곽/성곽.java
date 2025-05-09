import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[][] board;
    static int[][] rooms;
    static boolean[][] visit;
    static int size;
    static int[][] di = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        m = Integer.parseInt(line[0]);
        n = Integer.parseInt(line[1]);
        board = new int[n][m];
        rooms = new int[n][m];
        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }
        int ans1 = 0;
        int ans2 = 0;
        visit = new boolean[n][m];
        int room_num = 0;
        List<Integer> roomSize = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) {
                    visit[i][j] = true;
                    rooms[i][j] = room_num;
                    int size = bfs(i, j, room_num);
                    ans2 = Math.max(ans2, size);
                    ans1++;
                    room_num++;
                    roomSize.add(size);
                }
            }
        }
        int ans3 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int[] d : di) {
                    int x = i + d[0], y = j + d[1];
                    if (x >= 0 && x < n && y >= 0 && y < m && rooms[i][j] != rooms[x][y]) {
                        ans3 = Math.max(ans3, roomSize.get(rooms[i][j]) + roomSize.get(rooms[x][y]));
                    }
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(rooms[i]));
//        }
        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
    }

    public static int bfs(int sx, int sy, int room_num) {
        int size = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int x = arr[0], y = arr[1];
            boolean seo = (board[x][y] & 1) > 0;
            boolean book = (board[x][y] & 2) > 0;
            boolean dong = (board[x][y] & 4) > 0;
            boolean nam = (board[x][y] & 8) > 0;
            if (!seo) {
                int dx = x;
                int dy = y - 1;
                if (dx >= 0 && dx < n && dy >= 0 && dy < m && !visit[dx][dy]) {
                    visit[dx][dy] = true;
                    rooms[dx][dy] = room_num;
                    q.offer(new int[]{dx, dy});
                    size++;
                }
            }
            if (!book) {
                int dx = x - 1;
                int dy = y;
                if (dx >= 0 && dx < n && dy >= 0 && dy < m && !visit[dx][dy]) {
                    visit[dx][dy] = true;
                    rooms[dx][dy] = room_num;
                    q.offer(new int[]{dx, dy});
                    size++;
                }
            }
            if (!dong) {
                int dx = x;
                int dy = y + 1;
                if (dx >= 0 && dx < n && dy >= 0 && dy < m && !visit[dx][dy]) {
                    visit[dx][dy] = true;
                    rooms[dx][dy] = room_num;
                    q.offer(new int[]{dx, dy});
                    size++;
                }
            }
            if (!nam) {
                int dx = x + 1;
                int dy = y;
                if (dx >= 0 && dx < n && dy >= 0 && dy < m && !visit[dx][dy]) {
                    visit[dx][dy] = true;
                    rooms[dx][dy] = room_num;
                    q.offer(new int[]{dx, dy});
                    size++;
                }
            }
        }
        return size;
    }
}
