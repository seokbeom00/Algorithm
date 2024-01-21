n, m = map(int, input().split())
visited = [False] * (n + 1)
ans = []


def backtracking():
    if len(ans) == m:
        print(" ".join(map(str, ans)))
        return
    for i in range(1, n + 1):
        if visited[i]:
            continue
        visited[i] = True
        ans.append(i)
        backtracking()  # 길이 되는지 체크
        visited[i] = False
        ans.pop()


backtracking()
