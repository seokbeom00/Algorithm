import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            queue.poll();
            int tmp = queue.poll();
            queue.offer(tmp);
        }
        System.out.println(queue.poll());
    }
}