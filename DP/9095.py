import sys
input = sys.stdin.readline
t = int(input())
dp = [0]*11

def rec(n):
    if n <= 2:
        dp[n] = n
        return dp[n]
    if n == 3:
        dp[n] = n+1
        return dp[n] 
    else:
        dp[n] = rec(n-3) + rec(n-2) + rec(n-1)
        return dp[n]
    
for i in range(t):
    n = int(input())
    print(rec(n))