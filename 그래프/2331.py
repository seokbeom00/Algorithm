import sys

input = sys.stdin.readline
a, p = map(int, input().split())
arr = []
arr.append(a)
end = 0
while True:
    num = list(str(arr[len(arr) - 1]))
    b = 0
    for i in range(len(num)):
        b += int(num[i]) ** p
    if b in arr:
        end = arr.index(b)
        break
    arr.append(b)
print(end)
