import sys
from collections import deque

input = sys.stdin.readline
n, m, s = map(int, input().split())
graph = [[] for _ in range(n + 1)]
for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
    graph[a].sort()
    graph[b].sort()
visit_d = [False] * (n + 1)
visit_b = [False] * (n + 1)


def dfs(g, node):
    visit_d[node] = True
    print(node, end=" ")
    for i in g[node]:
        if not visit_d[i]:
            dfs(g, i)


def bfs(g, node):
    queue = deque([node])
    visit_b[node] = True
    print(node, end=" ")
    while queue:
        v = queue.popleft()
        for i in g[v]:
            if not visit_b[i]:
                visit_b[i] = True
                print(i, end=" ")
                queue.append(i)


dfs(graph, s)
print()
bfs(graph, s)
print()
