import sys
from copy import deepcopy
input = sys.stdin.readline
sys.setrecursionlimit(10**6)


n, m = map(int, input().split())  # 세로, 가로
board = []
for _ in range(n):
    board.append(list(input()))
    board[_].pop()

r_xy, b_xy = [0, 0], [0, 0]

for r, row in enumerate(board):
    for c, val in enumerate(row):
        if val == 'R':
            r_xy[0], r_xy[1] = r, c
        if val == 'B':
            b_xy[0], b_xy[1] = r, c


def slope_left(x, y, board, color):
    for idx in range(y - 1, -1, -1):
        if board[x][idx] == '#' or board[x][idx] == 'B' or board[x][idx] == 'R':
            if color == 'R':
                board[x][y] = '.'
                board[x][idx + 1] = 'R'
            elif color == 'B':
                board[x][y] = '.'
                board[x][idx + 1] = 'B'
            return [x, idx + 1, False]
        if board[x][idx] == 'O':
            board[x][y] = '.'
            return [x, idx + 1, True]


def slope_right(x, y, board, color):
    for idx in range(y + 1, m):
        if board[x][idx] == '#' or board[x][idx] == 'B' or board[x][idx] == 'R':
            if color == 'R':
                board[x][y] = '.'
                board[x][idx - 1] = 'R'
            elif color == 'B':
                board[x][y] = '.'
                board[x][idx - 1] = 'B'
            return [x, idx - 1, False]
        elif board[x][idx] == "O":
            board[x][y] = '.'
            return [x, idx - 1, True]


def slope_up(x, y, board, color):
    for idx in range(x - 1, -1, -1):
        if board[idx][y] == '#' or board[idx][y] == 'B' or board[idx][y] == 'R':
            if color == 'R':
                board[x][y] = '.'
                board[idx + 1][y] = 'R'
            elif color == 'B':
                board[x][y] = '.'
                board[idx + 1][y] = 'B'
            return [idx + 1, y, False]
        if board[idx][y] == 'O':
            board[x][y] = '.'
            return [idx + 1, y, True]


def slope_down(x, y, board, color):
    for idx in range(x + 1, n):
        if board[idx][y] == '#' or board[idx][y] == 'B' or board[idx][y] == 'R':
            if color == 'R':
                board[x][y] = '.'
                board[idx - 1][y] = 'R'
            elif color == 'B':
                board[x][y] = '.'
                board[idx - 1][y] = 'B'
            return [idx - 1, y, False]
        if board[idx][y] == 'O':
            board[x][y] = '.'
            return [idx - 1, y, True]


answer = 1e9


