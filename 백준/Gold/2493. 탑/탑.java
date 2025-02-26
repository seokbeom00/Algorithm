import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = Integer.parseInt(line[i]);
        }
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                System.out.print(0 + " ");
                stack.push(new int[]{top[i], i + 1});
            }else{
                while (true) {
                    if (stack.isEmpty()) {
                        System.out.print(0 + " ");
                        stack.push(new int[]{top[i], i + 1});
                        break;
                    }
                    int[] arr = stack.peek();
                    if (arr[0] > top[i]) {
                        System.out.print(arr[1] + " ");
                        stack.push(new int[]{top[i], i + 1});
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
        }
    }
}