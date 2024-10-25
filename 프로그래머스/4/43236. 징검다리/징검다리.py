def solution(distance, rocks, n):
    rocks.sort()  # 바위를 정렬하여 거리 계산을 쉽게 만듦
    rocks.append(distance)  # 도착 지점을 바위로 간주하여 계산

    left, right = 1, distance  # 거리의 최소, 최대 범위
    answer = 0

    while left <= right:
        mid = (left + right) // 2  # 중간 거리 값 (최소 거리 후보)
        current = 0  # 출발지점 위치
        removed_rocks = 0  # 제거한 바위 수
        min_distance = float('inf')  # 구간 거리의 최솟값 초기화
        
        # 바위 간 거리 계산
        for rock in rocks:
            diff = rock - current  # 현재 위치와 다음 바위 간 거리
            if diff < mid:  # 거리가 중간값보다 작으면 바위 제거
                removed_rocks += 1
            else:
                current = rock  # 바위를 유지하고 현재 위치를 업데이트
                min_distance = min(min_distance, diff)  # 최솟값 갱신

        if removed_rocks > n:  # 제거한 바위 수가 n보다 많으면 mid 거리 불가능
            right = mid - 1
        else:  # 제거한 바위 수가 n 이하면 mid 거리 가능
            answer = min_distance  # 가능한 거리 중 최댓값 갱신
            left = mid + 1

    return answer