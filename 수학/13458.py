n = int(input())
student = list(map(int, input().split()))
b, c = map(int, input().split())
ans = 0
for i in student:
    tmp = i - b
    ans += 1
    if tmp > 0:
        ans += tmp // c
        if tmp % c > 0:
            ans += 1
print(ans)
