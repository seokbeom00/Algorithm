import sys

iuput = sys.stdin.readline

a, b, c, d = map(str, input().split())
a = a + b
c = c + d
print(int(a) + int(c))
