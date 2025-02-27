import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(line[i]);
        }
        int left = 0, right = n - 1;
        long min = Long.MAX_VALUE;
        long ans1 = 0, ans2 = 0;
        while (left < right) {
            long sum = arr[left] + arr[right];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                ans1 = arr[left];
                ans2 = arr[right];
            }
            if (sum > 0) {
                right-= 1;
            }else{
                left += 1;
            }
        }
        System.out.println(ans1 + " " + ans2);
    }
}
