import sys

sys.setrecursionlimit(111111)

input = sys.stdin.readline
n = int(input())
ans = [0] * (n + 1)
tree = [[] for _ in range(n + 1)]
for i in range(n - 1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)


def dfs(idx):
    for i in tree[idx]:
        if ans[i] == 0:
            ans[i] = idx
            dfs(i)


dfs(1)
for i in range(2, n + 1):
    print(ans[i])
