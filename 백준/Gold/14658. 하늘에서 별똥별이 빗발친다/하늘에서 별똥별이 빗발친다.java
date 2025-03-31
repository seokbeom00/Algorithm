import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, L, K;
    static List<int[]> stars = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        L = Integer.parseInt(line[2]);
        K = Integer.parseInt(line[3]);
        for (int i = 0; i < K; i++) {
            line = br.readLine().split(" ");
            stars.add(new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])});
        }
        int hit = 0;
        for (int[] star1 : stars) {
            for (int[] star2 : stars) {
                hit = Math.max(hit, check(star1[0], star2[1]));
            }
        }
        System.out.println(K - hit);
    }

    public static int check(int x, int y) {
        int hit = 0;
        for (int[] star : stars) {
            if (x <= star[0] && star[0] <= x + L && y <= star[1] && star[1] <= y + L) {
                hit++;
            }
        }
        return hit;
    }
}