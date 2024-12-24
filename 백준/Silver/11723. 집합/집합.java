import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int set = 0;
        int n = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] commands = br.readLine().split(" ");
            String command = commands[0];
            if (command.equals("all")) {
                set = (1 << 21) - 1;
            }
            else if (command.equals("empty")) {
                set = 0;
            }
            else{
                if (command.equals("add")) {
                    int val = Integer.parseInt(commands[1]);
                    set |= 1 << val;
                } else if (command.equals("remove")) {
                    int val = Integer.parseInt(commands[1]);
                    set &= ~(1 << val);
                } else if (command.equals("check")) {
                    int val = Integer.parseInt(commands[1]);
                    if ((set & (1 << val)) == 0) {
                        answer.append("0\n");
                    } else {
                        answer.append("1\n");
                    }
                } else if (command.equals("toggle")) {
                    int val = Integer.parseInt(commands[1]);
                    set ^= 1 << val;
                }
            }
        }
        System.out.println(answer);
    }
}