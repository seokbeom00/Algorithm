import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int min;
    static int max;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int j = 0; j < T; j++) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            char[] line = br.readLine().toCharArray();
            int k = Integer.parseInt(br.readLine());
            int[] cnt = new int[26];
            for (char c : line) {
                cnt[c - 'a'] += 1;
            }
            for (int i = 0; i < 26; i++) {
                if (cnt[i] >= k) {
                    find((char) ('a' + i), line, k);
                }
            }
            if (min == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(min + " " + max);
            }
        }
    }

    public static void find(char target, char[] line, int k) {
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            if (line[i] == target) {
                li.add(i);
            }
        }
        for (int i = k - 1; i < li.size(); i++) {
            int len = li.get(i) - li.get(i - k + 1) + 1;
            min = Math.min(len, min);
            max = Math.max(len, max);
        }
    }
}