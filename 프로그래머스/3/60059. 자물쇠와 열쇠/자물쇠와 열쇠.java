import java.util.*;
class Solution {
    static int[][] board;
    static int n, m, total;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        m = key.length;
        n = lock.length;
        total = 0;
        int len = (2 * m) + n - 2;
        board = new int[len][len];
        for(int i = m - 1; i < m - 1 + n; i++){
            for(int j = m - 1; j < m - 1 + n; j++){
                board[i][j] = lock[i - m + 1][j - m + 1];
                if(board[i][j] == 0){
                    total++;
                }
            }
        }
        for(int i = 0; i <= m + n - 2; i++){
            for(int j = 0; j <= m + n - 2; j++){
                for(int rot = 0; rot<4; rot++){
                    if(match(i, j, rot, key)){
                        return true;
                    }
                }
            }
        }
        return answer;
    }
    public static boolean match(int x, int y, int rot, int[][] key){
    int cnt = 0;
    for(int i = 0; i < m; i++){
        for(int j = 0; j < m; j++){
            int keyVal = 0;
            if(rot == 0) keyVal = key[i][j];
            else if(rot == 1) keyVal = key[m - 1 - j][i];
            else if(rot == 2) keyVal = key[m - 1 - i][m - 1 - j];
            else if(rot == 3) keyVal = key[j][m - 1 - i];

            int boardX = x + i;
            int boardY = y + j;

            // 🔥 board 영역 바깥은 무시
            if(boardX < 0 || boardX >= board.length || boardY < 0 || boardY >= board.length)
                continue;

            // 🔥 lock 영역 내부에서만 검사
            if(boardX >= m - 1 && boardX < m - 1 + n &&
               boardY >= m - 1 && boardY < m - 1 + n){

                if (keyVal == 1 && board[boardX][boardY] == 0) {
                    cnt++; // 홈을 채움
                } else if (keyVal == 1 && board[boardX][boardY] == 1) {
                    return false; // 돌기끼리 충돌
                }
            }
        }
    }
    return cnt == total; // 모든 홈을 정확히 채웠는지 확인
}
    public static boolean check(int key, int lock){
        if(key == 1 && lock == 1){
            return false;
        }else if(key == 0 && lock == 0){
            return false;
        }else{
            return true;
        }
    }
}