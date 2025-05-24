import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            List<Integer> list = new ArrayList<>();
            int[] command = commands[i];
            int start = command[0] - 1;
            int end = command[1] - 1;
            int idx = command[2] - 1;
            for(int j=start; j<=end; j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[i] = list.get(idx);
        }
        return answer;
    }
}