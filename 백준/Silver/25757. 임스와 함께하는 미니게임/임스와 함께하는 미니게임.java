import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        Set<String> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String type = st.nextToken();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        int ans = 0;
        int limit = typeToCount(type);
        ans = set.size() / limit;
        System.out.println(ans);
    }
    public static int typeToCount(String type) {
        if (type.equals("Y")) {
            return 1;
        } else if (type.equals("F")) {
            return 2;
        } else {
            return 3;
        }
    }
}
