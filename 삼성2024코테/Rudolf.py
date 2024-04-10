di_s = [[-1, 0], [0, 1], [1, 0], [0, -1]]  #산타의 방향 : 상우하좌
di_r = [[-1, 0], [0, 1], [1, 0], [0, -1], [-1, -1], [1, -1], [-1, 1], [1, 1]]  #루돌프의 방향 : 좌대각, 우대각
def rudolf(x, y, santa):  #생존해 있는 산타 중, 가장 가까운 산타에게 한칸 돌진
    tmp = []  #각 방향으로 이동 시 산타별 거리와 이동한 좌표 계산 각 배열의  [0]산타넘버, [1]산타행 [2]산타열 [3]이동전거리 [4]이동후행 [5]이동후열 [6]이동 후 거리 [7]이동 방향
    for i in range(len(santa)):
        if not santa[i][0]:  #죽은 산타면 넘어감
            continue
        for j in di_r:
            dx, dy = x + j[0], y + j[1]
            tmp_len = (santa[i][2] - x) ** 2 + (santa[i][3] - y) ** 2
            tmp_len2 = (santa[i][2] - dx) ** 2 + (santa[i][3] - dy) ** 2
            tmp.append([i, santa[i][2], santa[i][3], tmp_len, dx, dy, tmp_len2, j])
    tmp.sort(key=lambda x: (x[3], -x[1], -x[2], x[6]))
    return tmp[0]
def crush(x, y, santa, di, target):  #연쇄작용  충돌위치, 산타정보, 튕겨나간 방향, 튕겨나오는 산타
    flag = True
    tx, ty = x, y  #충돌위치
    while flag:
        tmp = False
        for i in range(len(santa)):
            if target == i:
                continue
            if tx == santa[i][2] and ty == santa[i][3]:  #산타가 밀려났는데 거기 산타가 또 있음
                santa[i][2] += di[0]
                santa[i][3] += di[1]
                if santa[i][2] < 0 or santa[i][2] >= n or santa[i][3] < 0 or santa[i][3] >= n:  #밀려나간 산타가 장외
                    santa[i][0] = False
                    tmp = False
                    break
                tx, ty = santa[i][2], santa[i][3]
                tmp = True
                target = i
                break
        flag = tmp
def ruTosan(arr, santa, c):
    if arr[1] == arr[4] and arr[2] == arr[5]:  #루돌프가 산타에게 충돌한 경우
        santa[arr[0]][1] = 2  # 기절로 변경, 돌진 방향으로 튕겨나감
        santa[arr[0]][2] += arr[7][0] * c
        santa[arr[0]][3] += arr[7][1] * c
        santa[arr[0]][4] += c
        if santa[arr[0]][2] < 0 or santa[arr[0]][3] < 0 or santa[arr[0]][2] >= n or santa[arr[0]][3] >= n:
            santa[arr[0]][0] = False  #장외되면 산타 죽음
        else:  #장외가 아닐 경우만 연쇄작용 시작
            crush(santa[arr[0]][2], santa[arr[0]][3], santa, arr[7], arr[0])
n, m, p, c, d = map(int, input().split())  #격자의 크기, 턴 수, 산타의 수, 루돌프가 박았을 떄 점수, 산타가 박았을 때 점수
r1, r2 = map(int, input().split())  #루돌프의 초기 위치
r1, r2 = r1 - 1, r2 - 1
santa = [[] for _ in range(p)]
for i in range(p):
    t1, t2, t3 = map(int, input().split())
    santa[t1 - 1] = ([True, 0, t2 - 1, t3 - 1, 0])  #idx 산타넘버, [0]생존, [1]기절 [2]행 [3]열 [4]점수
def check_santa(x, y, santa):
    for i in santa:
        if x == i[2] and y == i[3]:
            return True
    return False
#idx 산타넘버, [0]생존, [1]기절 [2]행 [3]열 [4]점수

def move_santa(tx, ty, santa):  #루돌프 위치랑 산타들
    for i in range(len(santa)):
        if not santa[i][0]:  #죽은 산타면 넘어감
            continue
        #기절 안한 산타만 움직임
        if santa[i][1] > 0:
            continue
        tmp_len = (tx - santa[i][2]) ** 2 + (ty - santa[i][3]) ** 2  #이동전 루돌프와의 거리
        tmp = []
        for j in range(len(di_s)):
            dx, dy = santa[i][2] + di_s[j][0], santa[i][3] + di_s[j][1]
            if check_santa(dx, dy, santa):  #산타가 있는 자리로는 이동 안함
                continue
            tmp_len2 = (tx - dx) ** 2 + (ty - dy) ** 2  #이동 후 루돌프와의 거리
            if dx < 0 or dx >= n or dy < 0 or dy >= n:  #장외로는 이동 안함
                continue
            if tmp_len2 < tmp_len:
                tmp.append([j, tmp_len2, dx, dy])
        if tmp:
            tmp.sort(key=lambda x: (x[1], x[0]))
            santa[i][2], santa[i][3] = tmp[0][2], tmp[0][3]
            if santa[i][2] == tx and santa[i][3] == ty:  # 산타가 움직였는데 루돌프가 있을 경우
                santa[i][1] = 2
                santa[i][4] += d
                tmp_di = [-di_s[tmp[0][0]][0], -di_s[tmp[0][0]][1]]
                santa[i][2] += tmp_di[0] * d
                santa[i][3] += tmp_di[1] * d
                if santa[i][2] < 0 or santa[i][2] >= n or santa[i][3] < 0 or santa[i][3] >= n:
                    santa[i][0] = False  # 산타가 루돌프한테 부딪히고 밖으로 나감
                else:
                    crush(santa[i][2], santa[i][3], santa, tmp_di, i)
for i in range(m):
    for j in santa:
        if j[1] > 0:  # 기절 낮추기
            j[1] -= 1
    tmp_ru = rudolf(r1, r2, santa)  #이동 후 루돌프 정보
    r1, r2 = tmp_ru[4], tmp_ru[5]
    ruTosan(tmp_ru, santa, c)
    move_santa(r1, r2, santa)
    flag = True
    for j in santa:
        if j[0]:  #살아있으면 점수 올라감
            j[4] += 1
            flag = False
    if flag:
        break
for i in santa:
    print(i[4], end=" ")