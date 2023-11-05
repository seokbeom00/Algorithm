import sys

input = sys.stdin.readline
n = int(input())


def recur(n):
    if n > 1:
        return n * recur(n - 1)
    else:
        return 1


li = list(str(recur(n)))
ans = 0
for i in range(len(li) - 1, -1, -1):
    if li[i] == "0":
        ans += 1
    else:
        break
print(ans)
