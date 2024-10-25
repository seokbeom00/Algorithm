def solution(n, times):
    # 최소 시간은 1분, 최대 시간은 가장 오래 걸리는 심사관이 모든 사람을 심사하는 경우
    left, right = 1, max(times) * n
    answer = right
    
    while left <= right:
        mid = (left + right) // 2  # 중간 시간
        total = 0  # mid 시간 내에 심사할 수 있는 총 인원 수 계산
        
        for time in times:
            total += mid // time  # 각 심사관이 mid 시간 동안 심사할 수 있는 인원 수
        
        if total >= n:  # 심사할 수 있는 인원이 n 이상인 경우 시간을 줄임
            answer = mid  # 가능한 시간을 저장하고 더 작은 시간에서 탐색
            right = mid - 1
        else:  # 심사할 수 있는 인원이 부족한 경우 시간을 늘림
            left = mid + 1

    return answer