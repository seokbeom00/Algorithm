s = int(input())
n = 0
while s > 0:
    n += 1
    s -= n
    if s <= n:
        break
print(n)
