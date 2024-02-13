import sys
from collections import deque


input = sys.stdin.readline
n = int(input())
arr = []
for i in range(n):
    arr.append(list(map(int, input().split())))
di = [(1, 0), (-1, 0), (0, 1), (0, -1)]
candidate = set()


def check_bfs(mark):
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = x + di[i][0], y + di[i][1]
            if 0 <= nx < n and 0 <= ny < n:
                if arr[nx][ny] == 1:
                    queue.append([nx, ny])
                    arr[nx][ny] = mark
                if arr[nx][ny] == 0:
                    candidate.add((x, y))  # 외곽만 따로 저장


def ans_bfs(start):
    while new_queue:
        x, y, sub = new_queue.popleft()
        for i in range(4):
            nx, ny = x + di[i][0], y + di[i][1]
            if 0 <= nx < n and 0 <= ny < n:
                if arr[nx][ny] == 0 and not visit[nx][ny]:
                    new_queue.append([nx, ny, sub + 1])
                    visit[nx][ny] = True
                elif arr[nx][ny] != 0 and arr[nx][ny] != start:
                    ans.append(sub)


ans = []

mark = 1
for i in range(n):
    for j in range(n):
        if arr[i][j] == 1:
            queue = deque([])
            mark += 1
            arr[i][j] = mark
            queue.append([i, j])
            check_bfs(mark)
for i in candidate:
    visit = [[False for _ in range(n)] for _ in range(n)]
    new_queue = deque([])
    new_queue.append([i[0], i[1], 0])
    ans_bfs(arr[i[0]][i[1]])
print(min(ans))
