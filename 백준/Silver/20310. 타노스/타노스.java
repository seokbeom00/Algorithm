import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        String[] parts = s.split("");
        int one = 0;
        int zero = 0;
        for (String S : parts) {
            if (S.equals("0")) {
                zero += 1;
            }else{
                one += 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zero / 2; i++) {
            sb.append("0");
        }
        for (int i = 0; i < one / 2; i++) {
            sb.append("1");
        }
        System.out.println(sb);
    }
}