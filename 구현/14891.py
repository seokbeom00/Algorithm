from collections import deque

a = deque((map(int, input())))
b = deque(list(map(int, input())))
c = deque(list(map(int, input())))
d = deque(list(map(int, input())))
k = int(input())
rotate = []
for i in range(k):
    rotate.append(list(map(int, input().split())))


def move(list, mode):
    if mode == 1:  # 시계방향
        tmp = list.pop()
        list.appendleft(tmp)
    elif mode == -1:  # 반시계방향
        tmp = list.popleft()
        list.append(tmp)


for i in range(k):
    if rotate[i][0] == 1:
        if a[2] != b[6]:
            if b[2] != c[6]:
                if c[2] != d[6]:
                    move(a, rotate[i][1])
                    move(b, rotate[i][1] * -1)
                    move(c, rotate[i][1])
                    move(d, rotate[i][1] * -1)
                else:
                    move(a, rotate[i][1])
                    move(b, rotate[i][1] * -1)
                    move(c, rotate[i][1])
            else:
                move(a, rotate[i][1])
                move(b, rotate[i][1] * -1)
        else:
            move(a, rotate[i][1])
    elif rotate[i][0] == 2:
        if a[2] != b[6]:
            move(a, rotate[i][1] * -1)
        if b[2] != c[6]:
            if c[2] != d[6]:
                move(b, rotate[i][1])
                move(c, rotate[i][1] * -1)
                move(d, rotate[i][1])
            else:
                move(b, rotate[i][1])
                move(c, rotate[i][1] * -1)
        else:
            move(b, rotate[i][1])
    elif rotate[i][0] == 3:
        if c[2] != d[6]:
            move(d, rotate[i][1] * -1)
        if c[6] != b[2]:
            if b[6] != a[2]:
                move(c, rotate[i][1])
                move(b, rotate[i][1] * -1)
                move(a, rotate[i][1])
            else:
                move(c, rotate[i][1])
                move(b, rotate[i][1] * -1)
        else:
            move(c, rotate[i][1])
    elif rotate[i][0] == 4:
        if d[6] != c[2]:
            if c[6] != b[2]:
                if b[6] != a[2]:
                    move(d, rotate[i][1])
                    move(c, rotate[i][1] * -1)
                    move(b, rotate[i][1])
                    move(a, rotate[i][1] * -1)
                else:
                    move(d, rotate[i][1])
                    move(c, rotate[i][1] * -1)
                    move(b, rotate[i][1])
            else:
                move(d, rotate[i][1])
                move(c, rotate[i][1] * -1)
        else:
            move(d, rotate[i][1])
ans = 0
if a[0] == 1:
    ans += 1
if b[0] == 1:
    ans += 2
if c[0] == 1:
    ans += 4
if d[0] == 1:
    ans += 8


print(ans)
