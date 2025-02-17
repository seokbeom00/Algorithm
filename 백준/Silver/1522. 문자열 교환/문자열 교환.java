import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int aCnt = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                aCnt += 1;
            }
        }
        char[] arr = (s + s).toCharArray();
        int bCnt = 0;
        for (int i = 0; i < aCnt; i++) {
            if (arr[i] == 'b') {
                bCnt += 1;
            }
        }
        int min = bCnt;
        for (int i = aCnt; i < arr.length; i++) {
            if (arr[i - aCnt] == 'b') {
                bCnt -= 1;
            }
            if (arr[i] == 'b') {
                bCnt += 1;
            }
            min = Math.min(bCnt, min);
        }
        System.out.println(min);
    }
}