import sys

input = sys.stdin.readline
n, m = map(int, input().split())
tree = [[] for _ in range(n + 1)]


def dfs(start, end, visit, d):
    global ans
    for t in tree[start]:
        child, distance = t[0], t[1]
        if not visit[child]:
            if child == end:
                ans = d + distance
            visit[child] = True
            dfs(child, end, visit, d + distance)


for _ in range(n - 1):
    n1, n2, d = map(int, input().split())
    tree[n1].append([n2, d])
    tree[n2].append([n1, d])
for _ in range(m):
    t1, t2 = map(int, input().split())
    ans = 0
    visit = [False] * (n + 1)
    visit[t1] = True
    dfs(t1, t2, visit, 0)
    print(ans)
