import java.util.*;
import java.io.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] arr = new int[n+1][n+1];
        for(int[] list : results){
            arr[list[0]][list[1]] = 1;
            arr[list[1]][list[0]] = -1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    if(arr[i][k] == 1 && arr[k][j] == 1 && i!=j){
                        arr[i][j] = 1;
                        arr[j][i] = -1;
                    }
                    if(arr[i][k] == -1 && arr[k][j] == -1 && i!=j){
                        arr[i][j] = -1;
                        arr[j][i] = 1;
                    }
                }
            }
        }
        for(int i=1; i<=n; i++){
            int zero_count = 0;
            for(int tmp : arr[i]){
                System.out.print(tmp + ", ");
                if(tmp == 0){
                    zero_count ++;
                }
            }
            System.out.println();
            if(zero_count == 2){
                answer += 1;
            }
        }
        return answer;
    }
}