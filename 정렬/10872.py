import sys

input = sys.stdin.readline
n = int(input())


def recur(n):
    if n > 1:
        return recur(n - 1) * n
    else:
        return 1


print(recur(n))
