import java.util.*;
class Solution {
    public int solution(int[] orders) {
        int answer = 0;
        Stack<Integer> belt = new Stack<>();
        for(int i = orders.length; i>=1; i--){
            belt.push(i);
        }
        Stack<Integer> tmp_belt = new Stack<>();
        int index = 0;
        while(index < orders.length){
            if(!belt.isEmpty() && orders[index] == belt.peek()){
                index++;
                belt.pop();
                answer++;
                continue;
            }
            if(!tmp_belt.isEmpty() && orders[index] == tmp_belt.peek()){
                index++;
                tmp_belt.pop();
                answer++;
                continue;
            }
            if(!belt.isEmpty()){
                int num = belt.pop();
                tmp_belt.push(num);
            }else{
                break;
            }
        }
        return answer;
    }
}