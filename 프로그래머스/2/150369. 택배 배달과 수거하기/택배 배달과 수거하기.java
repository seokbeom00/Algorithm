class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliverLoad = 0;  // 배달해야 할 총 상자 개수
        int pickupLoad = 0;   // 수거해야 할 총 상자 개수

        // 1. 가장 먼 집부터 배달 및 수거 수행
        for (int i = n - 1; i >= 0; i--) {
            deliverLoad += deliveries[i];
            pickupLoad += pickups[i];

            // 2. 배달할 상자 또는 수거할 상자가 있는 경우 이동
            while (deliverLoad > 0 || pickupLoad > 0) {
                answer += (i + 1) * 2; // 왕복 거리 추가
                deliverLoad -= cap;  // 트럭이 최대한 배달
                pickupLoad -= cap;   // 트럭이 최대한 수거
            }
        }

        return answer;
    }
}