import sys
from collections import deque

input = sys.stdin.readline
sys.setrecursionlimit(111111)

n, m = map(int, input().split())
arr = []
for i in range(n):
    tmp = list(input())
    tmp.pop()
    arr.append(list(map(int, tmp)))
di = [(1, 0), (-1, 0), (0, 1), (0, -1)]
queue = deque([])


def bfs():
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = x + di[i][0], y + di[i][1]
            if 0 <= nx < n and 0 <= ny < m:
                if arr[nx][ny] == 1:
                    arr[nx][ny] = arr[x][y] + 1
                    queue.append([nx, ny])


queue.append([0, 0])
bfs()
print(arr[n - 1][m - 1])
