import java.util.*;

class Solution {
    class Truck{
        int weight;
        int move;
        public Truck(int weight){
            this.weight = weight;
            this.move = 1;
        }
        public void moving() {
            move++;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Truck> waiting = new LinkedList<>();
        Queue<Truck> moving = new LinkedList<>();
        
        for(int i=0; i<truck_weights.length; i++){
            waiting.offer(new Truck(truck_weights[i]));
        }
        
        int current = 0;
        while(!waiting.isEmpty() || !moving.isEmpty()){
            time++;
            
            if(moving.isEmpty()){
                Truck truck = waiting.poll();
                current = truck.weight;
                moving.offer(truck);
                continue;
            }
            
            for (Truck t : moving) {
                t.moving();
            }
            
            Truck truck = moving.peek();
            if(truck.move == bridge_length + 1){
                moving.poll();
                current -= truck.weight;
            }
            
            if(!waiting.isEmpty() && waiting.peek().weight + current <= weight){
                Truck t = waiting.poll();
                moving.offer(t);
                current += t.weight;
            }
        }

        return time;
    }
}