import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        find(n, k);
        System.out.println(ans);
    }

    public static void find(int s, int k) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s, 0});
        boolean[] visited = new boolean[200000];
        visited[s] = true;
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int x = arr[0];
            int time = arr[1];
            if (x == k) {
                ans = Math.min(ans, time);
                continue;
            }
            if (x * 2 < 120000 && !visited[x * 2]) {
                visited[x * 2] = true;
                q.offer(new int[]{x * 2, time});
            }
            if (x > 0 && !visited[x - 1]) {
                visited[x - 1] = true;
                q.offer(new int[]{x - 1, time + 1});
            }
            if (x < 120000 && !visited[x + 1]) {
                visited[x + 1] = true;
                q.offer(new int[]{x + 1, time + 1});
            }
        }
    }
}