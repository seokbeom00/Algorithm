import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String[] parts = br.readLine().split(" ");
        int[] pos = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            pos[i] = Integer.parseInt(parts[i]);
        }
        int ans = 0;
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(pos, mid, n)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean check(int[] pos, int height, int n) {
        int min = 0;
        for (int p : pos) {
            if (p - height > min) {
                return false;
            }else {
                min = p + height;
            }
        }
        if (pos[pos.length - 1] + height >= n) {
            return true;
        }else{
            return false;
        }
    }
}
