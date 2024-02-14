import sys

input = sys.stdin.readline
sys.setrecursionlimit(111111)

n = int(input())
tree = [[] for _ in range(n + 1)]
for i in range(n):
    tmp = list(map(int, input().split()))
    tmp.pop()
    for j in range(len(tmp) // 2):
        tree[tmp[0]].append([tmp[j * 2 + 1], tmp[j * 2 + 2]])


def find_node(idx, dist):
    for i in tree[idx]:
        if not visit[i[0]]:
            visit[i[0]] = True
            candidate.append([i[0], dist + i[1]])
            find_node(i[0], dist + i[1])


candidate = []
visit = [False] * (n + 1)
visit[1] = True
find_node(1, 0)


def dfs(idx, sub):
    global ans
    for i in tree[idx]:
        if not visit[i[0]]:
            visit[i[0]] = True
            if ans < sub + i[1]:
                ans = sub + i[1]
            dfs(i[0], sub + i[1])


candidate.sort(reverse=True, key=lambda x: x[1])
ans = 0
visit = [False] * (n + 1)
visit[candidate[0][0]] = True
dfs(candidate[0][0], 0)

print(ans)
