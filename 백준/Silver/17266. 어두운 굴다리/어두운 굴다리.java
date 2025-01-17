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
        int ans = 1;
        while (true) {
            if (check(pos, ans, n)) {
                System.out.println(ans);
                break;
            }
            ans += 1;
        }
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
