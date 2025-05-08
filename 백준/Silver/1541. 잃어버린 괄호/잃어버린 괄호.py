arr = input().split('-')
num = []
for i in arr:
    a = 0
    tmp = i.split('+')
    for j in tmp:
        a += int(j)
    num.append(a)
if len(num) == 1:
    print(num[0])
else:
    ans = num[0]
    num.remove(num[0])
    for i in num:
        ans -= i
    print(ans)