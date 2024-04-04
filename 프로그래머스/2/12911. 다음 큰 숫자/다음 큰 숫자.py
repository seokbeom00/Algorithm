def check(num):
    tmp = 1
    while num>1:
        if num%2 == 1:
            tmp += 1
        num //= 2
    return tmp
def solution(n):
    tmp = check(n)
    for i in range(n+1,  1000001):
        if tmp == check(i):
            return i