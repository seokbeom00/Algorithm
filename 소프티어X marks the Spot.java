import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder("");
        int n = Integer.parseInt(br.readLine());
        String[] list = new String[n];
        for(int i=0; i<n; i++){
            list[i] = br.readLine().toUpperCase();
        }
        for(int i=0; i<n; i++){
            String[] parts = list[i].split(" ");
            String s = parts[0];
            String t = parts[1];
            sb.append(t.charAt(s.indexOf("X")));
        }
        System.out.println(sb);
    }
}
