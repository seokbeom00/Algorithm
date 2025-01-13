import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int answer = 0;
            String[] parts = br.readLine().split(" ");
            int[] nums = new int[20];
            for (int j = 1; j < 21; j++) {
                nums[j - 1] = Integer.parseInt(parts[j]);
            }

            List<Integer> arr = new ArrayList<>();
            arr.add(nums[0]);
            for (int j = 1; j < 20; j++) {
                for (int l = 0; l < arr.size(); l++) {
                    if(arr.get(l) > nums[j]){
                        answer += (arr.size() - l);
                        break;
                    }
                }
                arr.add(nums[j]);
                Collections.sort(arr);
            }
            System.out.println(i+1 + " " + answer);
        }
    }
}
