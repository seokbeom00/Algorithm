import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        List<Integer> dp = new ArrayList<>();
        for (int num : numbers) {
            int index = -Collections.binarySearch(dp, num);
            index--;
            if (index == dp.size()) {
                dp.add(num);
            }else{
                dp.set(index, num);
            }
        }
        System.out.println(n - dp.size());
    }
}
