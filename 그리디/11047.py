import sys

input = sys.stdin.readline
n, k = map(int, input().split())
li = []
result = 0
for i in range(n):
    li.append(int(input()))
li.reverse()

for i in li:
    if k // i != 0:
        result += k // i
        k = k % i
print(result)
