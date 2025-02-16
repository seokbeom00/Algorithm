import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int d = Integer.parseInt(line[1]);
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            int s = Integer.parseInt(parts[0]);
            int e = Integer.parseInt(parts[1]);
            int len = Integer.parseInt(parts[2]);
            if (e <= d && e - s - len >= 0) {
                arr.add(new int[]{s, e, len});
            }
        }
        int[] dist = new int[d + 1];
        for (int i = 1; i < d + 1; i++) {
            dist[i] = i;
        }
        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.offer(new Road(0, 0, 0));
        dist[0] = 0;
        while (!pq.isEmpty()) {
            Road r = pq.poll();
            for (int[] a : arr) {
                if (r.e <= a[0]) {
                    if (dist[a[1]] > dist[r.e] + a[0] - r.e + a[2]) {
                        dist[a[1]] = dist[r.e] + a[0] - r.e + a[2];
                        pq.offer(new Road(a[0], a[1], dist[a[1]]));
                    }
                }
            }
            dist[d] = Math.min(dist[d], dist[r.e] + d - r.e);
        }
        System.out.println(dist[d]);
    }
}

class Road implements Comparable<Road> {
    int s;
    int e;
    int len;

    public Road(int s, int e, int len) {
        this.s = s;
        this.e = e;
        this.len = len;
    }

    @Override
    public int compareTo(Road r) {
        return this.len - r.len;
    }
}