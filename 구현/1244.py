import sys

input = sys.stdin.readline
n = int(input())
switch = list(map(int, input().split()))
student = []
m = int(input())
for i in range(m):
    a, b = map(int, input().split())
    student.append((a, b))
for i in range(m):
    if student[i][0] == 1:  # 남자
        for j in range(n):
            if (j + 1) % student[i][1] == 0 and switch[j] == 0:
                switch[j] = 1
            elif (j + 1) % student[i][1] == 0 and switch[j] == 1:
                switch[j] = 0
    else:  # 여자
        point = student[i][1] - 1
        if switch[point] == 1:
            switch[point] = 0
        else:
            switch[point] = 1
        for j in range(1, n):
            if point - j < 0 or point + j > n - 1:
                break
            if switch[point - j] == switch[point + j]:
                if switch[point - j] == 0:
                    switch[point - j], switch[point + j] = 1, 1
                else:
                    switch[point - j], switch[point + j] = 0, 0
            else:
                break
for i in range(len(switch)):
    print(switch[i], end=" ")
    if (i + 1) % 20 == 0:
        print()
print()
