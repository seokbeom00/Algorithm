import sys
from itertools import product
from copy import deepcopy

input = sys.stdin.readline
board = []
n = int(input())
for i in range(n):
    board.append(list(map(int, input().split())))


def up(board):
    for i in range(len(board)):
        point = 0
        for j in range(1, len(board)):
            if board[point][i] == 0 and board[j][i] != 0:
                board[point][i], board[j][i] = board[j][i], board[point][i]
                continue
            if board[point][i] != 0 and board[point][i] == board[j][i]:
                board[point][i] += board[j][i]
                board[j][i] = 0
                point += 1
                continue
            if board[point][i] != 0 and board[j][i] == 0:
                continue
            if board[point][i] != 0 and board[point][i] != board[j][i]:
                point += 1
                if board[point][i] == 0:
                    board[point][i], board[j][i] = board[j][i], board[point][i]
                continue


def left(board):
    for i in range(len(board)):
        point = 0
        for j in range(1, len(board)):
            if board[i][point] == 0 and board[i][j] != 0:
                board[i][point], board[i][j] = board[i][j], board[i][point]
                continue
            if board[i][point] != 0 and board[i][point] == board[i][j]:
                board[i][point] += board[i][j]
                board[i][j] = 0
                point += 1
                continue
            if board[i][point] != 0 and board[i][j] == 0:
                continue
            if board[i][point] != 0 and board[i][point] != board[i][j]:
                point += 1
                if board[i][point] == 0:
                    board[i][point], board[i][j] = board[i][j], board[i][point]
                continue


def down(board):
    for i in range(len(board)):
        point = len(board) - 1
        for j in range(len(board) - 2, -1, -1):
            if board[point][i] == 0 and board[j][i] != 0:
                board[point][i], board[j][i] = board[j][i], board[point][i]
                continue
            if board[point][i] != 0 and board[point][i] == board[j][i]:
                board[point][i] += board[j][i]
                board[j][i] = 0
                point -= 1
                continue
            if board[point][i] != 0 and board[j][i] == 0:
                continue
            if board[point][i] != 0 and board[point][i] != board[j][i]:
                point -= 1
                if board[point][i] == 0:
                    board[point][i], board[j][i] = board[j][i], board[point][i]
                continue


def right(board):
    for i in range(len(board)):
        point = len(board) - 1
        for j in range(len(board) - 2, -1, -1):
            if board[i][point] == 0 and board[i][j] != 0:
                board[i][point], board[i][j] = board[i][j], board[i][point]
                continue
            if board[i][point] != 0 and board[i][point] == board[i][j]:
                board[i][point] += board[i][j]
                board[i][j] = 0
                point -= 1
                continue
            if board[i][point] != 0 and board[i][j] == 0:
                continue
            if board[i][point] != 0 and board[i][point] != board[i][j]:
                point -= 1
                if board[i][point] == 0:
                    board[i][point], board[i][j] = board[i][j], board[i][point]
                continue


def find_max(board):
    max = 0
    for i in range(len(board)):
        for j in range(len(board)):
            if board[i][j] > max:
                max = board[i][j]
    return max


move = ["up", "down", "left", "right"]
move = list(product(move, repeat=5))

ans = 0

for i in range(len(move)):
    tmp = deepcopy(board)
    for j in range(5):
        if move[i][j] == "up":
            up(tmp)
        elif move[i][j] == "down":
            down(tmp)
        elif move[i][j] == "right":
            right(tmp)
        elif move[i][j] == "left":
            left(tmp)
    if ans < find_max(tmp):
        ans = find_max(tmp)

print(ans)
