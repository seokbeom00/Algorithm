import heapq
import sys

input = sys.stdin.readline
INF = 1000000

node, edge = map(int, input().split())
# 시작 노드 정보 입력받기
start = int(input())
# 그래프 정보 초기화
graph = [[] for _ in range(node + 1)]
# 최단 거리 리스트 초기화
dmin = [INF] * (node + 1)
# 그래프 정보 입력받기
for _ in range(edge):
    # 시작 노드, 끝 노드, 가중치
    s, e, weight = map(int, input().split())
    graph[s].append((weight, s, e))
    graph[e].append((weight, e, s))


def dijkstra(start):
    PQ = graph[start]
    # start 노드에서 start 노드로 가는 거리는 0이므로
    dmin[start] = 0
    heapq.heapify(PQ)
    while PQ:
        distance, previous, next = heapq.heappop(PQ)
        if dmin[next] < 1000000:
            if dmin[next] == distance:
                print(
                    f"Edge from Node {previous} to Node {next} of Total Path Legth {dmin[next]} ADDED, Previous node {previous}"
                )
            else:
                print(
                    f"IGNORED Edge from Node {previous} to Node {next} of Total Path Legth {distance}"
                )
        else:
            cost = distance
            dmin[next] = cost
            print(
                f"Edge from Node {previous} to Node {next} of Total Path Legth {cost} selected, Previous node {previous}"
            )
            for i in graph[next]:
                heapq.heappush(PQ, (dmin[next] + i[0], i[1], i[2]))


dijkstra(start)
# 5 10
# 1
# 1 2 10
# 2 3 1
# 1 5 7
# 1 4 5
# 2 4 4
# 2 4 3
# 4 5 2
# 3 4 9
# 3 5 2
# 5 3 6
