import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        int num = 1;
        
        // 행렬 초기화
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        }

        int[] answer = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int[] query = queries[q];
            int x1 = query[0] - 1; // 시작 행
            int y1 = query[1] - 1; // 시작 열
            int x2 = query[2] - 1; // 끝 행
            int y2 = query[3] - 1; // 끝 열

            int temp = map[x1][y1]; // 시작 위치 백업
            int min = temp;

            // 왼쪽 세로
            for (int i = x1; i < x2; i++) {
                map[i][y1] = map[i + 1][y1];
                min = Math.min(min, map[i][y1]);
            }

            // 아래 가로
            for (int i = y1; i < y2; i++) {
                map[x2][i] = map[x2][i + 1];
                min = Math.min(min, map[x2][i]);
            }

            // 오른쪽 세로
            for (int i = x2; i > x1; i--) {
                map[i][y2] = map[i - 1][y2];
                min = Math.min(min, map[i][y2]);
            }

            // 위 가로
            for (int i = y2; i > y1 + 1; i--) {
                map[x1][i] = map[x1][i - 1];
                min = Math.min(min, map[x1][i]);
            }

            map[x1][y1 + 1] = temp; // 백업한 값 넣기
            answer[q] = min;
        }

        return answer;
    }
}