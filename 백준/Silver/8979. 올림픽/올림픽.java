import java.util.*;
import java.io.*;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int[] gold = new int[n + 1];
        int[] silver = new int[n + 1];
        int[] bronze = new int[n + 1];

        List<Integer> rank = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line2 = br.readLine().split(" ");
            int nation = Integer.parseInt(line2[0]);
            int g = Integer.parseInt(line2[1]);
            int s = Integer.parseInt(line2[2]);
            int b = Integer.parseInt(line2[3]);
            gold[nation] = g;
            silver[nation] = s;
            bronze[nation] = b;
            rank.add(nation);
        }
        rank.sort((n1, n2) -> {
            int goldCompare = Integer.compare(gold[n2], gold[n1]);
            if (goldCompare != 0) {
                return goldCompare;
            }
            int silverCompare = Integer.compare(silver[n2], silver[n1]);
            if (silverCompare != 0) {
                return silverCompare;
            }
            return Integer.compare(bronze[n2], bronze[n1]);
        });
        int realRank = 1;
        for (int i = 1; i < n; i++) {
            if (gold[rank.get(i - 1)] != gold[rank.get(i)] || silver[rank.get(i - 1)] != silver[rank.get(i)] || bronze[rank.get(i - 1)] != bronze[rank.get(i)]) {
                realRank = i + 1;
            }
            if (rank.get(i) == k) {
                System.out.println(realRank);
                break;
            }
        }
    }
}