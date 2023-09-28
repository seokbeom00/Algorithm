import sys
import math

input = sys.stdin.readline

a, b = map(int, input().split())
ans = ""
i = math.gcd(a, b)
for _ in range(i):
    ans += "1"
print("1" * i)
