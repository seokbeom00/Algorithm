import sys

input = sys.stdin.readline
n = int(input())
v1 = [False] * n  # 각 열의 사용유무 : y값이 index
v2 = [False] * (2 * n - 1)  # 우상단-좌하단 사용 유무 : x+y값이 index
v3 = [False] * (2 * n - 1)  # 좌상단-우하단 사용 유무 : x-y+n-1값이 index
ans = []
total = 0


def backtracking(y):
    global total
    if len(ans) == n:
        total += 1
        return
    for i in range(n):
        if v1[i] or v2[i + y] or v3[i - y + n - 1]:
            continue
        ans.append((i, y))
        v1[i] = True
        v2[i + y] = True
        v3[i - y + n - 1] = True
        backtracking(y + 1)
        v1[i] = False
        v2[i + y] = False
        v3[i - y + n - 1] = False
        ans.pop()


backtracking(0)

print(total)
