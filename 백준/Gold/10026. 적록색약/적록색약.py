import sys
from copy import deepcopy

input = sys.stdin.readline
sys.setrecursionlimit(1000000)

n = int(input())
arr = []

for _ in range(n):
    tmp = list(input())
    tmp.pop()
    arr.append(tmp)
visit1 = [[False for _ in range(n)] for _ in range(n)]  # 정상
visit2 = [[False for _ in range(n)] for _ in range(n)]  # 색약
arr2 = deepcopy(arr)
for i in range(n):
    for j in range(n):
        if arr2[i][j] == "G":
            arr2[i][j] = "R"


def dfs(x, y, color, arr, visit):
    if x - 1 >= 0:
        if arr[x - 1][y] == color and not visit[x - 1][y]:
            visit[x - 1][y] = True
            dfs(x - 1, y, color, arr, visit)
    if x + 1 < n:
        if arr[x + 1][y] == color and not visit[x + 1][y]:
            visit[x + 1][y] = True
            dfs(x + 1, y, color, arr, visit)
    if y - 1 >= 0:
        if arr[x][y - 1] == color and not visit[x][y - 1]:
            visit[x][y - 1] = True
            dfs(x, y - 1, color, arr, visit)
    if y + 1 < n:
        if arr[x][y + 1] == color and not visit[x][y + 1]:
            visit[x][y + 1] = True
            dfs(x, y + 1, color, arr, visit)
    return


ans1 = 0
ans2 = 0

for i in range(n):
    for j in range(n):
        if not visit1[i][j]:
            visit1[i][j] = True
            dfs(i, j, arr[i][j], arr, visit1)
            ans1 += 1
        if not visit2[i][j]:
            dfs(i, j, arr2[i][j], arr2, visit2)
            visit2[i][j] = True
            ans2 += 1
print(ans1, end=" ")
print(ans2)
