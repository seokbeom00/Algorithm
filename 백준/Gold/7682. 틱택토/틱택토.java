import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException{
        while (true) {
            String line = br.readLine();
            if (line.equals("end")) {
                break;
            }
            int idx = 0, x = 0, o = 0;
            String[][] board = new String[3][3];
            String[] parts = line.split("");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = parts[idx];
                    if (parts[idx].equals("X")) {
                        x += 1;
                    } else if (parts[idx].equals("O")) {
                        o += 1;
                    }
                    idx++;
                }
            }
            //X가 이기는 경우
            if (x == o + 1) {
                if (x + o == 9 && !bingo(board, "O")) {
                    ans.append("valid");
                } else if (bingo(board, "X") && !bingo(board, "O")) {
                    ans.append("valid");
                }else{
                    ans.append("invalid");
                }
            }
            //O가 이기는 경우
            else if (x == o) {
                if (!bingo(board, "X") && bingo(board, "O")) {
                    ans.append("valid");
                }else{
                    ans.append("invalid");
                }
            }
            else{
                ans.append("invalid");
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }

    public static boolean bingo(String[][] board, String s) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(s) && board[i][1].equals(s) && board[i][2].equals(s)) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(s) && board[1][i].equals(s) && board[2][i].equals(s)) {
                return true;
            }
        }
        if (board[0][0].equals(s) && board[1][1].equals(s) && board[2][2].equals(s)) {
            return true;
        }
        if (board[0][2].equals(s) && board[1][1].equals(s) && board[2][0].equals(s)) {
            return true;
        }
        return false;
    }
}
