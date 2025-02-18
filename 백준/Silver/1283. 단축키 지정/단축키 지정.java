import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] line = s.split(" ");
            int idx = 0;
            boolean flag = false;
            for (String str : line) {
                String[] arr = str.split("");
                if (!set.contains(arr[0].toUpperCase())) {
                    set.add(arr[0].toUpperCase());
                    flag = true;
                    break;
                }
                idx += arr.length + 1;
            }
            if (!flag) {
                String[] li = s.split("");
                for (int j = 0; j < li.length; j++) {
                    if (!li[j].equals(" ") && !set.contains(li[j].toUpperCase())) {
                        set.add(li[j].toUpperCase());
                        flag = true;
                        idx = j;
                        break;
                    }
                }
            }

            String[] arr = s.split("");
            for (int j = 0; j < arr.length; j++) {
                if (j == idx && flag) {
                    System.out.print("[" + arr[j] + "]");
                }else{
                    System.out.print(arr[j]);
                }
            }
            System.out.println();
        }
    }
}