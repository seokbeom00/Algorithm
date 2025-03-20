import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]), c = Integer.parseInt(line[1]);
        int[] home = new int[n];
        for (int i = 0; i < n; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);
        int left = 1, right = home[n - 1] - home[0];
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 1;
            int before = 0;
            for (int i = 1; i < n; i++) {
                if (home[i] - home[before] >= mid) {
                    sum++;
                    before = i;
                }
            }
            if (sum < c) {
                right = mid - 1;
            } else if (sum >= c) {
                ans = mid;
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
