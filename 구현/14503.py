import sys

input = sys.stdin.readline
n, m = map(int, input().split())
r, c, d = map(int, input().split())
maps = []
for i in range(n):
    maps.append(list(map(int, input().split())))
ans = 0


def check_dust(x, y):
    if x - 1 >= 0 and maps[x - 1][y] == 0:
        return True
    if y - 1 >= 0 and maps[x][y - 1] == 0:
        return True
    if x + 1 <= n - 1 and maps[x + 1][y] == 0:
        return True
    if y + 1 <= m - 1 and maps[x][y + 1] == 0:
        return True
    return False


def move_rvc(x, y, d):
    if d == 0 and x - 1 >= 0 and maps[x - 1][y] == 0:  # 북
        x -= 1
    if d == 1 and y + 1 <= m - 1 and maps[x][y + 1] == 0:  # 동
        y += 1
    if d == 2 and x + 1 <= n - 1 and maps[x + 1][y] == 0:  # 남
        x += 1
    if d == 3 and y - 1 >= 0 and maps[x][y - 1] == 0:  # 서
        y -= 1
    return x, y


def back_rvc(x, y, d):
    if d == 2 and x - 1 >= 0 and maps[x - 1][y] != 1:  # 남 후진
        x -= 1
        return x, y
    if d == 3 and y + 1 <= m - 1 and maps[x][y + 1] != 1:  # 서 후진
        y += 1
        return x, y
    if d == 0 and x + 1 <= n - 1 and maps[x + 1][y] != 1:  # 북 후진
        x += 1
        return x, y
    if d == 1 and y - 1 >= 0 and maps[x][y - 1] != 1:  # 동 후진
        y -= 1
        return x, y
    return n + 1, m + 1


while True:
    if maps[r][c] == 0:
        maps[r][c] = 2
        ans += 1

    if check_dust(r, c):  # 먼지 있는 경우
        if d == 0:
            d = 3
        elif d == 1:
            d = 0
        elif d == 2:
            d = 1
        elif d == 3:
            d = 2
        r, c = move_rvc(r, c, d)
    else:
        r, c = back_rvc(r, c, d)
        if r == n + 1 and c == m + 1:
            break
print(ans)
