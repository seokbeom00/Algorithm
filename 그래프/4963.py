import sys

input = sys.stdin.readline
sys.setrecursionlimit(111111)

di = [(1, 0), (-1, 0), (0, -1), (0, 1), (1, 1), (1, -1), (-1, 1), (-1, -1)]


def dfs(row, col):
    for i in range(8):
        x, y = row + di[i][0], col + di[i][1]
        if 0 <= x < h and 0 <= y < w:
            if arr[x][y] == 1 and not visit[x][y]:
                visit[x][y] = True
                dfs(x, y)


while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    arr = []
    visit = [[False for _ in range(w)] for _ in range(h)]
    for _ in range(h):
        arr.append(list(map(int, input().split())))
    tmp = 0
    for i in range(h):
        for j in range(w):
            if arr[i][j] == 1 and not visit[i][j]:
                visit[i][j] = True
                dfs(i, j)
                tmp += 1
    print(tmp)
