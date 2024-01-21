import sys

input = sys.stdin.readline


n, s = map(int, input().split())
arr = list(map(int, input().split()))
total = 0


def backtracking(idx, sub_sum):
    global total
    if idx > n - 1:
        return
    sub_sum += arr[idx]
    if sub_sum == s:
        total += 1
    backtracking(idx + 1, sub_sum - arr[idx])
    backtracking(idx + 1, sub_sum)


backtracking(0, 0)
print(total)
