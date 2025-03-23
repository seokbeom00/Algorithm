import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        String[] lines = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(lines[i]);
        }
        List<Integer> dp = new ArrayList<>();
        for (int num : nums) {
            int index = Collections.binarySearch(dp, num);
            if (index < 0) {
                index = -(index + 1);
            }
            if (index == dp.size()) {
                dp.add(num);
            }else{
                dp.set(index, num);
            }
        }
        System.out.println(dp.size());
    }
}
