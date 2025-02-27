import java.io.*;
import java.util.*;
class Solution {
    static List<List<Integer>> a_dice = new ArrayList<>();
    public int[] solution(int[][] dice) {
        int n = dice.length;
        int[] answer = new int[n/2];
        combi1(0, new ArrayList<>(), n);
        List<Integer> dice_list = new ArrayList<>();
        for(int i=0; i<n; i++){
            dice_list.add(i);
        }
        
        int max = 0;
        for(List<Integer> a : a_dice){ 
            List<Integer> b = new ArrayList<>(dice_list);
            b.removeAll(a);
            List<Integer> result1 = new ArrayList<>();
            adder(result1, a, dice, 0, n/2, 0);
            List<Integer> result2 = new ArrayList<>();
            adder(result2, b, dice, 0, n/2, 0);
            Collections.sort(result2);
            int win = 0;
            int lose = 0;
            for(int n1 : result1){
                if(n1 < result2.get(0)){
                    lose += result2.size();
                }else{
                    int left = 0;
                    int right = result2.size()-1;
                    while(left <= right){
                        int mid = (left + right) / 2;
                        if(result2.get(mid) < n1){
                            left = mid + 1;
                        }else{
                            right = mid - 1;
                        }
                    }
                    win += left;
                    lose += result2.size() - left;
                }
            }
            if(max < win){
                max = win;
                for(int i=0; i<n/2; i++){
                    answer[i] = a.get(i) + 1;
                }
            }
        }
        return answer;
    }
    
    public static void adder(List<Integer> result, List<Integer> dice_list, int[][] dice, int depth, int d, int sum){
        if(depth == d){
            result.add(sum);
            return;
        }
        for(int i=0; i<6; i++){
            adder(result, dice_list, dice, depth + 1, d, sum + dice[dice_list.get(depth)][i]);
        }
    }

    public static void combi1(int start, List<Integer> current, int n){
        if(current.size() == n/2){
            a_dice.add(new ArrayList<>(current));
            return;
        }
        for(int i=start; i<n; i++){
            current.add(i);
            combi1(i+1, current, n);
            current.remove(current.size()-1);
        }
    }
}