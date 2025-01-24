import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String[] line = br.readLine().split(" ");
        int h = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        boolean flag = false;
        if (m < 45) {
            m = m - 45 + 60;
            flag = true;
        }else{
            m -= 45;
        }
        if (h == 0 && flag) {
            h = 23;
        }else if(flag){
            h -= 1;
        }
        System.out.println(h + " " + m);
    }
}
