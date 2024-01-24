import sys
from collections import deque

input = sys.stdin.readline
n, k = map(int, input().split())
hp = deque(list(map(int, input().split())))
robot = deque([0] * (2 * n))  # 0이 올려지는 부분이고 n-1이 끝부분


def check_zero(hp):
    count = 0
    for i in range(len(hp)):
        if hp[i] == 0:
            count += 1
    return count


def move_robot(hp, robot):
    for i in range(n - 1, 0, -1):
        if (
            hp[i] != 0 and robot[i] == 0 and robot[i - 1] == 1
        ):  # 로봇이 이동하려는 곳에 로봇이 없고 내구도가 0이 아닐때 이동
            robot[i - 1] = 0
            robot[i] = 1
            hp[i] -= 1
    if robot[n - 1] == 1:
        robot[n - 1] = 0


ans = 0
while True:
    tmp = hp.pop()
    hp.appendleft(tmp)  # 1. 컨베이어 벨트 한 칸 이동
    tmp = robot.pop()
    robot.appendleft(tmp)  # 1. 로봇도 함께 이동

    if robot[n - 1] == 1:
        robot[n - 1] = 0  # 2. 내리는 위치에 도착하면 로봇 내림
    move_robot(hp, robot)  # 3. 로봇 움직임
    if check_zero(hp) >= k:
        ans += 1
        break

    if hp[0] != 0:
        robot[0] = 1
        hp[0] -= 1
    ans += 1
    if check_zero(hp) >= k:
        break
print(ans)
