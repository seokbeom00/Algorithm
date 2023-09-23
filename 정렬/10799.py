import sys

input = sys.stdin.readline

arr = list(input())
arr.pop()
stack = []
laser = 0
ans = 0
for i in range(len(arr)):
    if len(stack) == 0:
        laser = 0
    if arr[i] == ")":
        stack.pop()
        if arr[i - 1] == "(":
            laser += 1
        elif arr[i - 1] == ")" and len(stack) > 0:
            ans += laser + 1
    if arr[i] == "(":
        stack.append(arr[i])
print(ans)
