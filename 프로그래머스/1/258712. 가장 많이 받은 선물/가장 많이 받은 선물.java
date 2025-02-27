import java.io.*;
import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> name = new HashMap<>();
        int n = friends.length;
        for(int i=0; i<n; i++){
            name.put(friends[i], i);
        }
        int[][] giftInfo = new int[n][n];
        int[] give = new int[n];
        int[] take = new int[n];
        int[] ans = new int[n];
        for(String s : gifts){
            String[] line = s.split(" ");
            String f1 = line[0], f2 = line[1];
            give[name.get(f1)] += 1;
            take[name.get(f2)] += 1;
            giftInfo[name.get(f1)][name.get(f2)] += 1;
        }
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int f1 = name.get(friends[i]);
                int f2 = name.get(friends[j]);
                int f1Tof2 = giftInfo[f1][f2];
                int f2Tof1 = giftInfo[f2][f1];
                if(f1Tof2 > f2Tof1){
                    ans[f1] += 1;
                }else if(f1Tof2 < f2Tof1){
                    ans[f2] += 1;
                }else if(f1Tof2 == f2Tof1){
                    if(give[f1] - take[f1] > give[f2] - take[f2]){
                        ans[f1] += 1;
                    }else if(give[f1] - take[f1] < give[f2] - take[f2]){
                        ans[f2] += 1;
                    }
                }
            }
        }
        for(int cnt : ans){
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
}