import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int l = 0; l < T; l++) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]); // 팀의 갯수
            int k = Integer.parseInt(line[1]); // 문제 갯수
            int t = Integer.parseInt(line[2]); // 내 팀
            int m = Integer.parseInt(line[3]); // 로그 갯수
            int[][] solve_table = new int[n + 1][k + 1];
            List<int[]> point = new ArrayList<>();
            for (int h = 0; h < n + 1; h++) {
                point.add(new int[]{0, 0, 0}); // 점수, 제출횟수, 마지막제출시간
            }
            for (int z = 0; z < m; z++) {
                String[] line2 = br.readLine().split(" ");
                int i = Integer.parseInt(line2[0]); // 팀id
                int j = Integer.parseInt(line2[1]); // 문제번호
                int s = Integer.parseInt(line2[2]); // 획득점수
                if (solve_table[i][j] > 0) { // 푼적이 있음
                    if(solve_table[i][j] < s){
                        point.get(i)[0] = point.get(i)[0] - solve_table[i][j] + s;
                        solve_table[i][j] = s;
                    }
                }else{ // 푼적이 없음
                    point.get(i)[0] += s;
                    solve_table[i][j] = s;
                }
                point.get(i)[1] += 1;
                point.get(i)[2] = z;
            }
            List<Integer> teams = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                teams.add(i);
            }
            teams.sort((a, b) -> {
                if (point.get(b)[0] != point.get(a)[0]) { // 점수 내림차순
                    return point.get(b)[0] - point.get(a)[0];
                } else if (point.get(a)[1] != point.get(b)[1]) { // 제출 횟수 오름차순
                    return point.get(a)[1] - point.get(b)[1];
                } else { // 마지막 제출 시간 오름차순
                    return point.get(a)[2] - point.get(b)[2];
                }
            });
            // 내 팀(t)의 순위 출력
            for (int i = 0; i < teams.size(); i++) {
                if (teams.get(i) == t) {
                    System.out.println(i + 1); // 순위는 1부터 시작
                    break;
                }
            }
        }
    }
}