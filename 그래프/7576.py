import sys

input = sys.stdin.readline
from collections import deque

m, n = map(int, input().split())
arr = []
for i in range(n):
    arr.append(list(map(int, input().split())))
visit = [[False for _ in range(m)] for _ in range(n)]
ans = 0
di = [[1, 0], [-1, 0], [0, 1], [0, -1]]
queue = deque([])

for i in range(n):
    for j in range(m):
        if arr[i][j] == 1:
            queue.append([i, j])


def bfs(col, row):
    for i in range(4):
        x, y = col + di[i][0], row + di[i][1]
        if 0 <= x < n and 0 <= y < m:
            if arr[x][y] == 0:
                arr[x][y] = arr[col][row] + 1
                queue.append([x, y])


while queue:
    x, y = queue.popleft()
    bfs(x, y)

for i in range(n):
    for j in range(m):
        if arr[i][j] == 0:
            print(-1)
            exit(0)
        ans = max(ans, arr[i][j])
print(ans - 1)
