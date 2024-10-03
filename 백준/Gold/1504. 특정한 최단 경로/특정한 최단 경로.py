import sys
import heapq

input = sys.stdin.readline

n, e = map(int, input().split())
graph = [[] for _ in range(n + 1)]
for _ in range(e):
    a, b, distance = map(int, input().split())
    graph[a].append([b, distance])
    graph[b].append([a, distance])
node1, node2 = map(int, input().split())


def findMinDistance(start, end):
    minDist = [1e9] * (n + 1)
    minDist[start] = 0
    heap = []
    heapq.heappush(heap, (minDist[start], start))

    while heap:
        distance, node = heapq.heappop(heap)
        if node == end:
            return minDist[end]
        for nodeInfo in graph[node]:
            if minDist[nodeInfo[0]] > distance + nodeInfo[1]:
                minDist[nodeInfo[0]] = distance + nodeInfo[1]
                heapq.heappush(heap, (minDist[nodeInfo[0]], nodeInfo[0]))
    print(-1)
    exit(0)


case1 = findMinDistance(1, node1) + findMinDistance(node1, node2) + findMinDistance(node2, n)
case2 = findMinDistance(1, node2) + findMinDistance(node2, node1) + findMinDistance(node1, n)
print(min(case1, case2))
