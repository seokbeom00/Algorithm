import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[] standard = br.readLine().toCharArray();
        Arrays.sort(standard);
        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            String line = br.readLine();
            char[] str = line.toCharArray();
            Arrays.sort(str);
            int p1 = 0;
            int p2 = 0;
            int same = 0;
            while (p1 < standard.length && p2 < str.length) {
                if (standard[p1] == str[p2]) {
                    p1++;
                    p2++;
                    same++;
                } else if (standard[p1] < str[p2]) {
                    p1++;
                }else{
                    p2++;
                }
            }
            if (same >= Math.max(standard.length, str.length) - 1) {
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}