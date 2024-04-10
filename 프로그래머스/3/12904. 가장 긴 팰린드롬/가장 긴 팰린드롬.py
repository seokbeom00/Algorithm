from copy import deepcopy
def check(stack, num, arr, an):
    global ans
    for i in range(num, num+len(stack)):
        if i >= len(arr):
            break
        if stack and stack.pop() == arr[i]:
            an+= 2
        else:
            break
    ans = max(ans, an)
def solution(s):
    global ans
    ans = 1
    arr = list(s)
    stack = []
    for i in range(len(arr)):
        stack.append(arr[i])
        tmp = deepcopy(stack)
        check(tmp, i+1, arr, 0)
        tmp2 = deepcopy(stack)
        check(tmp2, i+2, arr, 1)
    return ans