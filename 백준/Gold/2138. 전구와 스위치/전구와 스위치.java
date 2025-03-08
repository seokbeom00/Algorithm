import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        String origin = br.readLine();
        char[] expect = br.readLine().toCharArray();

        char[] oneStart = origin.toCharArray();
        char[] zeroStart = origin.toCharArray();
        int oneCnt = 0, zeroCnt = 0;

        if (oneStart[0] == '0') {
            switchArr(oneStart, 0);
            oneCnt += 1;
        }

        if (zeroStart[0] == '1') {
            switchArr(zeroStart, 0);
            zeroCnt += 1;
        }

        for (int i = 1; i < expect.length; i++) {
            if (oneStart[i - 1] != expect[i - 1]) {
                oneCnt += 1;
                switchArr(oneStart, i);
            }
            if (zeroStart[i - 1] != expect[i - 1]) {
                zeroCnt += 1;
                switchArr(zeroStart, i);
            }
        }
        if (oneStart[n - 1] != expect[n - 1]) {
            oneCnt = -1;
        }
        if (zeroStart[n - 1] != expect[n - 1]) {
            zeroCnt = -1;
        }
        if (oneCnt == -1 && zeroCnt == -1) {
            System.out.println(-1);
        }
        if (oneCnt == -1 && zeroCnt != -1) {
            System.out.println(zeroCnt);
        }
        if (oneCnt != -1 && zeroCnt == -1) {
            System.out.println(oneCnt);
        }
        if (oneCnt != -1 && zeroCnt != -1) {
            System.out.println(Math.min(oneCnt, zeroCnt));
        }
    }

    static public void switchArr(char[] arr, int idx) {
        if (idx == 0) {
            arr[idx] = arr[idx] == '1' ? '0' : '1';
            arr[idx + 1] = arr[idx + 1] == '1' ? '0' : '1';
        } else if (idx == arr.length - 1) {
            arr[idx] = arr[idx] == '1' ? '0' : '1';
            arr[idx - 1] = arr[idx - 1] == '1' ? '0' : '1';
        } else {
            arr[idx] = arr[idx] == '1' ? '0' : '1';
            arr[idx - 1] = arr[idx - 1] == '1' ? '0' : '1';
            arr[idx + 1] = arr[idx + 1] == '1' ? '0' : '1';
        }
    }
}
