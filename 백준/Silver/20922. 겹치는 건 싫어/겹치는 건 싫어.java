import java.util.*;
import java.io.*;

public class Main {
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int[] arr = new int[n];
        String[] parts = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        int[] cnt = new int[100001];
        int left = 0;
        int right = 0;
        while (right < n) {
            while (right < n && cnt[arr[right]] + 1 <= k) {
                cnt[arr[right]] += 1;
                right += 1;
            }
            int len = right - left;
            ans = Math.max(len, ans);
            cnt[arr[left]] -= 1;
            left += 1;
        }
        System.out.println(ans);
    }
}