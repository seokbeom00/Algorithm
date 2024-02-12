import sys

input = sys.stdin.readline
sys.setrecursionlimit(111111)

k = int(input())


def dfs(idx):
    global disable
    for i in graph[idx]:
        if mark[i] > 0:
            mark[i] = (mark[idx] + 1) * -1
            dfs(i)
        if mark[idx] == mark[i]:
            disable = True


for i in range(k):
    v, e = map(int, input().split())
    graph = [[] for _ in range(v + 1)]
    for j in range(e):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    mark = [x for x in range(v + 1)]
    disable = False
    for j in range(1, v + 1):
        if mark[j] > 0:
            mark[j] = 0
            dfs(j)
    if disable:
        print("NO")
    else:
        print("YES")
