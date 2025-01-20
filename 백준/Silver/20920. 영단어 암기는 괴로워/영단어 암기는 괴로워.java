import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() >= m) {
                countMap.put(word, countMap.getOrDefault(word, 0) + 1);
            }
        }

        List<String> arr = new ArrayList<>(countMap.keySet());

        arr.sort((s1, s2) -> {
            int freqCompare = Integer.compare(countMap.get(s2), countMap.get(s1));
            if (freqCompare != 0) {
                return freqCompare;
            }
            int lenCompare = Integer.compare(s2.length(), s1.length());
            if (lenCompare != 0) {
                return lenCompare;
            }
            return s1.compareTo(s2);
        });
        
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(str + "\n");
        }
        System.out.println(sb);
    }
}
