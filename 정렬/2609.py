import sys

input = sys.stdin.readline

a, b = map(int, input().split())
count = 1
ans = 0
ans2 = 0
while True:
    if count % a == 0 and count % b == 0:
        ans2 = count
        break
    count += 1
count = ans2 // a * ans2 // b
for i in range(count, 0, -1):
    if a % i == 0 and b % i == 0:
        ans = i
        break
print(ans)
print(ans2)
