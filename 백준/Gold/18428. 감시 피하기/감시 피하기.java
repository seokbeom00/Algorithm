import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static String[][] board;
    static List<int[]> empty = new ArrayList<>();
    static List<int[]> teacher = new ArrayList<>();
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new String[n][n];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (board[i][j].equals("X")) {
                    empty.add(new int[]{i, j});
                } else if (board[i][j].equals("T")) {
                    teacher.add(new int[]{i, j});
                }
            }
        }

        if (canAvoid()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static boolean canAvoid() {
        return comb(0, 0, new int[3][2]);
    }

    static boolean comb(int start, int depth, int[][] selected) {
        if (depth == 3) {
            for (int[] obs : selected) {
                board[obs[0]][obs[1]] = "O";
            }

            boolean safe = checkAll();

            for (int[] obs : selected) {
                board[obs[0]][obs[1]] = "X";
            }

            return safe;
        }

        for (int i = start; i < empty.size(); i++) {
            selected[depth] = empty.get(i);
            if (comb(i + 1, depth + 1, selected)) {
                return true;
            }
        }
        return false;
    }

    static boolean checkAll() {
        for (int[] t : teacher) {
            for (int[] d : directions) {
                if (seeStudent(t[0], t[1], d)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean seeStudent(int x, int y, int[] d) {
        int nx = x;
        int ny = y;

        while (true) {
            nx += d[0];
            ny += d[1];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;
            if (board[nx][ny].equals("O")) break;
            if (board[nx][ny].equals("S")) return true;
        }

        return false;
    }
}