l, n, q = map(int, input().split())  # 체스판 크기, 기사의 수, 턴 수 0:빈칸   1:함정    2:벽
board = []
knight = []  # [0]기사행    [1]기사열  [2]기사 세로   [3]기사 가로    [4]체력
command = []  #[0]기사idx   [1]상우하좌로 1칸 이동해라
hp = []
for i in range(l):
    board.append(list(map(int, input().split())))
for i in range(n):
    t1, t2, t3, t4, t5 = map(int, input().split())
    knight.append([t1 - 1, t2 - 1, t3, t4, t5])
    hp.append(t5)
for i in range(q):
    tmp1, tmp2 = map(int, input().split())
    command.append([tmp1 - 1, tmp2])


#기사 idx 넘겨주기 전에 visit에 체크하고 넘겨줘야 체크 안한다(visit에 true인 애들이 맞닿아있어서 이동해야될 기사들)
def check_touch(knight_num, knight, di, visit):  #체크할 기사idx, 기사, 방향, 체크했는지
    for i in range(len(knight)):
        if not visit[i] and knight[i][4] >= 0:  #생명이 남아있는 기사만 유효하니깐
            if di == 0:  #위 -> 아래 닿아있는지 체크
                if knight[knight_num][0] == knight[i][0] + knight[i][2]:
                    for j in range(knight[knight_num][1], knight[knight_num][1] + knight[knight_num][3]):
                        if knight[i][1] <= j < knight[i][1] + knight[i][3]:
                            visit[i] = True
                            check_touch(i, knight, di, visit)
                            break
            elif di == 2:  #아래 -> 위 닿아있는지 체크
                if knight[knight_num][0] + knight[knight_num][2] == knight[i][0]:
                    for j in range(knight[knight_num][1], knight[knight_num][1] + knight[knight_num][3]):
                        if knight[i][1] <= j < knight[i][1] + knight[i][3]:
                            visit[i] = True
                            check_touch(i, knight, di, visit)
                            break
            elif di == 1:  #오른쪽 -> 왼쪽 닿아있는지 체크
                if knight[knight_num][1] + knight[knight_num][3] == knight[i][1]:
                    for j in range(knight[knight_num][0], knight[knight_num][0] + knight[knight_num][2]):
                        if knight[i][0] <= j < knight[i][0] + knight[i][2]:
                            visit[i] = True
                            check_touch(i, knight, di, visit)
                            break
            elif di == 3:  #왼쪽 -> 오른쪽 닿아있는지 체크
                if knight[knight_num][1] == knight[i][1] + knight[i][3]:
                    for j in range(knight[knight_num][0], knight[knight_num][0] + knight[knight_num][2]):
                        if knight[i][0] <= j < knight[i][0] + knight[i][2]:
                            visit[i] = True
                            check_touch(i, knight, di, visit)
                            break


def check_wall(visit, board, knight, di):
    for i in range(len(visit)):
        if visit[i]:
            if di == 0:  #위쪽에 벽이 있거나 장외인지 체크
                if knight[i][0] - 1 < 0:
                    return False
                for j in range(knight[i][1], knight[i][1] + knight[i][3]):
                    if board[knight[i][0] - 1][j] == 2:
                        return False
            elif di == 2:  #아래쪽에 벽이 있거나 장외인지 체크
                if knight[i][0] + knight[i][2] >= len(board):
                    return False
                for j in range(knight[i][1], knight[i][1] + knight[i][3]):
                    if board[knight[i][0] + knight[i][2]][j] == 2:
                        return False
            elif di == 1:  #오른쪽에 벽이 있거나 장외인지 체크
                if knight[i][1] + knight[i][3] >= len(board):
                    return False
                for j in range(knight[i][0], knight[i][0] + knight[i][2]):
                    if board[j][knight[i][1] + knight[i][3]] == 2:
                        return False
            elif di == 3:  #왼쪽에 벽이 있거나 장외인지 체크
                if knight[i][1] - 1 < 0:
                    return False
                for j in range(knight[i][0], knight[i][0] + knight[i][2]):
                    if board[j][knight[i][1] - 1] == 2:
                        return False
    return True


def move_knight(knight, visit, di):
    for i in range(len(visit)):
        if visit[i] and knight[i][4] > 0:
            if di == 0:  #위로 이동
                knight[i][0] -= 1
            elif di == 2:  #아래로 이동
                knight[i][0] += 1
            elif di == 1:  #오른쪽으로 이동
                knight[i][1] += 1
            elif di == 3:  #왼쪽으로 이동
                knight[i][1] -= 1


def check_damage(knight, board, visit, num):
    global total
    for p in range(len(visit)):
        tmp_damage = 0
        if p == num:
            continue
        if knight[p][4] > 0 and visit[p]:
            for i in range(knight[p][0], knight[p][0] + knight[p][2]):
                for j in range(knight[p][1], knight[p][1] + knight[p][3]):
                    if board[i][j] == 1:
                        tmp_damage += 1
            knight[p][4] -= tmp_damage
            if knight[p][4] <= 0:
                total += 1

ans = 0
total = 0
for cmd in command:
    if total == len(knight):
        break
    if knight[cmd[0]][4] <= 0:  #죽은 기사는 명령받지 않음
        continue
    visit = [False] * n
    visit[cmd[0]] = True
    check_touch(cmd[0], knight, cmd[1], visit)
    can_move = check_wall(visit, board, knight, cmd[1])
    if can_move:
        move_knight(knight, visit, cmd[1])
        check_damage(knight, board, visit, cmd[0])
    # print(knight)
for i in range(n):
    if knight[i][4] > 0:
        ans += hp[i] - knight[i][4]
print(ans)