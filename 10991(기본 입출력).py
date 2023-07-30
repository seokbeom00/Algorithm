n = int(input())
for i in range(1, n+1):
    for j in range(n-i):
        print(" ", end="")
    if i == n:
        for k in range(2*i-1):
            print("*",end="")
    else:
        for k in range(1, i+1):
            if k == 1 and k == i:
                print("*",end="")
            else:
                print(" ",end="")
    for l in range(n-i):
        print(" ", end="")sdfds
    print()
