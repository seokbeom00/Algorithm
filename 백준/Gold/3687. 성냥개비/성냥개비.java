import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] dp = new long[100 + 1];
    public static void main(String[] args) throws IOException{
        init();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int num = Integer.parseInt(br.readLine());
            smallNum(num);
            bigNum(num);
        }
    }

    public static void init() {
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[2] = 1;
        dp[3] = 7;
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6;
        dp[7] = 8;
        dp[8] = 10;
        int[] min = {1, 7, 4, 2, 0, 8}; // 2개 ~ 7개
        for (int i = 9; i <= 100; i++) {
            for (int j = 0; j < 6; j++) {
                dp[i] = Math.min(dp[i - j - 2] * 10 + min[j], dp[i]);
            }
        }
    }

    public static void smallNum(int num) {
        System.out.print(dp[num] + " ");
    }

    public static void bigNum(int num) {
        StringBuilder sb = new StringBuilder();
        if (num % 2 == 0) {
            for (int i = 0; i < num / 2; i++) {
                sb.append(1);
            }
        } else {
            sb.append(7);
            num -= 3;
            if (num > 0) {
                for (int i = 0; i < num / 2; i++) {
                    sb.append(1);
                }
            }
        }
        System.out.println(sb);
    }
}