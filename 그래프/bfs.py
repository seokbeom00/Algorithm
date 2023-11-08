from collections import deque

graph = [[], [2, 3, 8], [1, 7], [1, 4, 5], [3, 5], [3, 4], [7], [2, 6, 8], [1, 7]]
visited = [False] * 9


def bfs(graph, node, visit):
    queue = deque([node])
    visit[node] = True
    while queue:
        v = queue.popleft()
        print(v)
        for i in graph[v]:
            if not visit[i]:
                queue.append(i)
                visit[i] = True


bfs(graph=graph, node=1, visit=visited)
