import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int c, v;
    static List<List<int[]>> graph;
    static int[][] dist;  // dist[도시][짝수/홀수]로 비용을 저장
    static PriorityQueue<int[]> pq;  // {비용, 도시, 톨게이트 개수(짝수/홀수)}
    
    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(" ");
        c = Integer.parseInt(line[0]);
        v = Integer.parseInt(line[1]);
        
        graph = new ArrayList<>();
        dist = new int[c + 1][2];  // dist[도시][0:짝수, 1:홀수]로 두 가지 상태 저장
        pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));  // 최소 힙

        // 그래프 초기화
        for (int i = 0; i < c + 1; i++) {
            graph.add(new ArrayList<>());
            dist[i][0] = dist[i][1] = Integer.MAX_VALUE;  // 초기화
        }

        // 도로 정보 입력 받기
        for (int i = 0; i < v; i++) {
            line = br.readLine().split(" ");
            int c1 = Integer.parseInt(line[0]);
            int c2 = Integer.parseInt(line[1]);
            int g = Integer.parseInt(line[2]);
            graph.get(c1).add(new int[]{c2, g});
            graph.get(c2).add(new int[]{c1, g});
        }

        // 초기 상태: 시작 도시 1, 비용 0, 톨게이트 개수 0 (짝수)
        dist[1][0] = 0;
        pq.offer(new int[]{0, 1, 0});

        // 다익스트라 알고리즘
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0];
            int node = current[1];
            int tollCount = current[2];  // 짝수(0) 또는 홀수(1)

            // 현재 상태가 이미 더 좋은 경로라면 무시
            if (cost > dist[node][tollCount]) continue;

            // 연결된 도로 탐색
            for (int[] next : graph.get(node)) {
                int nextNode = next[0];
                int nextCost = next[1];
                int nextTollCount = (tollCount + 1) % 2;  // 톨게이트 개수 갱신 (짝수 -> 홀수, 홀수 -> 짝수)

                int newCost = cost + nextCost;

                // 짝수 톨게이트일 때만 진행
                if (newCost < dist[nextNode][nextTollCount]) {
                    dist[nextNode][nextTollCount] = newCost;
                    pq.offer(new int[]{newCost, nextNode, nextTollCount});
                }
            }
        }

        // 최종 도달 가능하면서 짝수 톨게이트를 지나야 하는 비용을 출력
        if (dist[c][0] == Integer.MAX_VALUE) {
            System.out.println(-1);  // 불가능한 경우
        } else {
            System.out.println(dist[c][0]);
        }
    }
}