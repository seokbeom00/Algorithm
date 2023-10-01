import sys
import math

input = sys.stdin.readline

a, b = map(int, input().split())
ans = ""
i = math.gcd(a, b)

print("1" * i)
