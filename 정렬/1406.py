import sys

input = sys.stdin.readline

str = list(input())
str.pop()
left = str
right = []
n = int(input())
for i in range(n):
    command = input().split()
    if command[0] == "L":
        if len(left) != 0:
            right.append(left.pop())
    elif command[0] == "D":
        if len(right) != 0:
            left.append(right.pop(0))
    elif command[0] == "B":
        if len(left) != 0:
            left.pop()
    elif command[0] == "P":
        left.append(command[1])
answer = left + right[::-1]
print("".join(answer))
