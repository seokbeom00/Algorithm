import java.util.*;
class Solution {
    static int[][] di = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int n;
    static List<List<int[]>> board_puzzle;
    static List<List<int[]>> table_puzzle;
    static boolean[][] visit;
    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;
        int answer = 0;
        init(game_board, 0);
        init(table, 1);
        boolean[] fill = new boolean[board_puzzle.size()];
        for(int i =0; i<board_puzzle.size(); i++){
            normalize(board_puzzle.get(i));
            sort_again(board_puzzle.get(i));
        }
        for(List<int[]> puzzle1 : table_puzzle){
            for(int i =0; i<board_puzzle.size(); i++){
                if(puzzle1.size() == board_puzzle.get(i).size() && !fill[i]){
                    sort_again(puzzle1);
                    normalize(puzzle1);
                    if(check(puzzle1, board_puzzle.get(i))){
                        answer += puzzle1.size();
                        fill[i] = true;
                        break;
                    }
                    rotate(puzzle1);
                    sort_again(puzzle1);
                    normalize(puzzle1);
                    if(check(puzzle1, board_puzzle.get(i))){
                        answer += puzzle1.size();
                        fill[i] = true;
                        break;
                    }
                    rotate(puzzle1);
                    sort_again(puzzle1);
                    normalize(puzzle1);
                    if(check(puzzle1, board_puzzle.get(i))){
                        answer += puzzle1.size();
                        fill[i] = true;
                        break;
                    }
                    rotate(puzzle1);
                    sort_again(puzzle1);
                    normalize(puzzle1);
                    if(check(puzzle1, board_puzzle.get(i))){
                        answer += puzzle1.size();
                        fill[i] = true;
                        break;
                    }
                }
            }
        }
        return answer;
    }
    static void sort_again(List<int[]> puzzle){
        puzzle.sort((p1, p2) -> {
            if(p1[0] != p2[0]){
                return Integer.compare(p1[0], p2[0]);
            }else{
                return Integer.compare(p1[1], p2[1]);
            }
        });
    }
    static boolean check(List<int[]> puzzle1, List<int[]> puzzle2){
        boolean flag = true;
        for(int i=0; i<puzzle1.size(); i++){
            if(puzzle1.get(i)[0] != puzzle2.get(i)[0] || puzzle1.get(i)[1] != puzzle2.get(i)[1]){
                flag = false;
                break;
            }
        }
        return flag;
    }
    static void normalize(List<int[]> puzzle){
        int x = puzzle.get(0)[0];
        int y = puzzle.get(0)[1];
        for(int i=0; i<puzzle.size(); i++){
            int[] arr = puzzle.get(i);
            arr[0] -= x;
            arr[1] -= y;
            puzzle.set(i, arr);
        }
    }
    static void rotate(List<int[]> puzzle){
        for(int i = 0; i < puzzle.size(); i++){
            int[] arr = puzzle.get(i);
            int x = arr[0];
            int y = arr[1];
            arr[0] = y;
            arr[1] = -x;
            puzzle.set(i, arr);
        }
    }
    static void init(int[][] board, int num){
        List<List<int[]>> puzzles = new ArrayList<>();
        visit = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visit[i][j] && board[i][j] == num){
                    visit[i][j] = true;
                    List<int[]> puzzle = make_puzzle(board, i, j, num);
                    puzzles.add(puzzle);
                }
            }
        }
        if(num == 0){
            board_puzzle = puzzles;
        }else{
            table_puzzle = puzzles;
        }
    }
    static List<int[]> make_puzzle(int[][] board, int sx, int sy, int num){
        Queue<int[]> q = new LinkedList<>();
        List<int[]> puzzle = new ArrayList<>();
        q.offer(new int[]{sx, sy});
        puzzle.add(new int[]{sx, sy});
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int x = arr[0], y = arr[1];
            for(int[] d : di){
                int dx = x + d[0], dy = y + d[1];
                if(dx < 0 || dx >= n || dy < 0 || dy >= n){
                    continue;
                }
                if(!visit[dx][dy] && board[dx][dy] == num){
                    visit[dx][dy] = true;
                    q.add(new int[]{dx, dy});
                    puzzle.add(new int[]{dx, dy});
                }
            }
        }
        return puzzle;
    }
}