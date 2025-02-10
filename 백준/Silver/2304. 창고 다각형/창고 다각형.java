import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] ground = new int[n];
        int[] height = new int[n];
        List<Integer> gidung = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            gidung.add(i);
            String[] line = br.readLine().split(" ");
            ground[i] = Integer.parseInt(line[0]);
            height[i] = Integer.parseInt(line[1]);
        }

        gidung.sort((g1, g2) -> Integer.compare(height[g2], height[g1]));

        List<Integer> upperPoint = new ArrayList<>();
        int left = ground[gidung.get(0)];
        int right = ground[gidung.get(0)] + 1;
        upperPoint.add(gidung.get(0));
        for (int i = 1; i < n; i++) {
            //왼쪽에 있는 기둥
            if (ground[gidung.get(i)] < ground[gidung.get(0)]) {
                if (ground[gidung.get(i)] < left) {
                    left = ground[gidung.get(i)];
                    upperPoint.add(gidung.get(i));
                }
            }else{ // 오른쪽에 있는 기둥
                if (ground[gidung.get(i)] + 1 > right) {
                    right = ground[gidung.get(i)];
                    upperPoint.add(gidung.get(i));
                }
            }
        }

        upperPoint.sort((u1, u2) -> Integer.compare(ground[u1], ground[u2]));

        int ans = 0;
        int tmpHigh = height[upperPoint.get(0)];
        int tmpGround = ground[upperPoint.get(0)];
        for (int i = 1; i < upperPoint.size(); i++) {
            if (height[upperPoint.get(i)] == tmpHigh) {
                ans += (ground[upperPoint.get(i)] - tmpGround) * tmpHigh;
                tmpGround = ground[upperPoint.get(i)];
            } else if (height[upperPoint.get(i)] < tmpHigh) {
                ans += tmpHigh;
                tmpHigh = height[upperPoint.get(i)];
                tmpGround += 1;
                ans += (ground[upperPoint.get(i)] - tmpGround) * tmpHigh;
                tmpGround = ground[upperPoint.get(i)];
                tmpHigh = height[upperPoint.get(i)];
            } else if (height[upperPoint.get(i)] > tmpHigh) {
                ans += (ground[upperPoint.get(i)] - tmpGround) * tmpHigh;
                tmpGround = ground[upperPoint.get(i)];
                tmpHigh = height[upperPoint.get(i)];
            }
        }
        ans += tmpHigh;
        System.out.println(ans);
    }
}
