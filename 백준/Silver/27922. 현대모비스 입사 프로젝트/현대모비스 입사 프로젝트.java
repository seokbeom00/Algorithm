import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        Integer[] case1 = new Integer[n];
        Integer[] case2 = new Integer[n];
        Integer[] case3 = new Integer[n];
        for (int i = 0; i < n; i++) {
            String[] scores = br.readLine().split(" ");
            int a = Integer.parseInt(scores[0]);
            int b = Integer.parseInt(scores[1]);
            int c = Integer.parseInt(scores[2]);
            case1[i] = a + b;
            case2[i] = a + c;
            case3[i] = b + c;
        }
        Arrays.sort(case1, Collections.reverseOrder());
        Arrays.sort(case2, Collections.reverseOrder());
        Arrays.sort(case3, Collections.reverseOrder());

        int answer1 = 0;
        int answer2 = 0;
        int answer3 = 0;

        for (int i = 0; i < k; i++) {
            answer1 += case1[i];
            answer2 += case2[i];
            answer3 += case3[i];
        }
        System.out.println(Math.max(Math.max(answer1, answer2), answer3));
    }
}
