import sys

input = sys.stdin.readline
sys.setrecursionlimit(1000000)
n = int(input())
arr = []
for i in range(n):
    tmp = list(input())
    tmp.pop()
    arr.append(list(map(int, tmp)))
visit = [[False for _ in range(n)] for _ in range(n)]
ans = [0 for _ in range(n**2)]


def dfs(x, y, idx, visit):
    if x - 1 >= 0:
        if arr[x - 1][y] == 1 and not visit[x - 1][y]:
            visit[x - 1][y] = True
            ans[idx] += 1
            dfs(x - 1, y, idx, visit)
    if x + 1 < n:
        if arr[x + 1][y] == 1 and not visit[x + 1][y]:
            visit[x + 1][y] = True
            ans[idx] += 1
            dfs(x + 1, y, idx, visit)
    if y - 1 >= 0:
        if arr[x][y - 1] == 1 and not visit[x][y - 1]:
            visit[x][y - 1] = True
            ans[idx] += 1
            dfs(x, y - 1, idx, visit)
    if y + 1 < n:
        if arr[x][y + 1] == 1 and not visit[x][y + 1]:
            visit[x][y + 1] = True
            ans[idx] += 1
            dfs(x, y + 1, idx, visit)
    return


cnt = 0
for i in range(n):
    for j in range(n):
        if arr[i][j] == 1 and not visit[i][j]:
            ans[cnt] += 1
            visit[i][j] = True
            dfs(i, j, cnt, visit)
            cnt += 1
print(cnt)
ans = ans[:cnt]
ans.sort()
for i in ans:
    print(i)
