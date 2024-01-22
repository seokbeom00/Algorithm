import sys
from copy import deepcopy

input = sys.stdin.readline
paper = []
for i in range(10):
    paper.append(list(map(int, input().split())))
type = [0, 0, 0, 0, 0]  # 크기1, 크기2, 크기3, 크기4, 크기5
ans = []


def find_one(x, y, arr, num, paper_type):
    if paper_type[num - 1] >= 5:  # 이미 해당 크기의 종이를 5개 사용한 경우
        return False
    for i in range(num):
        for j in range(num):
            if i + x > 9 or y + j > 9 or arr[i + x][j + y] == 0:
                return False
    paper_type[num - 1] += 1
    for i in range(num):
        for j in range(num):
            arr[i + x][j + y] = 0
    return True


def backtracking(x, y, arr, paper_type):
    global ans
    if all(cell == 0 for row in arr for cell in row):  # 모든 칸이 0이면 종료 조건 충족
        if not ans or sum(paper_type) < sum(ans):  # 최소한의 종이 사용으로 모든 칸을 채운 경우
            ans = paper_type[:]
        return
    if y >= 10:  # 현재 행이 끝나면 다음 행으로 이동
        backtracking(x + 1, 0, arr, paper_type)
        return

    if arr[x][y] == 0:  # 이미 채워진 칸은 건너뜀
        backtracking(x, y + 1, arr, paper_type)
    else:
        for size in range(1, 6):  # 1부터 5 크기의 종이 조각 시도
            if find_one(x, y, arr, size, paper_type):
                # 해당 크기의 종이로 채울 수 있다면, 그 상태에서 계속 백트래킹
                backtracking(x, y + size, arr, paper_type)
                # 백트래킹 후, 원래 상태로 되돌리기
                for i in range(size):
                    for j in range(size):
                        if i + x < 10 and j + y < 10:
                            arr[i + x][j + y] = 1
                paper_type[size - 1] -= 1


backtracking(0, 0, paper, type)
if not ans:
    print(-1)
else:
    print(sum(ans))
