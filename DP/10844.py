import sys
input = sys.stdin.readline
n = int(input())
dp = [[0]*10 for _ in range(n+1)]
#dp[자릿수][해당 자릿수에서 가장 뒤에 오는 숫자] = 경우의 수

# 자릿수 1개짜리 미리 세팅
for i in range(1, 10):
    dp[1][i] = 1

# 자릿수 2이상인거 생성
for i in range(2, n+1):
    for j in range(10):
        if j == 0:
            dp[i][j] = dp[i-1][1]
        elif j == 9:
            dp[i][j] = dp[i-1][j-1]
        else:
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]

print(sum(dp[n])%1000000000)