import sys
from copy import deepcopy

input = sys.stdin.readline
n, m = map(int, input().split())
water = []
command = []
for i in range(n):
    water.append(list(map(int, input().split())))
for i in range(m):
    command.append(list(map(int, input().split())))
dx = [0, 0, -1, -1, -1, 0, 1, 1, 1]
dy = [0, -1, -1, 0, 1, 1, 1, 0, -1]


def move(cloud, direction, length):  # 구름 배열, 방향, 움직일 거리
    for i in range(len(cloud)):
        cloud[i] = [
            (cloud[i][0] + dx[direction] * length) % n,
            (cloud[i][1] + dy[direction] * length) % n,
        ]
        water[cloud[i][0]][cloud[i][1]] += 1


def check(water, x, y):
    cnt = 0
    if x - 1 >= 0 and y - 1 >= 0:
        if water[x - 1][y - 1] >= 1:
            cnt += 1
    if x - 1 >= 0 and y + 1 <= n - 1:
        if water[x - 1][y + 1] >= 1:
            cnt += 1
    if x + 1 <= n - 1 and y - 1 >= 0:
        if water[x + 1][y - 1] >= 1:
            cnt += 1
    if x + 1 <= n - 1 and y + 1 <= n - 1:
        if water[x + 1][y + 1] >= 1:
            cnt += 1
    return cnt


def create_cloud(water, cloud):
    c = []
    for i in range(n):
        for j in range(n):
            if water[i][j] >= 2:
                if [i, j] not in cloud:
                    c.append([i, j])
                    water[i][j] -= 2
    return c


cloud = [[n - 1, 0], [n - 1, 1], [n - 2, 0], [n - 2, 1]]  # 최초 구름 생성
for i in range(m):
    move(cloud, command[i][0], command[i][1])  # 구름 이동
    for j in range(len(cloud)):
        water[cloud[j][0]][cloud[j][1]] += check(
            water, cloud[j][0], cloud[j][1]
        )  # 대각선 물의 수 만큼 물 양 증가
    cloud = create_cloud(water, cloud)
ans = 0
for i in range(n):
    for j in range(n):
        ans += water[i][j]
print(ans)
