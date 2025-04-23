import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static class Edge {
        int to, idx;

        public Edge(int to, int idx) {
            this.to = to;
            this.idx = idx;
        }
    }

    static int n, m; // 정점, 간선
    static List<List<Edge>> graph;
    static boolean[] visited; // 정점 방문 확인
    static int dfsCount = 0; // dfs 횟수 확인 (입력된 그래프 개수 확인)

    static List<Integer> edgePath; // DFS 간선 순서 확인
    static List<Integer> nodePath; // DFS 정점 순서 확인

    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        // 정점이 2개 이하
        if (n <= 2) {
            System.out.println(-1);
            return;
        }

        visited = new boolean[n + 1];
        visited[0] = true; // 0번 안씀

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());

            // 양방향
            graph.get(u).add(new Edge(v, i));
            graph.get(v).add(new Edge(u, i));
        }

        for (int i = 1; i <= n; i++) {
            // 방문 확인
            if (visited[i]) continue;

            // 3개 이상의 그래프가 입력된 경우를 확인
            if (dfsCount == 2) {
                System.out.println(-1);
                return;
            }
            visited[i] = true;
            dfsCount++;

            // DFS 전에 경로 초기화
            edgePath = new ArrayList<>();
            nodePath = new ArrayList<>();
            nodePath.add(i);
            dfs(i);

            // 모든 정점을 한 번에 방문했다면?
            // 즉, 그래프가 1개가 입력되었다면?
            // 마지막으로 방문한 정점 하나만 자르면 됨
            if (edgePath.size() == n - 1) {
                calc();
                break;
            }

            // 첫 DFS가 끝나면
            // 그래프 분할을 짐작할 수 있다.
            // 예외의 경우도 이전 조건 분기로 자연스레 처리된다.
            if (dfsCount == 1) {

                // 그래프가 같은 크기의 트리 2개로 분할된다면?
                if (2 * nodePath.size() == n) {
                    System.out.println(-1);
                    return;
                }

                stringBuilder
                        .append(nodePath.size())
                        .append(" ")
                        .append(n - nodePath.size())
                        .append("\n");
            }

            // 정점 방문 순서 출력
            for (int node : nodePath) {
                stringBuilder.append(node).append(" ");
            }
            stringBuilder.append("\n");

            // 간선 방문 순서 출력
            for (int edge : edgePath) {
                stringBuilder.append(edge).append(" ");
            }
            stringBuilder.append("\n");

        }

        System.out.println(stringBuilder);

    }

    // 모든 정점을 한 번에 방문했다면?
    // 즉, 그래프가 1개가 입력되었다면?
    // 마지막으로 방문한 정점 하나만 자르면 됨
    private static void calc() {
        stringBuilder.append(n - 1).append(" ").append(1);

        stringBuilder.append("\n");

        for (int i = 0; i < nodePath.size() - 1; i++) {
            stringBuilder.append(nodePath.get(i)).append(" ");
        }

        stringBuilder.append("\n");

        for (int i = 0; i < edgePath.size() - 1; i++) {
            stringBuilder.append(edgePath.get(i)).append(" ");
        }

        stringBuilder.append("\n");

        stringBuilder.append(nodePath.get(nodePath.size() - 1));

        stringBuilder.append("\n");
    }

    // 정점과 간선 방문 순서를 기록하는
    // 일반적인 DFS
    private static void dfs(int nodeIdx) {

        List<Edge> edges = graph.get(nodeIdx);
        for (Edge edge : edges) {
            if (visited[edge.to]) continue;
            visited[edge.to] = true;
            edgePath.add(edge.idx);
            nodePath.add(edge.to);

            dfs(edge.to);
        }

    }
}