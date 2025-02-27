import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K, P, X;
    static long count = 0;
    static int[][] display = {{1, 1, 1, 0, 1, 1, 1}, //0
            {0, 0, 1, 0, 0, 0, 1}, //1
            {0, 1, 1, 1, 1, 1, 0}, //2
            {0, 1, 1, 1, 0, 1, 1}, //3
            {1, 0, 1, 1, 0, 0, 1}, //4
            {1, 1, 0, 1, 0, 1, 1}, //5
            {1, 1, 0, 1, 1, 1, 1}, //6
            {0, 1, 1, 0, 0, 0, 1}, //7
            {1, 1, 1, 1, 1, 1, 1}, //8
            {1, 1, 1, 1, 0, 1, 1}}; //9

    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);
        P = Integer.parseInt(line[2]);
        X = Integer.parseInt(line[3]);
        int[] x_digit = toDigital(X);
        check(0, x_digit);
        System.out.println(count);
    }

    public static void check(int num, int[] x_digit) {
        for(int i = 1; i <= N; i++) {
            if(i == X) continue;
            if(can_reverse(i, x_digit)) count++;
        }
    }

    public static boolean can_reverse(int target, int[] x_digit) {
        int[] target_digit = toDigital(target);

        int diff_count = 0;
        for(int i = 0; i < K; i++) {
            for(int j = 0; j < 7; j++) {
                if(display[x_digit[i]][j] != display[target_digit[i]][j]) {
                    diff_count++;
                    if(diff_count > P) return false;
                }
            }
        }
        return true;
    }

    public static int[] toDigital(int x) {
        int[] result = new int[K];
        for(int i = K - 1; i >= 0; i--) {
            result[i] = x % 10;
            x /= 10;
        }
        return result;
    }
}
