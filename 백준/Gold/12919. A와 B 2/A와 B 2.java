import java.io.*;
import java.util.*;

public class Main {
    static String s;
    static String t;
    static int ans;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        s = br.readLine();
        t = br.readLine();
        dfs(t);
        System.out.println(ans);
    }

    public static void dfs(String str) {
        if (str.length() == s.length()) {
            if (str.equals(s)) {
                ans = 1;
            }
            return;
        }
        if (str.endsWith("A")) {
            dfs(str.substring(0, str.length() - 1));
        }
        if (str.startsWith("B")) {
            dfs(new StringBuilder(str.substring(1)).reverse().toString());
        }
    }
}