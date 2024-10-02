import sys
import heapq

input = sys.stdin.readline
n = int(input())
time = []
ans = 0
for i in range(n):
    start, end = map(int, input().split())
    time.append((start, end))
time.sort()
room = []
# 힙 큐의 각 값이 각 강의실에서 제일 늦게 끝나는 강의 시간이라고 생각하면 됨
heapq.heappush(room, time[0][1])  # 힙큐로 끝나는 시간을 관리하는 거임

for i in range(1, n):
    if room[0] > time[i][0]:
        heapq.heappush(room, time[i][1])
    else:
        heapq.heappop(room)
        heapq.heappush(room, time[i][1])
print(len(room))
