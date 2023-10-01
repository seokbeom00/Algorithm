import sys
import math

input = sys.stdin.readline

n = int(input())
for i in range(n):
    arr = list(map(int, input().split()))
    ans = 0
    for j in range(1, len(arr)):
        if j == len(arr) - 1:
            break
        for k in range(j + 1, len(arr)):
            ans += math.gcd(arr[j], arr[k])
    print(ans)
