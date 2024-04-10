T = int(input())

def put_num(num, arr, term):
    for i in range(0, len(arr) - term + 1, term):
        tmp = arr[i:i + term]
        num.add("".join(tmp))

dict = {"0": 0, "1": 1, "2": 2, "3": 3, "4": 4, "5": 5, "6": 6, "7": 7, "8": 8, "9": 9, "A": 10, "B": 11, "C": 12,
        "D": 13, "E": 14, "F": 15}
for test_case in range(1, T + 1):
    n, k = map(int, input().split())
    num = set()
    arr = list(input())
    put_num(num, arr, n // 4)
    for i in range(n // 4 - 1):
        tmp = arr.pop()
        arr = [tmp] + arr
        put_num(num, arr, n // 4)
    num_int = []
    for number in num:
        tmp = 0
        tmp_arr = list(reversed(number))
        for i in range(n//4):
            tmp += (16**i) * dict[tmp_arr[i]]
        num_int.append(tmp)
    print(f"#{test_case} {sorted(num_int, reverse=True)[k-1]}")
