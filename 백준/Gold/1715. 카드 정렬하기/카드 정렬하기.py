import sys
input = sys.stdin.readline
import heapq

n = int(input())
heap = []
answer = 0
for _ in range(n):
    heapq.heappush(heap, int(input()))

while heap:
    if len(heap)>1:
        a, b = heapq.heappop(heap), heapq.heappop(heap)
        answer += a + b
        if len(heap) == 0:
            break
        heapq.heappush(heap, a+b)
    elif len(heap) == 1:
        break
print(answer)