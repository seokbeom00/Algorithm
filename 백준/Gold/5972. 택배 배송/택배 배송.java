import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static class Node{
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            int c = Integer.parseInt(parts[2]);
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        System.out.println(dijkstra(n, graph));
    }
    public static int dijkstra(int n, List<List<Node>> graph) {
        int[] dist = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.cost, n2.cost));
        pq.offer(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (dist[node.idx] < node.cost) {
                continue;
            }
            for (int i = 0; i < graph.get(node.idx).size(); i++) {
                Node next = graph.get(node.idx).get(i);
                if (dist[next.idx] > node.cost + next.cost) {
                    dist[next.idx] = node.cost + next.cost;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }
        return dist[n];
    }
}