def backtrack(r_xy, b_xy, board, cnt, red_goal, blue_goal, di):
    global answer
    if red_goal and not blue_goal and cnt <= 10:
        if cnt < answer:
            answer = cnt
        return
    if cnt > 10 or blue_goal:
        return


    # 왼쪽
    if di != "LEFT" and (board[r_xy[0]][r_xy[1] - 1] != '#' or board[b_xy[0]][b_xy[1] - 1] != '#'):
        tmp_board = deepcopy(board)
        tmp_r, tmp_b = deepcopy(r_xy), deepcopy(b_xy)
        if r_xy[0] == b_xy[0]: # 같은 열에 있을 때
            if r_xy[1] < b_xy[1]:
                tmp_r = slope_left(r_xy[0], r_xy[1], tmp_board, 'R')
                tmp_b = slope_left(b_xy[0], b_xy[1], tmp_board, 'B')
            elif r_xy[1] > b_xy[1]:
                tmp_b = slope_left(b_xy[0], b_xy[1], tmp_board, 'B')
                tmp_r = slope_left(r_xy[0], r_xy[1], tmp_board, 'R')
        else:
            tmp_r = slope_left(r_xy[0], r_xy[1], tmp_board, 'R')
            tmp_b = slope_left(b_xy[0], b_xy[1], tmp_board, 'B')
        backtrack(tmp_r, tmp_b, tmp_board, cnt + 1, tmp_r[2], tmp_b[2], 'LEFT')


    # 위쪽
    if di != "UP" and (board[r_xy[0] - 1][r_xy[1]] != '#' or board[b_xy[0] - 1][b_xy[1]] != '#'):
        tmp_board = deepcopy(board)
        tmp_r, tmp_b = deepcopy(r_xy), deepcopy(b_xy)
        if r_xy[1] == b_xy[1]: #같은 행에 있을 떄
            if r_xy[0] < b_xy[0]:
                tmp_r = slope_up(r_xy[0], r_xy[1], tmp_board, 'R')
                tmp_b = slope_up(b_xy[0], b_xy[1], tmp_board, 'B')
            elif r_xy[0] > b_xy[0]:
                tmp_b = slope_up(b_xy[0], b_xy[1], tmp_board, 'B')
                tmp_r = slope_up(r_xy[0], r_xy[1], tmp_board, 'R')
        else:
            tmp_r = slope_up(r_xy[0], r_xy[1], tmp_board, 'R')
            tmp_b = slope_up(b_xy[0], b_xy[1], tmp_board, 'B')
        backtrack(tmp_r, tmp_b, tmp_board, cnt + 1, tmp_r[2], tmp_b[2], 'UP')

    # 오른쪽
    if di != 'RI' and (board[r_xy[0]][r_xy[1] + 1] != '#' or board[b_xy[0]][b_xy[1] + 1] != '#'):
        tmp_board = deepcopy(board)
        tmp_r, tmp_b = deepcopy(r_xy), deepcopy(b_xy)
        if r_xy[0] == b_xy[0]:  # 같은 열에 있을 때
            if r_xy[1] > b_xy[1]:
                tmp_r = slope_right(r_xy[0], r_xy[1], tmp_board, 'R')
                tmp_b = slope_right(b_xy[0], b_xy[1], tmp_board, 'B')
            elif r_xy[1] < b_xy[1]:
                tmp_b = slope_right(b_xy[0], b_xy[1], tmp_board, 'B')
                tmp_r = slope_right(r_xy[0], r_xy[1], tmp_board, 'R')
        else:
            tmp_r = slope_right(r_xy[0], r_xy[1], tmp_board, 'R')
            tmp_b = slope_right(b_xy[0], b_xy[1], tmp_board, 'B')
        backtrack(tmp_r, tmp_b, tmp_board, cnt + 1, tmp_r[2], tmp_b[2], 'RI')

    # 아래쪽
    if di != 'DOWN' and (board[r_xy[0] + 1][r_xy[1]] != '#' or board[b_xy[0] + 1][b_xy[1]] != '#'):
        tmp_board = deepcopy(board)
        tmp_r, tmp_b = deepcopy(r_xy), deepcopy(b_xy)
        if r_xy[1] == b_xy[1]:  # 같은 행에 있을 떄
            if r_xy[0] > b_xy[0]:
                tmp_r = slope_down(r_xy[0], r_xy[1], tmp_board, 'R')
                tmp_b = slope_down(b_xy[0], b_xy[1], tmp_board, 'B')
            elif r_xy[0] < b_xy[0]:
                tmp_b = slope_down(b_xy[0], b_xy[1], tmp_board, 'B')
                tmp_r = slope_down(r_xy[0], r_xy[1], tmp_board, 'R')
        else:
            tmp_r = slope_down(r_xy[0], r_xy[1], tmp_board, 'R')
            tmp_b = slope_down(b_xy[0], b_xy[1], tmp_board, 'B')
        backtrack(tmp_r, tmp_b, tmp_board, cnt + 1, tmp_r[2], tmp_b[2], 'DOWN')


backtrack(r_xy, b_xy, board, 0, False, False, 'START')
if answer == 1e9:
    print(-1)
else:
    print(answer)
