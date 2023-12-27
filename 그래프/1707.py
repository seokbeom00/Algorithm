import sys
from collections import deque

input = sys.stdin.readline


def isBipartite(graph, visit, start):
    queue = deque([start])
    visit[start] = 1
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if visit[i] == 0:
                queue.append(i)
                visit[i] = visit[v] * -1
            if visit[v] == visit[i]:
                return False
    return True


k = int(input())
for i in range(k):
    n, m = map(int, input().split())
    graph = [[] for _ in range(n + 1)]
    visited = [0] * (n + 1)
    for j in range(m):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)
    for j in range(1, len(graph)):
        if not visited[j]:
            result = isBipartite(graph=graph, visit=visited, start=j)
        if not result:
            break
    print("YES") if result else print("NO")
