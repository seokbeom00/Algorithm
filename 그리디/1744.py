import sys

input = sys.stdin.readline
n = int(input())
arr = []
for i in range(n):
    arr.append(int(input()))
arr = sorted(arr, reverse=True)
ans = 0
negative_part = sorted(filter(lambda x: x < 0, arr))
non_negative_index = next((i for i, x in enumerate(arr) if x < 0), len(arr))
arr = arr[:non_negative_index] + negative_part
zero_count = len([x for x in arr if x == 0])  # 0의 개수
nc = len([x for x in arr if x < 0])  # 음수의 개수
for i in range(zero_count):
    arr.remove(0)
    if nc % 2 == 1:
        if arr[len(arr) - 1] < 0:
            arr.pop()
while True:
    if 1 not in arr:
        break
    arr.remove(1)
    ans += 1

n = len(arr)
print(arr)
for i in range(0, n, 2):
    if i == n - 1:
        ans += arr[i]
        break
    a, b = arr[i], arr[i + 1]
    if a == 1 or b == 1:
        ans += a + b
    elif a > 0 and b > 0:
        ans += a * b
    elif a < 0 and b < 0:
        ans += a * b
    elif (a > 0 and b < 0) or (b > 0 and a < 0):
        ans += a + b
print(ans)
