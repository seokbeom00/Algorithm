import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] parts = br.readLine().split(" ");
        int p = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < p; i++) {
            String[] parts2 = br.readLine().split(" ");
            int level = Integer.parseInt(parts2[0]);
            String name = parts2[1];
            map.put(name, level);
            if (ans.isEmpty()) {
                List<String> newRoom = new ArrayList<>();
                newRoom.add(Integer.toString(level));
                newRoom.add(name);
                ans.add(newRoom);
            }else{
                boolean flag = true;
                for (int j = 0; j < ans.size(); j++) {
                    int cut = Integer.parseInt(ans.get(j).get(0));
                    if (ans.get(j).size() == m + 1) {
                        continue;
                    }
                    if (level >= cut - 10 && level <= cut + 10) {
                        ans.get(j).add(name);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    List<String> newRoom = new ArrayList<>();
                    newRoom.add(Integer.toString(level));
                    newRoom.add(name);
                    ans.add(newRoom);
                }
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i).size() == m + 1) {
                System.out.println("Started!");
            }else{
                System.out.println("Waiting!");
            }
            ans.get(i).remove(0);
            Collections.sort(ans.get(i));
            for (String s : ans.get(i)) {
                System.out.println(map.get(s) + " " + s);
            }
        }
    }
}
