import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] parts = line.split(" ");
        int h = Integer.parseInt(parts[0]); //열
        int w = Integer.parseInt(parts[1]); //행
        int n = Integer.parseInt(parts[2]); //열 간격
        int m = Integer.parseInt(parts[3]); //행 간격

        int column = w / (m + 1);
        if (w % (m + 1) != 0) {
            column += 1;
        }
        int row = h / (n + 1);
        if (h % (n + 1) != 0) {
            row += 1;
        }
        System.out.println(column * row);
    }
}
