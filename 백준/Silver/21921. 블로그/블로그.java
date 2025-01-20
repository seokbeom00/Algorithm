import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int x = Integer.parseInt(line[1]);
        int[] num = new int[n];
        String[] line2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(line2[i]);
        }
        int max = 0;
        int cnt = 1;
        int firstIndex = 0;
        for (int i = 0; i < x; i++) {
            max += num[i];
        }
        int sub = max;
        for (int i = x; i < n; i++) {
            sub = sub - num[firstIndex] + num[i];
            if (sub > max) {
                max = sub;
                cnt = 1;
            } else if (sub == max) {
                cnt += 1;
            }
            firstIndex += 1;
        }
        if (max == 0) {
            System.out.println("SAD");
        }else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}
