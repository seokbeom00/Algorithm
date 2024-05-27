import sys

input = sys.stdin.readline
n = int(input())
arr = []
for i in range(n):
    arr.append(int(input()))
arr = sorted(arr, reverse=True)
one = 0


def calcul(arr, n):
    ans = 0
    for i in range(0, n, 2):
        if i == n - 1:
            ans += arr[i]
            break
        a, b = arr[i], arr[i + 1]
        ans += a * b
    return ans


positive = sorted([x for x in arr if x > 0], reverse=True)
negative = sorted([x for x in arr if x < 0])
while True:
    if 0 not in arr:
        break
    arr.remove(0)
    if len(negative) % 2 == 1:
        negative.pop()
while True:
    if 1 not in positive:
        break
    positive.remove(1)
    one += 1
print(calcul(positive, len(positive)) + calcul(negative, len(negative)) + one)
