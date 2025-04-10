import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((p1, p2)->Integer.compare(priorities[p2], priorities[p1]));
        Queue<Integer> numQ = new LinkedList<>();
        for(int i = 0; i< priorities.length; i++){
            q.offer(i);
            numQ.offer(i);
        }
        while(true){
            int num = numQ.poll();
            if(priorities[num] == priorities[q.peek()]){
                answer++;
                if(num == location){
                    break;
                }
                q.poll();
            }else{
                numQ.offer(num);
            }
        }
        return answer;
    }
}