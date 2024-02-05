import sys

input = sys.stdin.readline
t = int(input())
sys.setrecursionlimit(10000)


def dfs(arr, x, y, visit):
    if x - 1 >= 0:
        if arr[x - 1][y] == 1 and not visit[x - 1][y]:
            visit[x - 1][y] = True
            dfs(arr, x - 1, y, visit)
    if x + 1 < n:
        if arr[x + 1][y] == 1 and not visit[x + 1][y]:
            visit[x + 1][y] = True
            dfs(arr, x + 1, y, visit)
    if y - 1 >= 0:
        if arr[x][y - 1] == 1 and not visit[x][y - 1]:
            visit[x][y - 1] = True
            dfs(arr, x, y - 1, visit)
    if y + 1 < m:
        if arr[x][y + 1] == 1 and not visit[x][y + 1]:
            visit[x][y + 1] = True
            dfs(arr, x, y + 1, visit)
    return


for i in range(t):
    m, n, k = map(int, input().split())
    arr = [[0 for _ in range(m)] for _ in range(n)]
    visit = [[False for _ in range(m)] for _ in range(n)]
    ans = 0
    for j in range(k):
        x, y = map(int, input().split())
        arr[y][x] = 1
    for j in range(m):
        for l in range(n):
            if arr[l][j] == 1 and not visit[l][j]:
                dfs(arr, l, j, visit)
                ans += 1
    print(ans)
