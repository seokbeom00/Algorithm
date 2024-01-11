arr = list(input())
x_count = []
ans = []
tmp = 0
for i in arr:
    if i == "X":
        tmp += 1
    if i == ".":
        x_count.append(tmp)
        x_count.append(-1)
        tmp = 0
x_count.append(tmp)
while 0 in x_count:
    x_count.remove(0)
for i in x_count:
    if i == -1:
        ans.append(".")
    elif i % 2 == 1:
        print(-1)
        exit()
    else:
        tmp = i
        while tmp > 0:
            if tmp >= 4:
                ans.append("AAAA")
                tmp -= 4
            else:
                ans.append("BB")
                tmp -= 2
print("".join(map(str, ans)))
