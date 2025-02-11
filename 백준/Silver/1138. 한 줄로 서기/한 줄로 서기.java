import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] leftCount = new int[n + 1];
        int[] index = new int[n + 1];
        LinkedList<Integer> ans = new LinkedList<>();
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            leftCount[i + 1] = Integer.parseInt(line[i]);
            index[i + 1] = i;
            ans.add(i + 1);
        }

        int num = 1;
        while (true) {
            if (num == n + 1) {
                num = 1;
            }
            int cnt = countLeft(index[num], ans); //현재 왼쪽에 있는 큰 숫자들 개수
            if (cnt < leftCount[num]) {
                moveRight(num, ans, leftCount[num] - cnt, index, leftCount);
            }
            num += 1;
            boolean flag = true;
            for(int i=0; i<n; i++){
                if (countLeft(index[i + 1], ans) != leftCount[i + 1]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    public static void moveRight(int num, LinkedList<Integer> ans, int goal, int[] index, int[] leftCount) {
        while (goal > 0) {
            ans.remove(index[num]);
            index[ans.get(index[num])] -= 1;
            ans.add(index[num] + 1, num);
            index[num] += 1;
            goal = leftCount[num] - countLeft(index[num], ans);
        }
    }

    public static int countLeft(int idx, LinkedList<Integer> ans) {
        int cnt = 0;
        for (int i = idx; i >= 0; i--) {
            if (ans.get(i) > ans.get(idx)) {
                cnt += 1;
            }
        }
        return cnt;
    }
}