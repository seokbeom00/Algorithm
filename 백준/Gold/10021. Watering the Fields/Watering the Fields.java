import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, C;
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);
        List<int[]> pos = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            pos.add(new int[]{x, y});
        }
        boolean[] visit = new boolean[N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[1], p2[1]));
        pq.add(new int[]{0, 0});
        int answer = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int node = arr[0];
            int dis = arr[1];
            if (visit[node]) {
                continue;
            }
            visit[node] = true;
            answer += dis;
            cnt++;
            for (int i = 0; i < N; i++) {
                if (visit[i]) {
                    continue;
                }
                int cost = (int) (Math.pow(pos.get(node)[0] - pos.get(i)[0], 2) + Math.pow(
                        pos.get(node)[1] - pos.get(i)[1], 2));
                if (cost >= C) {
                    pq.offer(new int[]{i, cost});
                }
            }
        }
        if (cnt == N) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}
