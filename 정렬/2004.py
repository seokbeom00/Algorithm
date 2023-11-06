import sys

input = sys.stdin.readline


def count_num(target, num):
    ans = 0
    while target != 0:
        target //= num
        ans += target
    return ans


n, m = map(int, input().split())
two_num = count_num(n, 2) - count_num(m, 2) - count_num(n - m, 2)
five_num = count_num(n, 5) - count_num(m, 5) - count_num(n - m, 5)
print(min(two_num, five_num))
