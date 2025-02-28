class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];
        dp1[1] = 1;
        if(tops[0] == 1){
            dp2[1] = 3;
        }else{
            dp2[1] = 2;
        }
        for(int i=2; i<n+1; i++){
            dp1[i] = (dp1[i-1] + dp2[i-1]) % 10007;
            if(tops[i-1] == 0){
                dp2[i] = (dp1[i-1] + dp2[i-1]*2)%10007;
            }else{
                dp2[i] = (dp1[i-1]*2 + dp2[i-1]*3)%10007;
            }
        }
        answer = (dp1[n] + dp2[n]) % 10007;
        return answer;
    }
}