import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] teams = br.readLine().split(" ");

            Map<String, List<Integer>> teamMap = new HashMap<>();
            Map<String, Integer> teamCount = new HashMap<>();

            for (String s : teams) {
                if (teamCount.containsKey(s)) {
                    int tmp = teamCount.get(s);
                    teamCount.remove(s);
                    teamCount.put(s, tmp + 1);
                }else{
                    teamCount.put(s, 1);
                }
            }

            int cnt = 1;
            for (int j = 0; j < teams.length; j++) {
                if (teamMap.containsKey(teams[j]) && teamCount.get(teams[j]) > 5) {
                    teamMap.get(teams[j]).add(cnt);
                    cnt += 1;
                }else if(teamCount.get(teams[j]) > 5) {
                    teamMap.put(teams[j], new ArrayList<>());
                    teamMap.get(teams[j]).add(cnt);
                    cnt += 1;
                }
            }

            int min = Integer.MAX_VALUE;
            List<String> candidate = new ArrayList<>();
            for (String key : teamMap.keySet()) {
                if (teamMap.get(key).size() < 6) {
                    continue;
                }
                int sum = 0;
                for (int k = 0; k < 4; k++) {
                    sum += teamMap.get(key).get(k);
                }
                if (sum < min) {
                    candidate.clear();
                    candidate.add(key);
                    min = sum;
                } else if (sum == min) {
                    candidate.add(key);
                }
            }
            if (candidate.size() == 1) {
                System.out.println(candidate.get(0));
            }else{
                min = Integer.MAX_VALUE;
                String ans = "";
                for (String s : candidate) {
                    if (teamMap.get(s).get(4) < min) {
                        ans = s;
                        min = teamMap.get(s).get(4);
                    }
                }
                System.out.println(ans);
            }
        }
    }
}
