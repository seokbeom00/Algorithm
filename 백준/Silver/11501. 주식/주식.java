import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] price = new int[n];
            int[] max = new int[n];
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                price[j] = Integer.parseInt(line[j]);
            }
            int currentMax = 0;
            for (int j = n - 2; j >= 0; j--) {
                max[j] = Math.max(currentMax, price[j + 1]);
                currentMax = max[j];
            }
            long ans = 0;
            for (int j = 0; j < n; j++) {
                if (max[j] > price[j]) {
                    ans += max[j] - price[j];
                }
            }
            System.out.println(ans);
        }
    }
}
