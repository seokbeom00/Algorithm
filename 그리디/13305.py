import sys
input = sys.stdin.readline

n = int(input())
distance = list(map(int, input().split()))
price =  list(map(int, input().split()))
min_price = price[0]
total = min_price*distance[0]
for i in range(1, len(distance)):
    if min_price > price[i]:
        min_price = price[i]
    total += min_price*distance[i]
print(total)