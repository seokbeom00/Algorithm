import sys

input = sys.stdin.readline
n, m = map(int, input().split())
ans = 1
if n == 2:
    if m <= 2:
        ans += 0
    elif m <= 4:
        ans += 1
    elif m <= 6:
        ans += 2
    else:
        ans += 3
elif n >= 3:
    if m >= 7:
        ans += (m - 7) + 4
    elif m >= 4:
        ans += 3
    else:
        ans += m - 1
print(ans)
