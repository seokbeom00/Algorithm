import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
dp1 = [1]*(n)
dp2 = [1]*(n)
for i in range(n):
    for j in range(i):
        if arr[j] < arr[i] and dp1[j]>=dp1[i]:
            dp1[i]+=1
arr.reverse()
for i in range(n):
    for j in range(i):
        if arr[j] < arr[i] and dp2[j]>=dp2[i]:
            dp2[i]+=1
dp2.reverse()
ans = [0]*n
for i in range(n):
    ans[i] = dp1[i] + dp2[i] - 1

print(max(ans))