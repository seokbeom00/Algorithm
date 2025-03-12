import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(num);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            int target = num[i];
            while (true) {
                if (left == i) {
                    left++;
                }
                if (right == i) {
                    right--;
                }
                if (left >= right) {
                    break;
                }
                if (num[left] + num[right] < target) {
                    left++;
                } else if (num[left] + num[right] > target) {
                    right--;
                } else if (num[left] + num[right] == target) {
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
