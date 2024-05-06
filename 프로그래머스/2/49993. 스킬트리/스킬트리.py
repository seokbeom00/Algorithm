def solution(skill, skill_trees):
    answer = 0
    check = skill
    for sk in skill_trees:
        idx = 0
        flag = True
        for s in sk:
            if s in check and s == check[idx]:
                idx += 1
            elif s in check and s != check[idx]:
                flag = False
                break
        if flag:
            answer += 1
    return answer