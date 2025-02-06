import sys

input = sys.stdin.readline
n, k = map(int, input().split())
nation = []
for i in range(n):
    a, b, c, d = map(int, input().split())
    nation.append((a, b, c, d))
nation = sorted(nation, key=lambda x: (x[1], x[2], x[3]), reverse=True)
ans = [1]
if k == nation[0][0]:
    print(1)
    exit()
for i in range(1, n):
    if (
        nation[i][1] == nation[i - 1][1]
        and nation[i][2] == nation[i - 1][2]
        and nation[i][3] == nation[i - 1][3]
    ):
        ans.append(ans[len(ans) - 1])
    else:
        ans.append(len(ans) + 1)
    if nation[i][0] == k:
        print(ans[len(ans) - 1])
        break
