import sys
import heapq


input = sys.stdin.readline
n = int(input())
for _ in range(n):
    k = int(input())
    data = list(map(int, input().split()))
    heapq.heapify(data)
    ans = 0
    while len(data) > 1:
        a = heapq.heappop(data)
        b = heapq.heappop(data)
        ans += a + b
        heapq.heappush(data, a + b)
    print(ans)
