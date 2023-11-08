from collections import deque

queue = deque()
queue.append(4)
queue.append(5)
queue.append(2)


def gcd(a, b):
    if a % b == 0:
        return b
    else:
        return gcd(b, a % b)


print(gcd(126, 192))
