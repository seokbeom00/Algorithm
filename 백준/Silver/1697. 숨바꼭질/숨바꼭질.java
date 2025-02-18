import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        System.out.println(find(n, k));
    }

    public static int find(int s, int k) {
        boolean[] visited = new boolean[200000];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s, 0});
        visited[s] = true;
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int x = arr[0];
            int time = arr[1];
            if (x == k) {
                return time;
            }
            if ( x + 1 <= 100001 && !visited[x + 1]) {
                visited[x + 1] = true;
                q.offer(new int[]{x + 1, time + 1});
            }
            if (x - 1 >= 0 && !visited[x - 1]) {
                visited[x - 1] = true;
                q.offer(new int[]{x - 1, time + 1});
            }
            if (x * 2 <= 100001 && !visited[x * 2]) {
                visited[x * 2] = true;
                q.offer(new int[]{x * 2, time + 1});
            }
        }
        return -1;
    }
}