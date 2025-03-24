import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parent;
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                int isConnect = Integer.parseInt(line[j]);
                if (isConnect == 1) {
                    union(i + 1, j + 1);
                }
            }
        }
        String[] line = br.readLine().split(" ");
        boolean flag = true;
        for (int i = 1; i < line.length; i++) {
            int before = Integer.parseInt(line[i - 1]), current = Integer.parseInt(line[i]);
            if (find(before) != find(current)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}
