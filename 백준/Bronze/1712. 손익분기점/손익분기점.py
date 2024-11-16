a, b, c = input().split()
a = int(a)
b = int(b)
c = int(c)
if b >= c:
    print(-1)
else:
    if a % (c - b) == 0:
        print(int(a / (c - b) + 1))
    else:
        print(int(a / (c - b) + 1))
