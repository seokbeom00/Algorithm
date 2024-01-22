import sys

input = sys.stdin.readline

arr = []
l, c = map(int, input().split())
arr = list(input().split())
arr.sort()
ans = []


def backtracking(check1, check2, idx):
    if check1 >= 1 and check2 >= 2 and check1 + check2 == l:
        print("".join(map(str, ans)))
        return
    for i in range(idx, c):
        if (
            arr[i] == "a"
            or arr[i] == "e"
            or arr[i] == "i"
            or arr[i] == "o"
            or arr[i] == "u"
        ):
            check1 += 1
        else:
            check2 += 1
        ans.append(arr[i])
        backtracking(check1, check2, i + 1)
        if (
            arr[i] == "a"
            or arr[i] == "e"
            or arr[i] == "i"
            or arr[i] == "o"
            or arr[i] == "u"
        ):
            check1 -= 1
        else:
            check2 -= 1
        ans.pop()


backtracking(0, 0, 0)
