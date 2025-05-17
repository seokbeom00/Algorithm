import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static List<int[]> wormholes;
    static boolean[] visit;
    static int answer;
    static Map<Integer, Integer> map;
    static boolean flag;
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        wormholes = new ArrayList<>();
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            wormholes.add(new int[]{x, y});
        }
        answer = 0;
        wormholes.sort((a, b) -> Integer.compare(a[0], b[0]));
        generate(new ArrayList<>());
        System.out.println(answer);
    }
    static void check(List<int[]> pairs) {
        flag = false;
        map = new HashMap<>();
        for (int[] p : pairs) {
            map.put(p[0], p[1]);
            map.put(p[1], p[0]);
        }
        for (int i = 0; i < n; i++) {
            int[] warm = wormholes.get(i);
            go(warm[0], warm[1], 1);
            if (flag) {
                answer++;
                break;
            }
        }
    }

    public static void go(int x, int y, int cnt) {
        if (cnt >= n + 1) {
            flag = true;
            return;
        }
        for (int i = 0; i < n; i++) {
            int[] warm = wormholes.get(i);
            int dx = warm[0];
            int dy = warm[1];
            if (dx > x && y == dy) {
                int next = map.get(i);
                int[] nextWarm = wormholes.get(next);
                go(nextWarm[0], nextWarm[1], cnt + 1);
                break;
            }
        }
    }

    static void generate(List<int[]> pairs) {
        if (pairs.size() == n / 2) {
            check(pairs);
            return;
        }
        int fisrt = -1;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                fisrt = i;
                break;
            }
        }
        visit[fisrt] = true;
        for (int i = fisrt + 1; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                pairs.add(new int[]{fisrt, i});
                generate(pairs);
                visit[i] = false;
                pairs.remove(pairs.size() - 1);
            }
        }
        visit[fisrt] = false;
    }
}
