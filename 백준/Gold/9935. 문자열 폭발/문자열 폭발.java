import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        char[] arr = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            stack.push(c);
            if (c == target[target.length - 1] && stack.size() >= target.length) {
                boolean flag = true;
                int pointer = target.length - 1;
                for (int i = 0; i < target.length; i++) {
                    if (stack.get(stack.size() - 1 - i) != target[pointer]) {
                        flag = false;
                        break;
                    }
                    pointer--;
                }
                if (flag) {
                    for (int j = 0; j < target.length; j++) {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}