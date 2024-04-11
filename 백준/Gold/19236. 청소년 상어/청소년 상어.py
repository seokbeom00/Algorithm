import sys
sys.setrecursionlimit(1111111)
from copy import deepcopy
direct = [[-1,0], [-1,-1], [0, -1], [1,-1], [1,0], [1,1], [0,1], [-1,1]] 
fish = {} #[key]fish_num      [value]:[0]fish좌표   [1]방향 (idx에 맞게 1씩 빼서 넣어줬음)
arr = []
board = [[0 for _ in range(4)]for _ in range(4)] #보드의 각 좌표에 fish_num 저장 0:빈칸   20:상어
for i in range(4):
  arr.append(list(map(int, input().split())))
for i in range(4):
  for j in range(0,8,2):
    board[i][j//2] = arr[i][j]
for i in range(4):
  for j in range(0, 8, 2):
    fish[arr[i][j]] = [[i,j//2], arr[i][j+1]-1]

def fish_check(x,y,di,fish_list, tmp_board): #상어행, 상어열, 상어방향, 물고기후보군
  while True:
    x, y = x+direct[di][0], y+direct[di][1]
    if x < 0 or x >= 4 or y < 0 or y >= 4:
      break
    if tmp_board[x][y] != 0 and tmp_board[x][y] != 20:
      fish_list.append(tmp_board[x][y])

def move_fish(fish_num, tmp_fish, tmp_board):
  fish_xy, fish_di = tmp_fish[fish_num]
  for i in range(fish_di, fish_di+8, 1):
    dx,dy = fish_xy[0]+direct[i%8][0], fish_xy[1]+direct[i%8][1]
    if dx < 0 or dx >= 4 or dy < 0 or dy >= 4 or tmp_board[dx][dy] == 20: #장외거나 상어면 건너뜀
      continue
    if tmp_board[dx][dy] == 0: #빈칸
      tmp_board[dx][dy] = fish_num #빈칸에 물고기 넣고
      tmp_board[fish_xy[0]][fish_xy[1]] = 0 #물고기자리에는 빈칸
      tmp_fish[fish_num] = [[dx,dy], i%8] #물고기 위치정보, 방향정보 수정
      break
    else:
      tmp_num = tmp_board[dx][dy] #바뀜당하는 물고기
      tmp_board[fish_xy[0]][fish_xy[1]], tmp_board[dx][dy] = tmp_num, fish_num #보드에서 서로 자리 바꿈
      tmp_fish[fish_num] = [[dx,dy], i%8]
      tmp_fish[tmp_num][0] = [fish_xy[0], fish_xy[1]] #바뀜당하는 놈은 위치정보만 수정
      break

ans = []
def back(tmp_board, tmp_ans, x, y, di, tmp_fish): #복사한 보드, 분기정답, 상어행, 상어열, 상어방향, 복사한fish
  fish_list = []
  fish_check(x,y,di,fish_list, tmp_board)
  if not fish_list: #잡아먹을 물고기가 없으면 종료
    ans.append(tmp_ans)
    return
  for fish_num in fish_list:
    t_board = deepcopy(tmp_board)
    t_fish = deepcopy(tmp_fish)
    fish_xy, fish_di = t_fish[fish_num]
    t_board[fish_xy[0]][fish_xy[1]], t_board[x][y] = 20, 0 #상어가 잡아먹고 그 자리로 변경
    t_fish[fish_num][0] = [-1,-1] #잡아먹힌 물고기 좌표
    for num in range(1, 17, 1):
      if t_fish[num][0] != [-1,-1]: #잡아먹히지 않았다면 순서대로 이동
        move_fish(num, t_fish, t_board)
    back(t_board, tmp_ans+fish_num, fish_xy[0], fish_xy[1], fish_di, t_fish)
tmp = board[0][0]
board[0][0] = 20
fish[tmp][0] = [-1,-1]

for num in range(1, 17, 1):
      if fish[num][0][0] != -1: #잡아먹히지 않았다면 순서대로 이동
        move_fish(num, fish, board)
back(board, tmp, 0, 0, fish[tmp][1], fish)
print(max(ans))