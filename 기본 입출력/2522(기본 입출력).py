n = int(input())
for i in range(1, 2*n):
    if i<=n:
        for j in range(n-i):
            print(" ", end="")
        for k in range(i):
            print("*", end="")
    else:
        for j in range(i-n):
            print(" ", end="")
        for k in range(n-(i-n)):
            print("*", end="")
    print()