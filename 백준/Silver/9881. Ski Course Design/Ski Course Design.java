import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        int answer = Integer.MAX_VALUE;
        for (int low = 0; low <= 83; low++) {
            int high = low + 17;
            int cost = 0;
            for (int h : height) {
                if (h < low) {
                    cost += (low - h) * (low - h);
                } else if (h > high) {
                    cost += (h - high) * (h - high);
                }
            }
            answer = Math.min(answer, cost);
        }

        System.out.println(answer);
    }
}