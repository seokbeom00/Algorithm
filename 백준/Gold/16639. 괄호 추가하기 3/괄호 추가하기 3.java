import java.util.*;
import java.io.*;

public class Main {
    static class dpValue{
        int max,min;
        public dpValue(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }
    static int N;
    static ArrayList<Integer> number = new ArrayList<>();
    static ArrayList<Character> operator = new ArrayList<>();
    static dpValue[][] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static public void  main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        for (char c : arr) {
            if (Character.isDigit(c)) {
                number.add(Character.getNumericValue(c));
            } else {
                operator.add(c);
            }
        }
        dp = new dpValue[number.size()][number.size()];
        for (int i = 0; i < number.size(); i++) {
            dp[i][i] = new dpValue(number.get(i), number.get(i));
        }
        for (int end = 1; end < number.size(); end++) {
            for (int start = end - 1; start >= 0; start--) {
                calculate(start, end);
            }
        }
        System.out.println(dp[0][number.size()-1].max);
    }

    public static void calculate(int start, int end) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int mid = start; mid < end; mid++) {
            dpValue left = dp[start][mid];
            dpValue right = dp[mid + 1][end];
            char op = operator.get(mid);

            int[] candidates = new int[4];

            if (op == '+') {
                candidates[0] = left.max + right.max;
                candidates[1] = left.max + right.min;
                candidates[2] = left.min + right.max;
                candidates[3] = left.min + right.min;
            } else if (op == '-') {
                candidates[0] = left.max - right.max;
                candidates[1] = left.max - right.min;
                candidates[2] = left.min - right.max;
                candidates[3] = left.min - right.min;
            } else if (op == '*') {
                candidates[0] = left.max * right.max;
                candidates[1] = left.max * right.min;
                candidates[2] = left.min * right.max;
                candidates[3] = left.min * right.min;
            }

            for (int val : candidates) {
                max = Math.max(max, val);
                min = Math.min(min, val);
            }
        }

        dp[start][end] = new dpValue(max, min);
    }
}