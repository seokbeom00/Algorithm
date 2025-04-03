import sys
input = sys.stdin.readline
import heapq

min_heap = []
max_heap = []


def add_number(num):
    if max_heap and num <= -max_heap[0]:
        heapq.heappush(max_heap, -num)
    else:
        heapq.heappush(min_heap, num)

    if len(max_heap) > len(min_heap) + 1:
        heapq.heappush(min_heap, -heapq.heappop(max_heap))
    if len(min_heap) > len(max_heap) + 1:
        heapq.heappush(max_heap, -heapq.heappop(min_heap))


for _ in range(int(input())):
    num = int(input())
    add_number(num)
    if len(min_heap) == len(max_heap):
        print(min(-max_heap[0], min_heap[0]))
    else:
        if len(min_heap) > len(max_heap):
            print(min_heap[0])
        elif len(max_heap) > len(min_heap):
            print(-max_heap[0])