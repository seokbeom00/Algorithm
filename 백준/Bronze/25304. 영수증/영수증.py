import sys
input = sys.stdin.readline

result = int(input())
n = int(input())
tmp = 0
for _ in range(n):
    a, b = map(int, input().split())
    tmp += a * b
if tmp == result:
    print("Yes")
else:
    print("No")