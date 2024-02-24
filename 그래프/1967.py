import sys

input = sys.stdin.readline
sys.setrecursionlimit(111111)

n = int(input())
if n == 1:
    print(0)
    exit(0)
tree = [[] for _ in range(n + 1)]
for i in range(n - 1):
    a, b, c = map(int, input().split())
    tree[a].append([b, c])
    tree[b].append([a, c])


def find(idx, dist):
    for i in tree[idx]:
        if not visit[i[0]]:
            visit[i[0]] = True
            tmp.append([i[0], dist + i[1]])
            find(i[0], dist + i[1])


def dfs(idx, sub):
    global ans
    for i in tree[idx]:
        if not visit[i[0]]:
            visit[i[0]] = True
            if ans < sub + i[0]:
                ans = sub + i[1]
            dfs(i[0], sub + i[1])


visit = [False] * (n + 1)
tmp = []
visit[1] = True
find(1, 0)
tmp.sort(reverse=True, key=lambda x: x[1])
ans = 0
visit = [False] * (n + 1)
visit[tmp[0][0]] = True
dfs(tmp[0][0], 0)
print(ans)
# 5
# 1 2 3
# 1 3 3
# 2 4 5
# 2 5 7

# 4
# 1 2 1
# 1 3 5
# 1 4 2

# 5
# 1 2 100
# 1 3 100
# 2 4 100
# 3 5 1

# 4
# 1 2 100
# 1 3 100
# 2 4 57

# 5
# 1 2 100
# 1 3 100
# 2 4 100
# 3 5 100

# 3
# 1 2 3
# 1 3 50

# 5
# 1 3 2
# 3 4 3
# 4 2 4
# 4 5 6
