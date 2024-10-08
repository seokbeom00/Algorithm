import sys
import heapq

input = sys.stdin.readline

n, m, x = map(int, input().split())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    n1, n2, time = map(int, input().split())
    graph[n1].append([n2, time])


def findMinDistance(start, end):
    minDistance = [1e9] * (n + 1)
    minDistance[start] = 0
    heap = []
    heapq.heappush(heap, [minDistance[start], start])

    while heap:
        t, next = heapq.heappop(heap)
        if next == end:
            return minDistance[end]

        for i in graph[next]:
            if minDistance[i[0]] > t + i[1]:
                minDistance[i[0]] = t + i[1]
                heapq.heappush(heap, [minDistance[i[0]], i[0]])
    return 0


answer = [0] * (n + 1)

for i in range(1, n + 1):
    answer[i] = findMinDistance(i, x) + findMinDistance(x, i)  # type: ignore

print(max(answer))
