import sys
input = sys.stdin.readline

while True:
    try:
        print(input())
    except EOFError:
        break
