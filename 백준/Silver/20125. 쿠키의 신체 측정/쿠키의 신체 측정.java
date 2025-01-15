import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        char[][] cookie = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                cookie[i][j] = line[j];
            }
        }
        int[] heart = new int[2];
        findHeart(cookie, n, heart);
        System.out.println((heart[0]+1) + " " + (heart[1]+1));
        int leftArm = 0;
        int rightArm = 0;
        int huri = 0;
        int leftLeg = 0;
        int rightLeg = 0;
        for (int i = heart[1]-1; i >= 0; i--) {
            if (cookie[heart[0]][i] == '*') {
                leftArm += 1;
            }else{
                break;
            }
        }
        for (int i = heart[1]+1; i < n; i++) {
            if (cookie[heart[0]][i] == '*') {
                rightArm += 1;
            }else{
                break;
            }
        }
        int x = 0;
        int y = 0;
        for (int i = heart[0]+1; i < n; i++) {
            if (cookie[i][heart[1]] == '*') {
                huri += 1;
            }else{
                x = i;
                y = heart[1];
                break;
            }
        }
        for (int i = x; i < n; i++) {
            if (cookie[i][y - 1] == '*') {
                leftLeg += 1;
            }else {
                break;
            }
        }
        for (int i = x; i < n; i++) {
            if (cookie[i][y + 1] == '*') {
                rightLeg += 1;
            }else {
                break;
            }
        }
        System.out.println(leftArm + " " + rightArm + " " + huri + " " + leftLeg + " " + rightLeg);
    }

    public static void findHeart(char[][] cookie, int n, int[] heart) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0 && j - 1 >= 0 && i + 1 < n && j + 1 < n) {
                    if (cookie[i - 1][j] == '*' && cookie[i + 1][j] == '*' && cookie[i][j - 1] == '*'
                            && cookie[i][j + 1] == '*') {
                        heart[0] = i;
                        heart[1] = j;
                        return;
                    }
                }
            }
        }
    }
}
