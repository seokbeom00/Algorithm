import sys

input = sys.stdin.readline
n = int(input())
ans = ""
while n:
    if n%(-2):
        ans = '1'
