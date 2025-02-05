import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        String[] name = new String[n];
        int[] cut = new int[n];
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            name[i] = parts[0];
            cut[i] = Integer.parseInt(parts[1]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int score = Integer.parseInt(br.readLine());
            sb.append(name[binarySearch(score, cut, n)]+"\n");
        }
        System.out.println(sb);
    }

    public static int binarySearch(int score, int[] cut, int n) {
        int left = 0;
        int right = n-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (cut[mid] >= score) {
                right = mid - 1;
                if (right == -1) {
                    return 0;
                }
            }else{
                left = mid + 1;
                if (left == n) {
                    return n - 1;
                }
            }
        }
        return left;
    }
}