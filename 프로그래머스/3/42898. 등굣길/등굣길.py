def solution(m, n, puddles):
    answer = 0
    board = [[0 for _ in range(m)] for _ in range(n)]
    for p in puddles:
        board[p[1]-1][p[0]-1] = -1
    flag = False
    for i in range(1, n):
        if board[i][0] == -1:
            flag = True
        elif not flag:
            board[i][0] = 1
        else:
            board[i][0] = 0
    flag = False
    for i in range(1, m):
        if board[0][i] == -1:
            flag = True
        elif not flag:
            board[0][i] = 1
        else:
            board[0][i] = 0
    for i in range(1, n):
        for j in range(1, m):
            if board[i][j] == -1:
                continue
            if board[i-1][j] == -1 and board[i][j-1] == -1:
                board[i][j] = -1
            elif board[i-1][j] == -1 and board[i][j-1] != -1:
                board[i][j] = board[i][j-1]
            elif board[i-1][j] != -1 and board[i][j-1] == -1:
                board[i][j] = board[i-1][j]
            else:
                board[i][j] = board[i-1][j] + board[i][j-1]
    print(board)
    return board[-1][-1] % 1000000007