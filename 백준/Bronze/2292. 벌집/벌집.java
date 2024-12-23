import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(1);
            return;
        }
        int answer = 2;
        int range = 1;
        int count = 1;
        while (true) {
            range += count * 6;
            if (n <= range) {
                System.out.println(answer);
                break;
            }
            answer += 1;
            count += 1;
        }
    }
}
