def solution(N, number):
    answer = 0
    arr = []
    tmp = str(N)
    for _ in range(8):
        arr.append({int(tmp)})
        tmp+=str(N)
    for i in range(8):
        for j in range(i):
            for op1 in arr[j]:
                for op2 in arr[i-j-1]:
                    arr[i].add(op1+op2)
                    arr[i].add(op1-op2)
                    arr[i].add(op1*op2)
                    if op2 != 0:
                        arr[i].add(op1//op2)
        if number in arr[i]:
            return i+1
        else:
            answer = -1
    return answer