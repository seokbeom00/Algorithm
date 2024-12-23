import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        String[] lines = br.readLine().split("");
        int[] alphabet = new int[26];
        for (int i = 0; i < lines.length; i++) {
            char ch = lines[i].charAt(0);
            int num = (int) ch;
            if (num > 90) {
                num -= 32;
            }
            alphabet[num - 65] += 1;
        }
        int maxValue = 0;
        int maxCount = 1;
        for (int i = 1; i < 26; i++) {
            if (alphabet[i] == alphabet[maxValue]) {
                maxCount += 1;
            } else if (alphabet[i] > alphabet[maxValue]) {
                maxValue = i;
                maxCount = 1;
            }
        }
        if (maxCount == 1) {
            System.out.println((char) (maxValue + 65));
        } else {
            System.out.println("?");
        }

    }
}
