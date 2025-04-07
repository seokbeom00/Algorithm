import java.io.*;
import java.util.*;
import javax.swing.Icon;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static List<List<Integer>> combi = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);
        List<int[]> home = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]), y = Integer.parseInt(line[1]);
            home.add(new int[]{x, y});
        }
        combination(new ArrayList<>(), 0);
        int answer = Integer.MAX_VALUE;
        for (List<Integer> com : combi) {
            int max = 0;
            for (int i = 0; i < N; i++) {
                if (com.contains(i)) {
                    continue;
                }
                int min = Integer.MAX_VALUE;
                int[] home1 = home.get(i);
                for (int c : com) {
                    int[] home2 = home.get(c);
                    int dis = Math.abs(home1[0] - home2[0]) + Math.abs(home1[1] - home2[1]);
                    min = Math.min(dis, min);
                }
                max = Math.max(min, max);
            }
            answer = Math.min(answer, max);
        }
        System.out.println(answer);
    }
    public static void combination(List<Integer> current, int index) {
        if (current.size() == K) {
            combi.add(new ArrayList<>(current));
            return;
        }
        if (index == N) {
            return;
        }
        for (int i = index; i < N; i++) {
            current.add(i);
            combination(current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}