import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Integer> price = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int sum = 0;
        String[] part = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(part[i]);
            sum += tmp;
            max = Math.max(tmp, max);
            price.add(Integer.parseInt(part[i]));
        }
        int m = Integer.parseInt(br.readLine());
        if (sum <= m) {
            System.out.println(max);
        } else {
            int left = 1;
            int right = max;
            while (left <= right) {
                int mid = (left + right) / 2;
                int total = 0;
                for (int p : price) {
                    if (p > mid) {
                        total += mid;
                    }else{
                        total += p;
                    }
                }
                if (total <= m) {
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            System.out.println(right);
        }
    }
}

