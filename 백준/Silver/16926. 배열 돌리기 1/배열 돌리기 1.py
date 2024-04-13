import sys
input = sys.stdin.readline
from collections import deque
n, m, r = map(int, input().split())
board = []
for i in range(n):
    board.append(list(map(int, input().split())))

depth = min(n, m) // 2
for i in range(depth):
    queue = deque()
    queue.extend(board[i][i:m-i])
    queue.extend(row[m-i-1]for row in board[i+1:n-i-1])
    queue.extend(board[n-i-1][i:m-i][::-1])
    queue.extend(row[i] for row in board[i+1:n-i-1][::-1])

    queue.rotate(-r)

    for j in range(i, m-i):
        board[i][j] = queue.popleft()
    for j in range(i+1, n-i-1):
        board[j][m-i-1] = queue.popleft()
    for j in range(m - i - 1, i - 1, -1):  # 아래쪽
        board[n - i - 1][j] = queue.popleft()
    for j in range(n - i - 2, i, -1):  # 왼쪽
        board[j][i] = queue.popleft()

for i in range(n):
    for j in range(m):
        print(board[i][j], end=' ')
    print()