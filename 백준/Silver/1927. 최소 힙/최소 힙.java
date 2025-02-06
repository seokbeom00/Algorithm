import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                minHeap.add(num);
            } else {
                if (minHeap.isEmpty()) {
                    System.out.println(0);
                }else{
                    System.out.println(minHeap.poll());
                }
            }
        }
    }
}
