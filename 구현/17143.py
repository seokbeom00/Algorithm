import sys

input = sys.stdin.readline
r, c, m = map(int, input().split())
pool = [[[] for _ in range(c)] for _ in range(r)]
shark = {}  # 크기: 행, 열, 속력, 방향 (딕셔너리로 관리)
for _ in range(m):
    a, b, n, d, e = map(int, input().split())
    shark[e] = [a - 1, b - 1, n, d]
    pool[a - 1][b - 1].append(e)  # 크기 정보로 상어를 판단


def move_shark(pool, shark, r, c):
    for key, value in shark.items():
        pool[value[0]][value[1]].remove(key)
        di = value[3]
        move = value[2]
        while True:
            if di == 1:
                if value[0] - move < 0:
                    move -= value[0]
                    value[0] = 0
                    di = 2
                else:
                    value[0] -= move
                    break
            elif di == 2:
                if value[0] + move > r - 1:
                    move -= r - 1 - value[0]
                    value[0] = r - 1
                    di = 1
                else:
                    value[0] += move
                    break
            elif di == 3:
                if value[1] + move > c - 1:
                    move -= c - 1 - value[1]
                    value[1] = c - 1
                    di = 4
                else:
                    value[1] += move
                    break
            elif di == 4:
                if value[1] - move < 0:
                    move -= value[1]
                    value[1] = 0
                    di = 3
                else:
                    value[1] -= move
                    break
        value[3] = di
        pool[value[0]][value[1]].append(key)


def remove_shark(pool, shark, r, c):
    for i in range(r):
        for j in range(c):
            if len(pool[i][j]) > 1:
                pool[i][j] = sorted(pool[i][j], reverse=True)
                for k in range(1, len(pool[i][j])):
                    del shark[pool[i][j][k]]
                pool[i][j] = [pool[i][j][0]]


ans = 0
for i in range(c):  # 1. 낚시꾼 이동
    for j in range(r):
        if len(pool[j][i]) != 0:
            ans += pool[j][i][0]
            del shark[pool[j][i][0]]  # 2. 상어 잡음
            pool[j][i] = []
            break
    move_shark(pool, shark, r, c)  # 3. 상어 움직임
    remove_shark(pool, shark, r, c)  # 4. 지금부터 서로 싸워라
print(ans)
