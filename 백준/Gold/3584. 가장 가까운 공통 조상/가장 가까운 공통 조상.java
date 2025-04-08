import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] parent = new int[n + 1];
            for (int i = 0; i < n - 1; i++) {
                String[] line = br.readLine().split(" ");
                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);
                parent[b] = a;
            }
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            stack1.push(a);
            stack2.push(b);
            dfs(stack1, parent, a);
            dfs(stack2, parent, b);
            int answer = 0;
            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                if (Objects.equals(stack1.peek(), stack2.peek())) {
                    answer = stack1.pop();
                    stack2.pop();
                }else{
                    break;
                }
            }
            System.out.println(answer);
        }
    }

    public static void dfs(Stack<Integer> stack, int[] parent, int node) {
        if (parent[node] == 0) {
            return;
        }
        stack.push(parent[node]);
        dfs(stack, parent, parent[node]);
    }
}
