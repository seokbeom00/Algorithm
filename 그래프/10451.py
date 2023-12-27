import sys
from collections import deque

input = sys.stdin.readline


def bfs(graph, visit, start):
    queue = deque([start])
    visit[start] = True
    while queue:
        v = queue.popleft()
        visit[graph[v]] = True
        queue.append(graph[v])
        if graph[v] == start:
            return 1
    return 0


t = int(input())
for i in range(t):
    n = int(input())
    ans = 0
    visited = [False] * (n + 1)
    graph = [0] * (n + 1)
    arr = list(map(int, input().split()))
    for j in range(len(arr)):
        graph[j + 1] = arr[j]
    for j in range(1, len(graph)):
        if not visited[j]:
            ans += bfs(graph=graph, visit=visited, start=j)
    print(ans)
