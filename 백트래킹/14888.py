import sys
from itertools import *

input = sys.stdin.readline
n = int(input())
num = list(map(int, input().split()))
tmp = list(map(int, input().split()))
operator = []
ans_max = -100000000
ans_min = 1000000000
for i in range(4):
    for j in range(tmp[i]):
        operator.append(i)
operator = list(permutations(operator, n - 1))

for i in range(len(operator)):
    if i == 66:
        tmp = 0
    sub = num[0]
    for j in range(n - 1):
        if operator[i][j] == 0:
            sub += num[j + 1]
        elif operator[i][j] == 1:
            sub -= num[j + 1]
        elif operator[i][j] == 2:
            sub *= num[j + 1]
        elif operator[i][j] == 3:
            if sub < 0:
                sub = ((sub * -1) // num[j + 1]) * -1
            else:
                sub //= num[j + 1]
    if ans_max < sub:
        ans_max = sub
    if ans_min > sub:
        ans_min = sub
print(ans_max)
print(ans_min)
