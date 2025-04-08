import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int sum = 0;
        int index = 0;
        while (index < truck_weights.length) {
            time++;
            if(bridge.size() == bridge_length){
                sum -= bridge.poll();
            }
            int truck = truck_weights[index];
            if(sum + truck > weight){
                bridge.offer(0);
            }else{
                bridge.offer(truck);
                sum += truck;
                index++;
            }
        }
        time += bridge_length;
        return time;
    }
}