import sys

input = sys.stdin.readline

sys.setrecursionlimit(111111)

t = int(input())


def dfs(idx):
    global ans
    tmp.append(idx)
    visit[idx] = True
    if visit[s[idx]]:
        if s[idx] in tmp:
            ans -= len(tmp) - tmp.index(s[idx])
            return
    else:
        dfs(s[idx])


for i in range(t):
    n = int(input())
    visit = [False] * (n + 1)
    s = [0] + list(map(int, input().split()))
    ans = n
    for i in range(1, n + 1):
        if not visit[i]:
            tmp = []
            dfs(i)
    print(ans)
