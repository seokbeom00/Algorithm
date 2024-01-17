import sys

input = sys.stdin.readline
n, k = map(int, input().split())
nation = []
for i in range(n):
    a, b, c, d = map(int, input().split())
    nation.append((a, b, c, d))
nation = sorted(nation, key=lambda x: (x[1], x[2], x[3]), reverse=True)
ans = []
for i in range(n):
    if (
        i != 0
        and nation[i][1] == nation[i - 1][1]
        and nation[i][2] == nation[i - 1][2]
        and nation[i][3] == nation[i - 1][3]
    ):
        ans.append(ans[len(ans) - 1])
    else:
        ans.append(len(ans) + 1)
    if nation[i][0] == k:
        print(ans[len(ans) - 1])
        break
