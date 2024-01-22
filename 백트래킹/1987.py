r, c = map(int, input().split())
arr = []
ans = 0
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
visited_eng = set()
for i in range(r):
    arr.append(list(input()))


def backtracking(path_length, x, y):
    global ans
    ans = max(ans, path_length)
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < r and 0 <= ny < c and not arr[nx][ny] in visited_eng:
            visited_eng.add(arr[nx][ny])
            backtracking(path_length + 1, nx, ny)
            visited_eng.remove(arr[nx][ny])


visited_eng.add(arr[0][0])
backtracking(1, 0, 0)
print(ans)
