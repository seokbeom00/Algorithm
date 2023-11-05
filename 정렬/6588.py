import sys

input = sys.stdin.readline
list = []
for i in range(2, 1000000 + 1):
    for j in range(2, int(i**0.5) + 2):
        if i % j == 0:
            break
        if j == int(i**0.5) + 1:
            list.append(i)
while True:
    n = int(input())
    if n == 0:
        break
    else:
        flag = 0
        for j in range(0, len(list)):
            for k in range(0, len(list)):
                if list[k] + list[j] == n:
                    print(f"{n} = {list[j]} + {list[k]}")
                    flag = 1
                    break
            if flag == 1:
                break
        if flag == 0:
            print("Goldbach's conjecture is wrong.")
