import sys

input = sys.stdin.readline

n = int(input())
for i in range(n):
    tmp = list(input())
    tmp.pop()
    stack = []
    for j in range(len(tmp)):
        if len(stack) != 0:
            if tmp[j] == ")" and stack[len(stack) - 1] == "(" and len(stack) != 0:
                stack.pop()
            else:
                stack.append(tmp[j])
        else:
            stack.append(tmp[j])
    if len(stack) == 0:
        print("YES")
    else:
        print("NO")
