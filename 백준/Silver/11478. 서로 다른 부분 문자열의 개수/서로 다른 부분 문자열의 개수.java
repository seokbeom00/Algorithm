import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Set<String> set;
    public static void main(String[] args) throws IOException{
        String[] s = br.readLine().split("");
        set = new HashSet<>();
        for (int i = 0; i < s.length; i++) {
            String tmp = s[i];
            set.add(tmp);
            for (int j = i + 1; j < s.length; j++) {
                tmp += s[j];
                set.add(tmp);
            }
        }
        System.out.println(set.size());
    }
}
