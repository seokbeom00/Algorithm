import sys

input = sys.stdin.readline

arr = [0] * 26
str = list(input())
str.pop()
for x in range(len(str)):
    for j in range(97, 123):
        if str[x] == chr(j):
            arr[j - 97] += 1
for i in range(len(arr)):
    print(f"{arr[i]} ", end="")
