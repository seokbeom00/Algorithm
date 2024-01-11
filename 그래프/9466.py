import sys
from collections import deque

input = sys.stdin.readline


def bfs(graph, visit, start):
    global total
    tmparr = []
    queue = deque([start])
    while queue:
        v = queue.popleft()
        tmparr.append(v)
        visit[v] = True
        if graph[v] == start:
            total -= len(tmparr)
            return
        if graph[v] in tmparr:
            idx = tmparr.index(graph[v])
            total -= len(tmparr) - idx
            return
        queue.append(graph[v])


t = int(input())
for i in range(t):
    n = int(input())
    total = n
    visited = [False] * (n + 1)
    graph = [0] * (n + 1)
    arr = list(map(int, input().split()))
    for j in range(len(arr)):
        graph[j + 1] = arr[j]

    for j in range(1, len(graph)):
        if not visited[j]:
            bfs(graph=graph, visit=visited, start=j)
    print(total)
