import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Set<String> vowel = new HashSet<>();
        vowel.add("a");
        vowel.add("e");
        vowel.add("i");
        vowel.add("o");
        vowel.add("u");
        while (true) {
            String str = br.readLine();
            if (str.equals("end")) {
                break;
            }
            String[] arr = str.split("");
            boolean beforeJ = false;
            boolean beforeM = false;
            int jCount = 0;
            int mCount = 0;
            boolean mFlag = false;
            boolean continueFlag = false;
            boolean three = false;
            String beforeChar = "";
            if (vowel.contains(arr[0])) {
                beforeChar = arr[0];
                beforeM = true;
                mCount = 1;
                mFlag = true;
            }else{
                beforeChar = arr[0];
                beforeJ = true;
                jCount = 1;
            }
            for (int i=1; i<arr.length; i++) {
                if (beforeChar.equals(arr[i]) && (!arr[i].equals("e") && !arr[i].equals("o"))) {
                    continueFlag = true;
                    break;
                }
                if (vowel.contains(arr[i])) {
                    mFlag = true;
                }
                if (beforeM && vowel.contains(arr[i])) {
                    mCount += 1;
                    jCount = 0;
                    beforeJ = false;
                }
                else if (beforeJ && !vowel.contains(arr[i])) {
                    jCount += 1;
                    mCount = 0;
                    beforeM = false;
                }
                else if (beforeJ && vowel.contains(arr[i])) {
                    mCount = 1;
                    jCount = 0;
                    beforeM = true;
                }
                else if (beforeM && !vowel.contains(arr[i])) {
                    jCount = 1;
                    mCount = 0;
                    beforeJ = true;
                }
                if (jCount >= 3 || mCount >= 3) {
                    three = true;
                }
                beforeChar = arr[i];
            }
            if (continueFlag || three || !mFlag) {
                System.out.println("<"+str+"> is not acceptable.");
            }else{
                System.out.println("<"+str+"> is acceptable.");
            }
        }
    }
}