import sys

input = sys.stdin.readline
n = int(input())
arr = []
for i in range(n):
    a, b = map(int, input().split())
    arr.append((a, b))
arr = sorted(arr, key=lambda x: (x[1], x[0]))
for i in range(n):
    print(arr[i][0], arr[i][1])
