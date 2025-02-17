import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);  // 접시 수
        int d = Integer.parseInt(line[1]);  // 초밥 가짓수
        int k = Integer.parseInt(line[2]);  // 연속해서 먹을 접시 수
        int c = Integer.parseInt(line[3]);  // 쿠폰 번호

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] eat = new int[d + 1];  // 초밥 종류별 개수 저장 배열
        int count = 0;  // 현재 선택된 초밥 종류 수
        int max = 0;

        // 초기 윈도우 설정 (0 ~ k-1)
        for (int i = 0; i < k; i++) {
            if (eat[arr[i]] == 0) count++;  // 새로운 종류 등장
            eat[arr[i]]++;
        }

        // 쿠폰 초밥 추가 고려
        max = eat[c] == 0 ? count + 1 : count;

        // 슬라이딩 윈도우 시작
        for (int i = 0; i < n; i++) {
            int removeIdx = arr[i % n];  // 제거할 초밥
            int addIdx = arr[(i + k) % n];  // 새로 추가할 초밥

            // 윈도우에서 제거되는 초밥
            eat[removeIdx]--;
            if (eat[removeIdx] == 0) count--;  // 해당 초밥이 완전히 빠졌다면 종류 감소

            // 윈도우에 추가되는 초밥
            if (eat[addIdx] == 0) count++;  // 새로운 초밥 등장
            eat[addIdx]++;

            // 쿠폰 초밥 포함 여부 확인 후 최대값 업데이트
            max = Math.max(max, eat[c] == 0 ? count + 1 : count);
        }

        System.out.println(max);
    }
}