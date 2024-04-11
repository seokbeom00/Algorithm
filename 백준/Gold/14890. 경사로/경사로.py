n, l = map(int, input().split()) #지도크기, 경사로길이
board = []
for i in range(n):
    board.append(list(map(int, input().split())))

def check_load(x,y,di): #체크 시작점, 체크방향
    start_point = board[x][y] #체크 시작점 높이 저장
    launch = [] #경사로가 설치된 부분들
    for i in range(l):
      dx, dy = x+di[0]*i, y+di[1]*i
      if dx < 0 or dy < 0 or dx >= n or dy >= n:
          return [False, []]
      if board[dx][dy] != start_point: #설치 지점의 높이가 달라진다면 실패
          return [False, []]
      launch.append([dx, dy])
    return [True, launch] #경사로 설치된 부분들 리턴
ans = 0
for r, row in enumerate(board):
    check_point = row[0] #처음은 행의 시작 부분이 체크포인트
    alread_launch = [] #한 행당 경사로가 설치된 좌표값 리스트
    can_go = True
    for c, val in enumerate(row):
        if val == check_point: #높이가 같으면 계속 감
            continue
        elif val == check_point+1 and c-1 >= 0: #높이가 높아지고 뒤에가 낭떠러지 아니면 반대로 체크 시작
            result = check_load(r, c-1, [0, -1])
        elif val == check_point-1: #낮아졌으면 그 자리에서 체크 시작
            result = check_load(r, c, [0, 1])
        elif val >= check_point+2 or val <= check_point-2:
          can_go = False
          break #높이가 2이상 차이나면 종료시켜버림    
        if not result[0]:
            can_go = False #설치 불가능해도 종료
            break
        for candidate in result[1]:
            if candidate in alread_launch: #경사로 설치된데에는 설치 불가능
                can_go = False
                break
        alread_launch += result[1]
        check_point = val #기준점 바꾸고 계속 진행
    if can_go:
        ans += 1
for i in range(n):
    check_point = board[0][i] #처음은 열의 시작 부분이 체크포인트
    alread_launch = [] #한 열당 경사로가 설치된 좌표값 리스트
    can_go = True
    for j in range(n):
        if board[j][i] == check_point: #높이가 같으면 계속 감
            continue
        elif board[j][i] == check_point+1 and j-1 >= 0: #높이가 높아지고 뒤에가 낭떠러지 아니면 반대로 체크 시작
            result = check_load(j-1, i, [-1, -0])
        elif board[j][i] == check_point-1: #낮아졌으면 그 자리에서 체크 시작
            result = check_load(j, i, [1, 0])
        elif board[j][i] >= check_point+2 or board[j][i] <= check_point-2:
          can_go = False
          break #높이가 2이상 차이나면 종료시켜버림      
        if not result[0]:
            can_go = False #설치 불가능해도 종료
            break
        for candidate in result[1]:
            if candidate in alread_launch: #경사로 설치된데에는 설치 불가능
                can_go = False
                break
        alread_launch += result[1]
        check_point = board[j][i] #기준점 바꾸고 계속 진행
    if can_go:
        ans += 1
print(ans)
