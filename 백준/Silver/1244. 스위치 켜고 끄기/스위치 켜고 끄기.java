import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] light = br.readLine().split(" ");
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String[] line = br.readLine().split(" ");
            int gender = Integer.parseInt(line[0]);
            int snum = Integer.parseInt(line[1]);
            if (gender == 1) {
                boy(light, snum);
            } else if(gender == 2){
                girl(light, snum - 1);
            }
        }
        for (int i = 0; i < light.length; i++) {
            System.out.print(light[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }

    public static void girl(String[] light, int num) {
        light[num] = switchLight(light[num]); // 자신 토글

        int limit = Math.min(num, light.length - 1 - num); // 대칭 범위 설정
        for (int i = 1; i <= limit; i++) {
            if (!light[num - i].equals(light[num + i])) break; // 대칭 깨지면 종료
            light[num - i] = switchLight(light[num - i]);
            light[num + i] = switchLight(light[num + i]);
        }
    }

    public static void boy(String[] light, int num) {
        for (int i = num; i <= light.length; i += num) {
            light[i - 1] = switchLight(light[i - 1]);
        }
    }

    public static String switchLight(String lightNum) {
        if (lightNum.equals("0")) {
            return "1";
        }else{
            return "0";
        }
    }
}

