import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        String[] parts = br.readLine().split(" ");
        int[] nagudo = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            nagudo[i] = Integer.parseInt(parts[i]);
        }
        List<Integer> robot = new ArrayList<>();
        boolean[] exist = new boolean[2 * n];
        while (true) {
            ans += 1;
            // 1단계
            int tmp = nagudo[2 * n - 1];
            for (int i = 2 * n - 1; i > 0; i--) {
                nagudo[i] = nagudo[i - 1];
            }
            nagudo[0] = tmp;
            boolean tmp2 = exist[2 * n - 1];
            for (int i = 2 * n - 1; i > 0; i--) {
                exist[i] = exist[i - 1];
            }
            exist[0] = tmp2;
            for (int i = robot.size() - 1; i >= 0; i--) {
                robot.set(i, robot.get(i) + 1);
                if (robot.get(i) == n - 1) {
                    exist[n - 1] = false;
                    robot.remove(i);
                }
            }
            //2단계
            boolean flag = false;
            int idx = 0;
            for (int i = 0; i < robot.size(); i++) {
                if (nagudo[robot.get(i) + 1] > 0 && !exist[robot.get(i) + 1]) {
                    exist[robot.get(i)] = false;
                    robot.set(i, robot.get(i) + 1);
                    exist[robot.get(i)] = true;
                    nagudo[robot.get(i)] -= 1;
                    if (nagudo[robot.get(i)] == 0) {
                        k -= 1;
                    }
                    if (robot.get(i) == n - 1) {
                        flag = true;
                        idx = i;
                    }
                }
            }
            if (flag) {
                robot.remove(idx);
                exist[n - 1] = false;
            }
            //3단계
            if (nagudo[0] > 0) {
                exist[0] = true;
                robot.add(0);
                nagudo[0] -= 1;
                if (nagudo[0] == 0) {
                    k -= 1;
                }
            }
            if (k <= 0) {
                br.close();
                break;
            }
        }
        System.out.println(ans);
    }
}