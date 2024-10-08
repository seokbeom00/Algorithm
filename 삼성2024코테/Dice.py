import sys

input = sys.stdin.readline
from collections import deque
sys.setrecursionlimit(10**6)

n, m = map(int, input().split())
board = []
direction = [(-1, 0), (0, 1), (1, 0), (0, -1)]  # 상 우 하 좌
di = 1
for _ in range(n):
    board.append(list(map(int, input().split())))

leftAndRight = deque([6, 3, 1, 4])
upAndDown = deque([6, 2, 1, 5])
x, y = 0, 0
ans = 0


def rollDice():
    global di, x, y
    x, y = direction[di][0] + x, direction[di][1] + y
    if 0 > x or 0 > y or n <= x or n <= y:
        if di == 0:
            di = 2
            x += 2
        elif di == 2:
            di = 0
            x -= 2
        elif di == 1:
            di = 3
            y -= 2
        elif di == 3:
            di = 1
            y += 2
    if di == 0:  # 위쪽으로 구르고 있는 경우
        tmp = upAndDown.pop()
        upAndDown.appendleft(tmp)
        leftAndRight[0], leftAndRight[2] = upAndDown[0], upAndDown[2]
    elif di == 1:  # 오른쪽으로 구르고 있는 경우
        tmp = leftAndRight.popleft()
        leftAndRight.append(tmp)
        upAndDown[0], upAndDown[2] = leftAndRight[0], leftAndRight[2]
    elif di == 2:  # 아래쪽으로 구르고 있는 경우
        tmp = upAndDown.popleft()
        upAndDown.append(tmp)
        leftAndRight[0], leftAndRight[2] = upAndDown[0], upAndDown[2]
    elif di == 3:  # 왼쪽으로 구르고 있는 경우
        tmp = leftAndRight.pop()
        leftAndRight.appendleft(tmp)
        upAndDown[0], upAndDown[2] = leftAndRight[0], leftAndRight[2]


def dfs(tmp_x, tmp_y, target, visit):
    global ans

    visit[tmp_x][tmp_y] = True
    for d in direction:
        dx, dy = tmp_x + d[0], tmp_y + d[1]
        if 0 <= dx < n and 0 <= dy < n:
            if not visit[dx][dy] and board[dx][dy] == target:
                visit[dx][dy] = True
                ans += target
                dfs(dx, dy, target, visit)


for _ in range(m):
    rollDice()
    visited = [[False for _ in range(n)] for _ in range(n)]
    ans += board[x][y]
    dfs(x, y, board[x][y], visited)
    if board[x][y] < leftAndRight[0]:
        di += 1
        if di == 4:
            di = 0
    elif board[x][y] > leftAndRight[0]:
        di -= 1
        if di == -1:
            di = 3
print(ans)
