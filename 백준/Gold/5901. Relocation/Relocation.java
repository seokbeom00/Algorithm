import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, k;
    static List<Integer> towns;
    static List<List<int[]>> graph;
    static List<List<Integer>> result;
    static boolean[] visit;
    static Map<Integer, int[]> townMin;
    static int answer;
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        k = Integer.parseInt(line[2]);
        towns = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            towns.add(Integer.parseInt(br.readLine()));
        }
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }
        result = new ArrayList<>();
        visit = new boolean[k];
        // 1.시장 순서 전부 구하기
        permute(new ArrayList<>());
        townMin = new HashMap<>();
        for (int t : towns) {
            townMin.put(t, new int[n + 1]);
        }
        // 2.시장 별로 다익스트라(각 노드 별 최소 이동거리 구함)
        for (int i = 0; i < k; i++) {
            townDijkstra(towns.get(i));
        }
        // 3.모든 순서에 대해서 거리 계산해보기
        answer = Integer.MAX_VALUE;
        for (List<Integer> list : result) {
            check(list);
        }
        System.out.println(answer);
        br.close();
    }

    public static void check(List<Integer> list) {
        for (int i = 1; i <= n; i++) {
            if (towns.contains(i)) {
                continue;
            }
            int cost = 0;
            cost += townMin.get(list.get(0))[i];
            for (int idx = 1; idx < list.size(); idx++) {
                cost += townMin.get(list.get(idx - 1))[list.get(idx)];
            }
            cost += townMin.get(list.get(list.size() - 1))[i];
            answer = Math.min(answer, cost);
        }
    }

    public static void townDijkstra(int town) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[1], p2[1]));
        pq.offer(new int[]{town, 0});
        int[] min = new int[n + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[town] = 0;
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int node = arr[0];
            int cost = arr[1];
            if (min[node] < cost) {
                continue;
            }
            for (int[] next : graph.get(node)) {
                int newCost = cost + next[1];
                if (min[next[0]] > newCost) {
                    min[next[0]] = newCost;
                    pq.offer(new int[]{next[0], newCost});
                }
            }
        }
        for (int i = 0; i < n + 1; i++) {
            townMin.get(town)[i] = min[i];
        }
    }

    public static void permute(List<Integer> current) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < towns.size(); i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            current.add(towns.get(i));
            permute(current);
            current.remove(current.size() - 1);
            visit[i] = false;
        }
    }
}
