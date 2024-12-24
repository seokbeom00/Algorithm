import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String answer = "";
        int kbs1 = 0;
        int kbs2 = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.equals("KBS1")) {
                kbs1 = i;
            }else if (str.equals("KBS2")) {
                kbs2 = i;
            }
        }
        for (int i = 0; i < kbs1; i++) {
            answer += "1";
        }
        for (int i = 0; i < kbs1; i++) {
            answer += "4";
        }
        if (kbs2 < kbs1) {
            kbs2 += 1;
        }
        for (int i = 0; i < kbs2; i++) {
            answer += "1";
        }
        for (int i = 0; i < kbs2-1; i++) {
            answer += "4";
        }
        System.out.println(answer);
    }
}
