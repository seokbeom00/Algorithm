import sys

input = sys.stdin.readline

s = list(input())
s.pop()
arr = [""] * len(s)
for i in range(len(s)):
    for j in range(i, len(s)):
        arr[i] += s[j]
arr.sort()
for i in range(len(arr)):
    print(arr[i])
