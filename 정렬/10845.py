import sys

input = sys.stdin.readline
qeue = []
n = int(input())
for i in range(n):
    command = list(input().split())
    if command[0] == "push":
        qeue.append(command[1])
    elif command[0] == "pop":
        if len(qeue) == 0:
            print(-1)
        else:
            print(qeue.pop(0))
    elif command[0] == "size":
        print(len(qeue))
    elif command[0] == "empty":
        if len(qeue) == 0:
            print(1)
        else:
            print(0)
    elif command[0] == "front":
        if len(qeue) == 0:
            print(-1)
        else:
            print(qeue[0])
    elif command[0] == "back":
        if len(qeue) == 0:
            print(-1)
        else:
            print(qeue[len(qeue) - 1])
