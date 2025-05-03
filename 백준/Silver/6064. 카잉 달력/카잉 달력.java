import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int t = Integer.parseInt(br.readLine());
        String[] line;
        for (int i = 0; i < t; i++) {
            line = br.readLine().split(" ");
            int M = Integer.parseInt(line[0]);
            int N = Integer.parseInt(line[1]);
            int x = Integer.parseInt(line[2]) - 1;
            int y = Integer.parseInt(line[3]) - 1;
            int cnt = -1;
            for (int j = x; j < M * N; j += M) {
                if (j % N == y) {
                    cnt = j + 1;
                    break;
                }
            }
            System.out.println(cnt);
        }
    }
}
