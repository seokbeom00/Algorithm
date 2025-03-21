import java.util.*;
class Solution {
    public String solution(String s) {
        String[] line = s.split(" ");
        int[] nums = new int[line.length];
        for(int i=0; i<line.length; i++){
            nums[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(nums);
        return nums[0] + " " + nums[nums.length-1];
    }
}