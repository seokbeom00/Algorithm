import sys

input = sys.stdin.readline

while True:
    str = list(input())
    if not str:
        break
    str.pop()
    low = 0
    big = 0
    num = 0
    space = 0
    for i in range(len(str)):
        if 97 <= ord(str[i]) <= 122:
            low += 1
        elif 65 <= ord(str[i]) <= 90:
            big += 1
        elif str[i] == " ":
            space += 1
        else:
            num += 1
    print(f"{low} {big} {num} {space}", end="")
    print("")
