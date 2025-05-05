import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        line = br.readLine().split(" ");
        int total = 0;
        for (int i = 0; i < N; i++) {
            total += Integer.parseInt(line[i]) + 1;
        }
        int[] unhappy = new int[N + 1];
        int total_unhappy = M - total;
        while (total_unhappy > 0) {
            for (int i = 0; i < unhappy.length; i++) {
                unhappy[i] += 1;
                total_unhappy -= 1;
                if (total_unhappy == 0) {
                    break;
                }
            }
        }
        int ans = 0;
        for (int u : unhappy) {
            for (int i = 1; i <= u; i++) {
                ans += i * i;
            }
        }
        System.out.println(ans);
    }
}