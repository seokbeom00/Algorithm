import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] useDay = new int[progresses.length];
        for(int i=0; i<progresses.length; i++){
            int progress = 100 - progresses[i];
            int speed = speeds[i];
            useDay[i] = progress / speed;
            if(progress % speed > 0){
                useDay[i] += 1;
            }
        }
        int day = useDay[0];
        answer.add(1);
        for(int i=1; i<useDay.length; i++){
            if(useDay[i] <= day){
                answer.set(answer.size()-1, answer.get(answer.size()-1)+1);
            }else{
                day = useDay[i];
                answer.add(1);
            }
        }
        // System.out.println(Arrays.toString(useDay));
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}