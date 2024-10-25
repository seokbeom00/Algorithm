import sys
import heapq
input = sys.stdin.readline

n, k = map(int, input().split())
bosuk = []
bags = []
for _ in range(n):
    a, b = map(int, input().split())
    bosuk.append([a, b])
for _ in range(k):
    bags.append(int(input()))
bags.sort()
heapq.heapify(bosuk)
answer = 0
tmp = []
for bag in bags:
    while bosuk and bosuk[0][0] <= bag:
        heapq.heappush(tmp, -bosuk[0][1])
        heapq.heappop(bosuk)
    if tmp:
        answer += abs(heapq.heappop(tmp))
print(answer)