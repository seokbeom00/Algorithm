import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
dp = [1]*(n+1)
for i in range(n):
    tmp = arr
    for j in range(1, i):
        if tmp[j]>tmp[j-1]:
            dp[]
            

print(dp)
print(arr)
print(dp[n-1])