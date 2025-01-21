import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String line = br.readLine();
        String[] arr = line.split("");
        int num = 1;
        int idx = 0;
        while (idx < arr.length) {
            String[] str = String.valueOf(num).split("");
            for (int i = 0; i < str.length; i++) {
                if (idx >= arr.length) {
                    break;
                }
                if (arr[idx].equals(str[i])) {
                    idx += 1;
                }
            }
            num += 1;
        }
        System.out.println(num - 1);
    }
}
