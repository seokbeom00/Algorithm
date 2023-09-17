import sys
input = sys.stdin.readline

n = int(input())
dp = [0]*(n+1)

def rec(num):
    if dp[num] > 0:
        return dp[num]
    if num <= 1:
        dp[num] = num
        return num
    elif num == 2:
        dp[num] = 1
        return dp[num]
    else:
        dp[num] = rec(num-2) + rec(num-1)
        return dp[num]
    
print(rec(n))
