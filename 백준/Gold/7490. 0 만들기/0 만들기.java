import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<String> ans;

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            ans = new ArrayList<>();
            dfs("1", 2, 1, n);
            Collections.sort(ans);
            for (String s : ans) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    public static void dfs(String sub, int num, int cnt, int n) {
        if (cnt == n + n - 1) {
            calculate(sub);
            return;
        }
        dfs(sub + "+" + num, num + 1, cnt + 2, n);
        dfs(sub + "-" + num, num + 1, cnt + 2, n);
        dfs(sub + " " + num, num + 1, cnt + 2, n);
    }

    public static void calculate(String sub) {
        String line = sub.replace(" ", "");
        StringTokenizer st = new StringTokenizer(line, "\\+|-", true);
        int sum = Integer.parseInt(st.nextToken());
        while (st.hasMoreTokens()) {
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if (op.equals("+")) {
                sum += num;
            } else {
                sum -= num;
            }
        }
        if (sum == 0) {
            ans.add(sub);
        }
    }
}
