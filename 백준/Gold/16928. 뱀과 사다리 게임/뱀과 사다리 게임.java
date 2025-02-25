import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n + m; i++) {
            String[] parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            map.put(a, b);
        }
        bfs(map);
        System.out.println(ans);
    }

    public static void bfs(Map<Integer, Integer> map) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});
        boolean[] visited = new boolean[101];
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int num = arr[0];
            int cnt = arr[1];
            visited[num] = true;
            if (num == 100) {
                ans = cnt;
                break;
            }
            num = map.getOrDefault(num, num);
            visited[num] = true;
            if (num + 6 <= 100 && !visited[num + 6]) {
                q.add(new int[]{num + 6, cnt + 1});
            }
            if (num + 5 <= 100 && !visited[num + 5]) {
                q.add(new int[]{num + 5, cnt + 1});
            }
            if (num + 4 <= 100 && !visited[num + 4]) {
                q.add(new int[]{num + 4, cnt + 1});
            }
            if (num + 3 <= 100 && !visited[num + 3]) {
                q.add(new int[]{num + 3, cnt + 1});
            }
            if (num + 2 <= 100 && !visited[num + 2]) {
                q.add(new int[]{num + 2, cnt + 1});
            }
            if (num + 1 <= 100 && !visited[num + 1]) {
                q.add(new int[]{num + 1, cnt + 1});
            }
        }
    }
}