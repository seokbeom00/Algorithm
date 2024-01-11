import sys

input = sys.stdin.readline
arr = []
n = list(input())
n.pop()
for i in n:
    arr.append(int(i))
if 0 in arr and sum(arr) % 3 == 0:
    arr = sorted(arr, reverse=True)
    ans = "".join(map(str, arr))
    print(ans)
else:
    print(-1)
# 다 더해서 3의 배수고 0이 하나라도 있으면 30으로 나눌 수 있음.
