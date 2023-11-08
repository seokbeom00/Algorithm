import sys
from collections import deque

input = sys.stdin.readline
n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
visit = [False] * (n + 1)


def bfs(graph, node):
    visit[node] = True
    queue = deque([node])
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visit[i]:
                queue.append(i)
                visit[i] = True


result = 0

for i in range(1, len(visit)):
    if not visit[i]:
        bfs(graph, i)
        result += 1
print(result)
