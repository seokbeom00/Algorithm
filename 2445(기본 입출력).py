n = int(input())
origin = n-1
m = 1
for i in range(1, 2*n):
    if i<=n:
        for j in range(i):
            print("*",end="")
        for k in range(origin*2):
            print(" ", end="")
        for l in range(i):
            print("*",end="")
        origin -= 1
    else:
        for j in range(n-(i-n)):
            print("*", end="")
        for k in range(m*2):
            print(" ", end="")
        for j in range(n-(i-n)):
            print("*", end="")
        m += 1
    print()