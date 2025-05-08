import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int[] num = new int[8];
        PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(num[p2], num[p1]));
        for (int i = 0; i < 8; i++) {
            int point = Integer.parseInt(br.readLine());
            num[i] = point;
            pq.add(i);
        }
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int point = pq.poll();
            sum += num[point];
            list.add(point + 1);
        }
        list.sort((l1, l2) -> Integer.compare(l1, l2));
        System.out.println(sum);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
