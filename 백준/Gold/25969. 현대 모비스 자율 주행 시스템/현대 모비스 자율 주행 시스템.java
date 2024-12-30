import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int answer = Integer.MAX_VALUE;
//    private static void bfs(int k, List<int[]> pattern, List<int[]> addPattern, int[][] map, int n, int m) {
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{0, 0, 0, 0, 0}); //열, 행, 이동거리, 패턴사용횟수, 중간거점거쳣는지
//        boolean[][][] visited = new boolean[n][m][k + 1];
//        visited[0][0][0] = true;
//        while (!queue.isEmpty()) {
//            int[] info = queue.poll();
//            int x = info[0];
//            int y = info[1];
//            int distance = info[2];
//            int patternCount = info[3];
//            int isPass = info[4];
//
//
//            if (x == n - 1 && y == m - 1) {
//                if (map[n - 1][m - 1] == 2) {
//                    isPass = 1;
//                }
//                if (isPass == 1 && distance < answer) {
//                    answer = distance;
//                }
//            }
//
//            for (int i = 0; i < 4; i++) {
//                int dx = x + pattern.get(i)[0];
//                int dy = y + pattern.get(i)[1];
//                if (0 <= dx && dx < n && 0 <= dy && dy < m && map[dx][dy] != 1 && !visited[dx][dy][patternCount]) {
//                    if (distance + 1 > answer) {
//                        continue;
//                    }
//                    visited[dx][dy][patternCount] = true;
//                    if (map[dx][dy] == 2) {
//                        queue.add(new int[]{dx, dy, distance + 1, patternCount, 1});
//                    }
//                    else{
//                        queue.add(new int[]{dx, dy, distance + 1, patternCount, isPass});
//                    }
//                }
//            }
//            if (patternCount < k) {
//                for (int j = 0; j < addPattern.size(); j++) {
//                    int dx = x + addPattern.get(j)[0];
//                    int dy = y + addPattern.get(j)[1];
//                    if (0 <= dx && dx < n && 0 <= dy && dy < m && map[dx][dy] != 1 && !visited[dx][dy][patternCount+1]) {
//                        if (distance + 1 > answer) {
//                            continue;
//                        }
//                        visited[dx][dy][patternCount + 1] = true;
//                        if (map[dx][dy] == 2) {
//                            queue.add(new int[]{dx, dy, distance + 1, patternCount + 1, 1});
//                        } else {
//                            queue.add(new int[]{dx, dy, distance + 1, patternCount + 1, isPass});
//                        }
//                    }
//                }
//            }
//        }
//        if (answer == Integer.MAX_VALUE) {
//            answer = -1;
//        }
//    }
    private static void bfs(int k, List<int[]> pattern, List<int[]> addPattern, int[][] map, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][][] visited = new boolean[n][m][k + 1][2]; // [x][y][patternCount][isPass]
        queue.offer(new int[]{0, 0, 0, 0, 0}); // 열, 행, 이동거리, 패턴사용횟수, 중간거점 여부
        visited[0][0][0][0] = true;
    
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int x = info[0], y = info[1], distance = info[2];
            int patternCount = info[3], isPass = info[4];
    
            // 목표 지점에 도달 && 중간 거점 조건 충족
            if (x == n - 1 && y == m - 1) {
                if (map[n - 1][m - 1] == 2) isPass = 1;
                if (isPass == 1) {
                    answer = Math.min(answer, distance);
                    continue;
                }
            }
    
            // 상하좌우 기본 패턴 탐색
            for (int i = 0; i < 4; i++) {
                int dx = x + pattern.get(i)[0];
                int dy = y + pattern.get(i)[1];
                if (0 <= dx && dx < n && 0 <= dy && dy < m && map[dx][dy] != 1) {
                    int nextIsPass = (map[dx][dy] == 2) ? 1 : isPass;
                    if (!visited[dx][dy][patternCount][nextIsPass]) {
                        visited[dx][dy][patternCount][nextIsPass] = true;
                        queue.add(new int[]{dx, dy, distance + 1, patternCount, nextIsPass});
                    }
                }
            }
    
            // 추가 패턴 탐색
            if (patternCount < k) {
                for (int[] addMove : addPattern) {
                    int dx = x + addMove[0];
                    int dy = y + addMove[1];
                    if (0 <= dx && dx < n && 0 <= dy && dy < m && map[dx][dy] != 1) {
                        int nextIsPass = (map[dx][dy] == 2) ? 1 : isPass;
                        if (!visited[dx][dy][patternCount + 1][nextIsPass]) {
                            visited[dx][dy][patternCount + 1][nextIsPass] = true;
                            queue.add(new int[]{dx, dy, distance + 1, patternCount + 1, nextIsPass});
                        }
                    }
                }
            }
        }
    
        if (answer == Integer.MAX_VALUE) answer = -1;
    }

    public static void main(String[] args) throws IOException{
        String[] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int k = Integer.parseInt(parts[2]); //추가 패턴을 k번만큼 사용 가능
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] parts2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(parts2[j]);
            }
        }
        List<int[]> pattern = new ArrayList<>();
        pattern.add(new int[]{1, 0});
        pattern.add(new int[]{-1, 0});
        pattern.add(new int[]{0, 1});
        pattern.add(new int[]{0, -1});

        List<int[]> addPattern = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String[] parts3 = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                if (parts3[j].equals("1")) {
                    addPattern.add(new int[]{i-2, j-2});
                }
            }
        }
        bfs(k, pattern, addPattern, map, n, m);
        System.out.println(answer);
    }
}
