import sys
from itertools import permutations
from copy import deepcopy

input = sys.stdin.readline
paper = []
for i in range(10):
    paper.append(list(map(int, input().split())))


def find_one(x, y, num, tmp):
    for i in range(num):
        for j in range(num):
            if x + i > 9 or y + j > 9:
                return False
            if tmp[x + i][y + j] == 0:
                return False
    for i in range(num):
        for j in range(num):
            tmp[x + i][y + j] = 0
    return True


def count(num, a, b, c, d, e):
    if num == 5:
        e += 1
    elif num == 4:
        d += 1
    elif num == 3:
        c += 1
    elif num == 2:
        b += 1


def print_paper():
    for i in range(10):
        for j in range(10):
            print(paper[i][j], end=" ")
        print()


arr = [2, 3, 4, 5]
npr = list(permutations(arr, 4))
for i in npr:
    min = 100
    a, b, c, d, e = 0, 0, 0, 0, 0  # 5종류의 색종이
    tmp = deepcopy(paper)
    for j in range(10):
        for k in range(10):
            find_one(j, k, i[0], tmp)
            count(i[0], a, b, c, d, e)
    for j in range(10):
        for k in range(10):
            find_one(j, k, i[1], tmp)
            count(i[1], a, b, c, d, e)
    for j in range(10):
        for k in range(10):
            find_one(j, k, i[2], tmp)
            count(i[2], a, b, c, d, e)
    for j in range(10):
        for k in range(10):
            find_one(j, k, i[3], tmp)
            count(i[3], a, b, c, d, e)
    for j in range(10):
        for k in range(10):
            find_one(j, k, 1, tmp)
            a += 1
    if a <= 5 and b <= 5 and c <= 5 and d <= 5 and e <= 5:
        if a + b + c + d + e < min:
            min = a + b + c + d + e
if min == 100:
    print(-1)
else:
    print(min)
