def min_difficulty(N, heights):
    import sys
    INF = sys.maxsize

    # DP 테이블 초기화
    dp = [[INF] * (N+1) for _ in range(N+1)]
    dp[0][0] = 0

    # DP 점화식 적용
    for i in range(N+1):
        for j in range(N+1):
            if i < N:
                dp[i+1][j] = min(dp[i+1][j], dp[i][j] + (abs(heights[i] - heights[i-1]) if i > 0 else 0))
            if j < N:
                dp[i][j+1] = min(dp[i][j+1], dp[i][j] + (abs(heights[j] - heights[j-1]) if j > 0 else 0))

    # 결과는 dp[N][N]에 있음
    return dp[N][N]

# 입력 처리
N = int(input())
heights = list(map(int, input().split()))

# 결과 출력
print(min_difficulty(N, heights))
