import sys

input = sys.stdin.readline
n = int(input())
student = []
room = [[0 for _ in range(n)] for _ in range(n)]
for i in range(n**2):
    student.append(list(map(int, input().split())))


def find_seat(like, room):
    candidate = []  # 각 칸의 정보: [좋아하는 사람수, 빈칸수, 행, 열]
    for i in range(n):
        for j in range(n):
            tmp_like = 0
            tmp_blank = 0
            if i - 1 >= 0:
                if room[i - 1][j] == 0:
                    tmp_blank += 1
                elif room[i - 1][j] in like:
                    tmp_like += 1
            if i + 1 <= n - 1:
                if room[i + 1][j] == 0:
                    tmp_blank += 1
                elif room[i + 1][j] in like:
                    tmp_like += 1
            if j - 1 >= 0:
                if room[i][j - 1] == 0:
                    tmp_blank += 1
                elif room[i][j - 1] in like:
                    tmp_like += 1
            if j + 1 <= n - 1:
                if room[i][j + 1] == 0:
                    tmp_blank += 1
                elif room[i][j + 1] in like:
                    tmp_like += 1
            if room[i][j] == 0:
                candidate.append([tmp_like, tmp_blank, i, j])
    return candidate


def print_room():
    for i in range(n):
        for j in range(n):
            print(room[i][j], end=" ")
        print()


last_seat = []
for i in range(n**2):
    seat_list = sorted(
        find_seat(student[i][1:], room), key=lambda x: (-x[0], -x[1], x[2], x[3])
    )
    if len(seat_list) == 1:
        room[seat_list[0][2]][seat_list[0][3]] = student[i][0]
        last_seat.append((seat_list[0][2], seat_list[0][3]))
    else:
        for j in range(len(seat_list) - 1):
            if (
                seat_list[j][0] != seat_list[j + 1][0]
                or seat_list[j][1] != seat_list[j + 1][1]
                or seat_list[j][2] != seat_list[j + 1][2]
                or seat_list[j][3] != seat_list[j + 1][3]
            ):
                room[seat_list[j][2]][seat_list[j][3]] = student[i][0]
                last_seat.append((seat_list[j][2], seat_list[j][3]))
                break
total = 0
for i in range(n**2):
    tmp = 0
    if last_seat[i][0] - 1 >= 0:
        if room[last_seat[i][0] - 1][last_seat[i][1]] in student[i][1:]:
            tmp += 1
    if last_seat[i][0] + 1 <= n - 1:
        if room[last_seat[i][0] + 1][last_seat[i][1]] in student[i][1:]:
            tmp += 1
    if last_seat[i][1] - 1 >= 0:
        if room[last_seat[i][0]][last_seat[i][1] - 1] in student[i][1:]:
            tmp += 1
    if last_seat[i][1] + 1 <= n - 1:
        if room[last_seat[i][0]][last_seat[i][1] + 1] in student[i][1:]:
            tmp += 1
    if tmp == 1:
        total += 1
    elif tmp == 2:
        total += 10
    elif tmp == 3:
        total += 100
    elif tmp == 4:
        total += 1000
print(total)
