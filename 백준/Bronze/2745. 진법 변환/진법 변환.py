import sys

input = sys.stdin.readline

n, m = map(str, input().split())
n = list(n)
m = int(m)
n.reverse()
ans = 0
for i in range(len(n)):
    if n[i].isdigit():
        ans += m**i * int(n[i])
    else:
        ans += m**i * (ord(n[i]) - 55)
print(ans)
