import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        List<int[]> skyline = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            skyline.add(new int[]{a, b});
        }
        skyline.sort((s1, s2) -> Integer.compare(s1[0], s2[0]));
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int[] arr : skyline) {
            if (arr[1] == 0) {
                stack.clear();
            }else{
                if (stack.isEmpty()) {
                    stack.push(arr[1]);
                    ans += 1;
                }else{
                    while (!stack.isEmpty()) {
                        if (stack.peek() == arr[1]) {
                            break;
                        } else if (stack.peek() > arr[1]) {
                            stack.pop();
                        } else if (stack.peek() < arr[1]) {
                            ans += 1;
                            break;
                        }
                    }
                    if (stack.isEmpty()) {
                        ans += 1;
                    }
                    stack.push(arr[1]);
                }
            }
        }
        System.out.println(ans);
    }
}
