n = int(input())
for i in range(n):
    for j in range(n):
        print(" ", end='')
    for j in range(n-i):
        print("*", end='')
    print()
나 메인임!!