import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        for (int t = 0; t < 3; t++) {
            int n = Integer.parseInt(br.readLine());
            List<int[]> coins = new ArrayList<>();
            int total = 0;
            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                int price = Integer.parseInt(line[0]);
                int count = Integer.parseInt(line[1]);
                total += price * count;
                coins.add(new int[]{price, count});
            }
            if (total % 2 == 1) {
                System.out.println(0);
                continue;
            }
            boolean[] dp = new boolean[total / 2 + 1];
            dp[0] = true;
            for (int[] coin : coins) {
                int price = coin[0];
                int count = coin[1];
                for (int target = total / 2; target >= 0; target--) {
                    if (dp[target]) {
                        for (int cnt = 1; cnt <= count; cnt++) {
                            int next = target + price * cnt;
                            if (next > total / 2) {
                                break;
                            }
                            dp[next] = true;
                        }
                    }
                }
            }
            System.out.println(dp[total / 2] ? 1 : 0);
        }
    }
}