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
        light[num] = switchLight(light[num]);
        for (int i = 1; i <= light.length; i++) {
            if (num - i < 0 || num + i >= light.length) {
                break;
            }
            String left = light[num - i];
            String right = light[num + i];
            if (left.equals(right)) {
                light[num - i] = switchLight(light[num - i]);
                light[num + i] = switchLight(light[num + i]);
            }else {
                break;
            }
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

