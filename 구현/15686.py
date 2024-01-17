import sys
from itertools import combinations

input = sys.stdin.readline
n, m = map(int, input().split())
city = []
for i in range(n):
    city.append(list(map(int, input().split())))


def chicken_distance(house, chicken):
    distance = 0
    for i in house:
        min = 200
        for j in chicken:
            if abs(i[0] - j[0]) + abs(i[1] - j[1]) < min:
                min = abs(i[0] - j[0]) + abs(i[1] - j[1])
        distance += min
    return distance


house = []
chicken = []
for i in range(n):
    for j in range(n):
        if city[i][j] == 1:
            house.append((i, j))
        elif city[i][j] == 2:
            chicken.append((i, j))
chicken = list(combinations(chicken, m))
min = 100000
for i in chicken:
    tmp = chicken_distance(house=house, chicken=i)
    if tmp < min:
        min = tmp
print(min)
