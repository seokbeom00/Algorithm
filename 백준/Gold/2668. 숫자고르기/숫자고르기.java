import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Set<Integer> ans = new HashSet<>();
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i < n + 1; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, arr[i], "");
        }
        List<Integer> list = new ArrayList<>(ans);
        Collections.sort(list);
        System.out.println(list.size());
        for (int i : list) {
            System.out.println(i);
        }
    }

    public static void dfs(int start, int num, String str) {
        if (start == num) {
            String[] line = str.split(",");
            ans.add(start);
            if (!str.equals("")) {
                for (String s : line) {
                    ans.add(Integer.parseInt(s));
                }
            }
            return;
        }
        if (!visited[num]) {
            visited[num] = true;
            dfs(start, arr[num], str + num + ",");
        }
    }
}
