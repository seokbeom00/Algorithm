import sys
from collections import deque

sys.setrecursionlimit(1000000)

input = sys.stdin.readline
t = int(input())


def dfs(idx, tmp):
    tmp.append(idx)
    visit[idx] = True
    if s[idx] in tmp:
        return len(tmp) - tmp.index(s[idx])
    if not visit[s[idx]]:
        dfs(s[idx], tmp)
    return 0


for i in range(t):
    n = int(input())
    visit = [False] * (n + 1)
    s = deque(list(map(int, input().split())))
    s.appendleft(0)
    ans = 0
    for i in range(1, n + 1):
        if not visit[i]:
            tmp = []
            ans += dfs(i, tmp)
            print(tmp)
    print(ans)
