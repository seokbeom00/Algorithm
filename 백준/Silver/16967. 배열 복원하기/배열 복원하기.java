import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        int H = Integer.parseInt(line[0]);
        int W = Integer.parseInt(line[1]);
        int X = Integer.parseInt(line[2]);
        int Y = Integer.parseInt(line[3]);
        int[][] arr = new int[H + X][W + Y];
        for (int i = 0; i < H + X; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < W + Y; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }
        for (int i = X; i < H + X; i++) {
            for (int j = Y; j < W + Y; j++) {
                arr[i][j] = arr[i][j] - arr[i - X][j - Y];
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
