import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] part1 = br.readLine().split(" ");
        int[] distance = new int[part1.length];
        for (int i = 0; i < part1.length; i++) {
            distance[i] = Integer.parseInt(part1[i]);
        }
        String[] part2 = br.readLine().split(" ");
        int[] price = new int[part2.length];
        for (int i = 0; i < part2.length; i++) {
            price[i] = Integer.parseInt(part2[i]);
        }

        int min = price[0];
        int answer = min * distance[0];

        for (int i = 1; i < distance.length; i++) {
            if (price[i] < min) {
                min = price[i];
            }
            answer += min * distance[i];
        }
        System.out.println(answer);
    }
}