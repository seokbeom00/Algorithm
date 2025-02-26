import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        int h = Integer.parseInt(line[0]);
        int w = Integer.parseInt(line[1]);
        String[] parts = br.readLine().split(" ");
        int[] height = new int[parts.length];
        for (int i = 0; i < height.length; i++) {
            height[i] = Integer.parseInt(parts[i]);
        }
        int result = 0;
        for(int i = 1; i < w - 1; i++) { //인덱스 별 모이는 빗물. 첫, 마지막 제외
            int left = 0;
            int right = 0;

            for(int j = 0; j < i; j++) {
                left = Math.max(height[j], left);
            }

            for(int j = i + 1; j < w; j++) {
                right = Math.max(height[j], right);
            }

            if (height[i] < left && height[i] < right) {
                result += Math.min(left, right) - height[i];
            }
        }
        System.out.println(result);
    }
}