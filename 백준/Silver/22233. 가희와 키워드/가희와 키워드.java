import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        Set<String> keyword = new HashSet<>();
        for (int i = 0; i < n; i++) {
            keyword.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                if(keyword.contains(str)){
                    keyword.remove(str);
                }
            }
            System.out.println(keyword.size());
        }
    }
}
