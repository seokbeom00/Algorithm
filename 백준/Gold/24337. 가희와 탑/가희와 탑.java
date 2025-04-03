import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        String[] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int a = Integer.parseInt(parts[1]);
        int b = Integer.parseInt(parts[2]);
        List<Integer> top = new ArrayList<>();
        if (Math.max(a, b) > n || a + b - 1 > n) {
            System.out.println(-1);
            return;
        }
        for (int i = 1; i < a; i++) {
            top.add(i);
        }
        top.add(Math.max(a, b));
        for (int i = b - 1; i >= 1; i--) {
            top.add(i);
        }
        if (a == 1) {
            while (top.size() < n) {
                top.add(1, 1);
            }
        }else{
            while (top.size() < n) {
                top.add(0, 1);
            }
        }
        for (int num : top) {
            System.out.print(num + " ");
        }
    }
}