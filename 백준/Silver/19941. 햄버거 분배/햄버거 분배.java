import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        String[] info = br.readLine().split("");
        boolean[] check = new boolean[n];
        int ans = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i].equals("P")) {
                for (int j = i - k; j <= i + k; j++) {
                    if (j >= 0 && j < n && info[j].equals("H") && !check[j]) {
                        check[j] = true;
                        ans += 1;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
