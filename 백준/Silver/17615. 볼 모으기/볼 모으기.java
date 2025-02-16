import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] balls = br.readLine().split("");

        String leftColor = balls[0];
        int leftCnt = 0;
        String rightColor = balls[n - 1];
        int rightCnt = 0;

        int red = 0;
        int blue = 0;

        String curColor = leftColor;
        int curCnt = 0;
        int switchCnt = 0;
        for (String s : balls) {
            if (!s.equals(curColor)) {
                if (switchCnt == 0) {
                    leftCnt = curCnt;
                } else if (curColor.equals("R")) {
                    red += curCnt;
                } else if (curColor.equals("B")) {
                    blue += curCnt;
                }
                curColor = s;
                curCnt = 1;
                switchCnt += 1;
            }else{
                curCnt += 1;
            }
        }
        rightCnt = curCnt;
        if (switchCnt == 0) {
            System.out.println(0);
        }else{
            if (leftColor.equals("R") && rightColor.equals("R")) {
                red += Math.min(leftCnt, rightCnt);
            } else if (leftColor.equals("B") && rightColor.equals("B")) {
                blue += Math.min(leftCnt, rightCnt);
            }
            System.out.println(Math.min(red, blue));
        }
    }
}