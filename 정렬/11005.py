import sys

input = sys.stdin.readline
ans = []
n, m = map(int, input().split())


def recur(num):
    if num < m:
        ans.append(num)
        return 1
    else:
        ans.append(num % m)
        recur(num // m)


recur(n)
ans.reverse()
for i in range(len(ans)):
    if ans[i] >= 10:
        print(chr(ans[i] + 55), end="")
    else:
        print(ans[i], end="")
print()
