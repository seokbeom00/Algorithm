import heapq as hq
import collections
import sys

input = sys.stdin.readline

# 노드의 수와 엣지의 수 입력 받음
node, edge = map(int, input().split())
# 빈 그래프 생성
graph = collections.defaultdict(list)
# index와 노드 번호를 일치시키기 위해서 1 크게 방문 리스트 생성
visit = [False] * (node + 1)
# 그래프 채우기
for i in range(edge):
    u, v, weight = map(int, input().split())  # 시작노드, 끝노드, 가중치
    graph[u].append([weight, u, v])
    graph[v].append([weight, v, u])


def prim(graph, start_node):
    visit[start_node] = True
    PQ = graph[start_node]
    # 힙큐를 이용한 우선순위 큐 생성
    hq.heapify(PQ)
    total_weiht = 0
    while PQ:
        # 루트 노드에 있는 최소 가중치 추출
        weight, u, v = hq.heappop(PQ)
        if visit[v] == False:
            visit[v] = True
            print(f"Edge from Node {u} to Node {v} of weight {weight} selected")
            total_weiht += weight
            for i in graph[v]:
                if visit[i[2]] == False:
                    hq.heappush(PQ, i)
    return total_weiht


print(f"total weight: {prim(graph, 1)}")
