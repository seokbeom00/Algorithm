import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<List<Integer>> result;
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        result = new ArrayList<>();
        dfs(n, m, new ArrayList<>(), 1);
        for (List<Integer> list : result) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int n, int m, List<Integer> current, int idx) {
        if (current.size() == m) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (idx == n + 1) {
            return;
        }
        for (int i = idx; i <= n; i++) {
            current.add(i);
            dfs(n, m, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
