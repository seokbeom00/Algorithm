import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int s = Integer.parseInt(line[1]);
        line = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(line[i]);
        }

        int start = 0, end = 0, total = 0, ans = Integer.MAX_VALUE;

        while (end < n) { // `end`가 `n`보다 작을 때까지만 진행
            total += nums[end++];

            while (total >= s) { // 조건을 만족하면 최소 길이 갱신
                ans = Math.min(ans, end - start);
                total -= nums[start++];
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}