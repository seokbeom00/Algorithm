import java.util.*;
class Solution {
    public int solution(int k, int n, int[][] reqs) {
        List<List<Integer>> combi = new ArrayList<>();
        combination(combi, 0, n-k, new ArrayList<>(), new int[]{0, 1, 2, 3, 4}, k);
        List<List<int[]>> request = new ArrayList<>();
        for(int i=0; i<k; i++){
            request.add(new ArrayList<>());
        }
        for(int[] req : reqs){
            request.get(req[2]-1).add(new int[]{req[0], req[1]});
        }
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<combi.size(); i++){
            int[] dist = new int[k];
            for(int j=0; j<k; j++){
                dist[j] = 1;
            }
            for(int j=0; j<combi.get(i).size(); j++){
                dist[combi.get(i).get(j)] += 1;
            }
            answer = Math.min(answer, calculateTime(dist, request, k));
        }
        return answer;
    }
    
    public static int calculateTime(int[] combi, List<List<int[]>> requests, int k){
        int time = 0;
        PriorityQueue<Integer>[] heaps = new PriorityQueue[k];
        for(int i=0; i<k; i++){
            heaps[i] = new PriorityQueue<>();
        }
        for(int type = 0; type <k ; type++){
            List<int[]> request = requests.get(type);
            
            for(int[] req : request){
                int startTime = req[0];
                int duration = req[1];
                
                while(!heaps[type].isEmpty() && heaps[type].peek() <= startTime){
                    heaps[type].poll();
                }
                if(heaps[type].size() < combi[type]){
                    heaps[type].offer(startTime + duration);
                }else{
                    int earlyEnd = heaps[type].poll();
                    time += earlyEnd - startTime;
                    heaps[type].offer(earlyEnd + duration);
                }
            }
        }
        return time;
    }
    
    public static void combination(List<List<Integer>> result, int start, int r, List<Integer> current, int[] nums, int k){
        if(current.size() == r){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=start; i<k; i++){
            current.add(i);
            combination(result, i, r, current, nums, k);
            current.remove(current.size()-1);
        }
    }
}