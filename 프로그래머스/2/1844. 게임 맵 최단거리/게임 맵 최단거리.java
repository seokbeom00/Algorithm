import java.util.*;
class Solution {
    static int n, m;
    static int[][] di = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        int answer = -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1});
        boolean[][] visit = new boolean[n][m];
        visit[0][0] = true;
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int x = arr[0], y = arr[1], len = arr[2];
            if(x == n-1 && y == m-1){
                answer = len;
                break;
            }
            for(int[] d : di){
                int dx = x + d[0], dy = y + d[1];
                if(dx < 0 || dx >= n || dy < 0 || dy >=m || maps[dx][dy] == 0 || visit[dx][dy]){
                    continue;
                }
                visit[dx][dy] = true;
                q.offer(new int[]{dx, dy, len+1});
            }
        }
        // System.out.println(n + " " + m);
        return answer;
    }
}