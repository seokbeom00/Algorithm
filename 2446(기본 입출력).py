n = int(input())
for i in range(1, 2*n):
    if i <= n:
        for k in range(i-1):
            print(" ", end="")
        for j in range((n-i+1)*2-1):
            print("*", end="")
        for l in range(i-1):
            print(" ", end="")
    else:
        for k in range(n-(i-n)-1):
            print(" ", end="")
        for j in range((i-n+1)*2-1):
            print("*", end="")
        for l in range(n-(i-n)-1):
            print(" ", end="")
    print()