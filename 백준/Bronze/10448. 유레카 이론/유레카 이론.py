import sys
answer = [0]*1001
li = []
t = 0
for i in range(1, 45):
    li.append(int(t + i))
    t = t + i

for i in li:
    for j in li:
        for k in li:
            if i + j + k <= 1000:
                answer[i + j + k] = 1

a = int(sys.stdin.readline())
for i in range(a):
    n = int(sys.stdin.readline())
    print(answer[n])
