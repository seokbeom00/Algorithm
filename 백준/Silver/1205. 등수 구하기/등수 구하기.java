import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        String[] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        if (n == 0) {
            System.out.println(1);
            return;
        }

        int newScore = Integer.parseInt(parts[1]);
        int p = Integer.parseInt(parts[2]);

        String[] parts2 = br.readLine().split(" ");
        Integer[] scores = new Integer[n+1];
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(parts2[i]);
        }
        scores[n] = newScore;
        Arrays.sort(scores, Collections.reverseOrder());

        int cnt = 1;
        int rank = 1;
        boolean flag = false;
        if (scores[0] == newScore) {
            flag = true;
        }
        for (int i = 1; i <= n; i++) {
            cnt += 1;
            if (scores[i] == newScore) {
                flag = true;
            }
            if (flag && scores[i] < newScore) {
                break;
            }
            if (scores[i - 1] > scores[i]) {
                rank = cnt;
            }
            if (cnt > p) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(rank);
    }
}
