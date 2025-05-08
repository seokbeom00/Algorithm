import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split("");
        String num = line[0];
        List<String> stack = new ArrayList<>();
        for (int i = 1; i < line.length; i++) {
            if (line[i].equals("-") || line[i].equals("+")) {
                stack.add(num);
                num = "";
                stack.add(line[i]);
            } else {
                num += line[i];
            }
        }
        stack.add(num);
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i).equals("-")) {
                list.add(sum);
                sum = 0;
            } else if (stack.get(i).equals("+")) {
                continue;
            } else {
                sum += Integer.parseInt(stack.get(i));
            }
        }
        if (sum > 0) {
            list.add(sum);
        }
        if (list.size() == 1) {
            System.out.println(list.get(0));
        } else {
            int ans = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                ans -= list.get(i);
            }
            System.out.println(ans);
        }
    }
}
