import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        String[] parts = s.split("");
        boolean[] flag = new boolean[parts.length];
        int one = 0;
        int zero = 0;
        for (String S : parts) {
            if (S.equals("0")) {
                zero += 1;
            }else{
                one += 1;
            }
        }
        one = one / 2;
        zero = zero / 2;
        for (int i = 0; i < parts.length; i++) {
            if (one == 0) {
                break;
            }
            if (parts[i].equals("1")) {
                flag[i] = true;
                one -= 1;
            }
        }
        for (int i = parts.length-1; i >= 0; i--) {
            if (zero == 0) {
                break;
            }
            if (parts[i].equals("0")) {
                flag[i] = true;
                zero -= 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            if (!flag[i]) {
                sb.append(parts[i]);
            }
        }
        System.out.println(sb);
    }
}