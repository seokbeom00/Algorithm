import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        int tmp = arr[0];
        answer.add(tmp);
        for(int i=1; i<arr.length; i++){
            if(arr[i] != tmp){
                answer.add(arr[i]);
                tmp = arr[i];
            }
        }
        // System.out.println("Hello Java");
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}