def solution(triangle):
    if len(triangle) == 1:
        return triangle[0][0]
    for t in range(1, len(triangle)):
        triangle[t][0] += triangle[t-1][0]
        triangle[t][-1] += triangle[t-1][-1]
    if len(triangle) == 2:
        return max(triangle[1])
    for i in range(2, len(triangle)):
        for j in range(1, len(triangle[i])-1):
            triangle[i][j] += max(triangle[i-1][j], triangle[i-1][j-1])
    return max(triangle[-1])