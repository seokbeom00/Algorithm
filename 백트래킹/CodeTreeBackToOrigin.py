import sys

input = sys.stdin.readline

n = int(input())
points = [list(map(int, input().split())) for _ in range(n)]
answer = 0

def backtracking(x, y, arr, di):
    global answer
    if len(arr) == 0:
        # 모든 점을 방문한 후 원점으로 돌아갈 수 있는지 확인
        if (x == 0 and y < 0 and di != 0) or (x == 0 and y > 0 and di != 1) or (y == 0 and x < 0 and di != 2) or (y == 0 and x > 0 and di != 3):
            answer += 1
        return

    for idx in range(len(arr)):
        next_x, next_y = arr[idx]
        if di != 0 and next_x == x and next_y > y:
            tmp = arr.pop(idx)
            backtracking(next_x, next_y, arr, 0)
            arr.insert(idx, tmp)
        if di != 1 and next_x == x and next_y < y:
            tmp = arr.pop(idx)
            backtracking(next_x, next_y, arr, 1)
            arr.insert(idx, tmp)
        if di != 2 and next_y == y and next_x > x:
            tmp = arr.pop(idx)
            backtracking(next_x, next_y, arr, 2)
            arr.insert(idx, tmp)
        if di != 3 and next_y == y and next_x < x:
            tmp = arr.pop(idx)
            backtracking(next_x, next_y, arr, 3)
            arr.insert(idx, tmp)


# 원점에서 출발하여 모든 가능한 경로를 탐색
for idx in range(len(points)):
    start_x, start_y = points[idx]
    if start_x == 0:
        if start_y > 0:
            tmp = points.pop(idx)
            backtracking(start_x, start_y, points, 0)
            points.insert(idx, tmp)
        elif start_y < 0:
            tmp = points.pop(idx)
            backtracking(start_x, start_y, points, 1)
            points.insert(idx, tmp)
    elif start_y == 0:
        if start_x > 0:
            tmp = points.pop(idx)
            backtracking(start_x, start_y, points, 2)
            points.insert(idx, tmp)
        elif start_x < 0:
            tmp = points.pop(idx)
            backtracking(start_x, start_y, points, 3)
            points.insert(idx, tmp)

print(answer)