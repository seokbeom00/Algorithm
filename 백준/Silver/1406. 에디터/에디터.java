import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split("");
        LinkedList<String> left = new LinkedList<>(Arrays.asList(line));
        LinkedList<String> right = new LinkedList<>();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] command = br.readLine().split(" ");
            if (command.length == 2) {
                String element = command[1];
                left.add(element);
            }else{
                String edit = command[0];
                if (edit.equals("L")) {
                    if(!left.isEmpty()){
                        right.offerFirst(left.pollLast());
                    }
                } else if (edit.equals("D")) {
                    if (!right.isEmpty()) {
                        left.add(right.pollFirst());
                    }
                } else if (edit.equals("B")) {
                    if (!left.isEmpty()) {
                        left.pollLast();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : left) {
            sb.append(s);
        }
        for (String s : right) {
            sb.append(s);
        }
        System.out.println(sb);
    }
}
