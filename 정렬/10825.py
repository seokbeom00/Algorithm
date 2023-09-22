import sys

input = sys.stdin.readline

n = int(input())
arr = []
for i in range(n):
    name, kr, er, ma = map(str, input().split())
    kr, er, ma = int(kr), int(er), int(ma)
    arr.append((name, kr, er, ma))
arr.sort(key=lambda x: (-x[1], x[2], -x[3], x[0]))
for i in range(n):
    print(arr[i][0])
