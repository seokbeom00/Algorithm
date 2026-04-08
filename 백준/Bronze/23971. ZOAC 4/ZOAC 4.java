import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] line = s.split(" ");
        int h = Integer.parseInt(line[0]);
        int w = Integer.parseInt(line[1]);
        int n = Integer.parseInt(line[2]);
        int m = Integer.parseInt(line[3]);
//        System.out.println(m);
//        w개씩 h줄 행끼리 N칸 열끼리 m칸
        int x = w / (m + 1);
        if (w % (m + 1) > 0) {
            x++;
        }
        int y = h / (n + 1);
        if (h % (n + 1) > 0) {
            y++;
        }
        System.out.println(x * y);
    }
}
