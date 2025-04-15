import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int num;
        long time;

        Node(int num, long time) {
            this.num = num;
            this.time = time;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            graph.get(a).add(new int[]{b, i});
            graph.get(b).add(new int[]{a, i});
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Long.compare(n1.time, n2.time));
        pq.offer(new Node(1, 0));
        long[] min_time = new long[n + 1];
        min_time[1] = 0;
        Arrays.fill(min_time, Long.MAX_VALUE);
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int current = node.num;
            long time = node.time;
            if (time > min_time[current]) {
                continue;
            }
            for (int[] next : graph.get(current)) {
                long signal = next[1];
                long wait;
                if (time % m <= signal) {
                    wait = signal - (time % m);
                } else {
                    wait = m - (time % m) + signal;
                }
                long next_time = time + wait + 1; // 대기 + 1분 건너기
                if (min_time[next[0]] > next_time) {
                    min_time[next[0]] = next_time;
                    pq.offer(new Node(next[0], next_time));
                }
//                System.out.println(time + "분에서 " + current + " -> " + next[0]);
//                System.out.println(next_time);
            }
        }
        System.out.println(min_time[n]);
    }
}
