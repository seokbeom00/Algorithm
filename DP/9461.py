import sys
input = sys.stdin.readline

n = int(input())

dp = [0]*101
diff = [0]*101
ddiff = [0]*101
diff[0] = 0
diff[1] = 0
diff[2] = 1
diff[3] = 0
diff[4] = 1
dp[1] = 1
dp[2] = 1
dp[3] = 1
dp[4] = 2
dp[5] = 2
dp[6] = 3
for i in range(4, 98):
    ddiff[i] = diff[i-4]
    diff[i+1] = diff[i] + ddiff[i]
    dp[i+3] = dp[i+2] + diff[i+1]
for i in range(n):
    print(dp[int(input())])