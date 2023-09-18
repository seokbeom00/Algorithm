import sys
input = sys.stdin.readline

n = int(input())  # 테스트 케이스의 개수 읽기
for _ in range(n):
    m = int(input())  # n 읽기
    dp = [list(map(int, input().split())) for _ in range(2)]  # 2*n 리스트 생성
    for i in range(m):
        if i == 1:
            dp[0][1] += dp[1][0] 
            dp[1][1] += dp[0][0]
        elif i>=2:
            dp[0][i] += max(dp[1][i-1], dp[1][i-2])
            dp[1][i] += max(dp[0][i-1], dp[0][i-2])
    print(max(dp[0][m-1], dp[1][m-1]))