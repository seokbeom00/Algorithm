import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            arr.add(new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])});
        }
        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (arr.get(j)[0] > arr.get(i)[0] && arr.get(j)[1] > arr.get(i)[1]) {
                    rank += 1;
                }
            }
            System.out.print(rank + " ");
        }
    }
}
