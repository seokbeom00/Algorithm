import sys
from itertools import combinations

input = sys.stdin.readline
n = int(input())
s = []
team = set()
ans = 100000
for i in range(n):
    team.add(i)
    s.append(list(map(int, input().split())))
team1 = list(combinations(team, n // 2))

for i in range(len(team1)):
    sub1 = 0
    sub2 = 0
    tmp1 = list(combinations(team1[i], 2))
    team2 = list(team.difference(team1[i]))
    tmp2 = list(combinations(team2, 2))
    for j in range(len(tmp1)):
        sub1 += s[tmp1[j][0]][tmp1[j][1]]
        sub1 += s[tmp1[j][1]][tmp1[j][0]]
        sub2 += s[tmp2[j][0]][tmp2[j][1]]
        sub2 += s[tmp2[j][1]][tmp2[j][0]]
    ans = min(ans, abs(sub1 - sub2))
print(ans)
