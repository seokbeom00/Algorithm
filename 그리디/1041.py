import sys

input = sys.stdin.readline
n = int(input())
dice = list(map(int, input().split()))
one_min = min(dice)
three_min = min(
    dice[0] + dice[4] + dice[2],
    dice[0] + dice[1] + dice[2],
    dice[1] + dice[5] + dice[2],
    dice[4] + dice[5] + dice[2],
    dice[0] + dice[4] + dice[3],
    dice[0] + dice[1] + dice[3],
    dice[1] + dice[5] + dice[3],
    dice[4] + dice[5] + dice[3],
)
two_min = min(
    dice[0] + dice[1],
    dice[0] + dice[2],
    dice[0] + dice[3],
    dice[0] + dice[4],
    dice[1] + dice[2],
    dice[1] + dice[3],
    dice[1] + dice[5],
    dice[2] + dice[4],
    dice[2] + dice[5],
    dice[3] + dice[4],
    dice[3] + dice[5],
    dice[4] + dice[5],
)
if n == 1:
    print(sum(dice) - max(dice))
else:
    print(
        (three_min * 4) + (two_min * (8 * n - 12)) + (one_min * (n - 2) * (5 * n - 6))
    )
