import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        while (true) {
            String[] parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b= Integer.parseInt(parts[1]);
            int c = Integer.parseInt(parts[2]);
            int[] list = {a, b, c};
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            Arrays.sort(list);
            if (list[2] >= list[0] + list[1]) {
                System.out.println("Invalid");
            } else if (a == b && b == c) {
                System.out.println("Equilateral");
            } else if (a == b || a == c || b == c) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}
