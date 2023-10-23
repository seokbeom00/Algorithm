import sys

input = sys.stdin.readline
a, b = map(int, input().split())
n = int(input())
m = list(map(int, input().split()))
m.reverse()
anum = 0
ans = []
for i in range(n - 1, -1, -1):
    anum += (a**i) * m[i]
while anum >= b:
    ans.append(anum % b)
    anum = anum // b
ans.append(anum)
ans.reverse()
for i in ans:
    print(i, end=" ")
print()
