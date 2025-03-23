import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        long answer = 0;
        String[] line = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(line[i]);
        }
        boolean[] check = new boolean[100001];
        int start = 0, end = 0;
        while (start < n) {
            while (end < n && !check[nums[end]]) {
                check[nums[end]] = true;
                end++;
            }
            answer += end - start;
            check[nums[start]] = false;
            start++;
        }
        System.out.println(answer);
    }
}
