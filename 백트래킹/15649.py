from itertools import permutations

n, m = map(int, input().split())
arr = [x for x in range(1, n + 1)]
ans = list(permutations(arr, m))
for i in ans:
    for j in range(m):
        print(i[j], end=" ")
    print()
