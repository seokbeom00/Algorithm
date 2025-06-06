import java.util.*;
import java.io.*;

public class Main {
    //PriorityQueue에 사용될 보비디안 위치 관련 클래스
    static class position implements Comparable<position>{
        int x, y, count, gravity;
        public position(int x, int y, int count, int gravity) {
            this.x = x;
            this.y = y;
            this.count = count;	//중력 변경 횟수
            this.gravity = gravity;	//중력 방향
        }

        //중력 변경 횟수에 따른 오름차순 정렬
        @Override
        public int compareTo( position o) {
            return this.count-o.count;
        }
    }
    static int N,M, startX, startY;
    static int[] dx = {-1, 1};	//왼쪽, 오른쪽 x값 변경
    static char[][] space;	//공간에 대한 정보 저장 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값 처리하는 BufferedReader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        space = new char[N][M];
        //공간에 대한 정보 저장
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                space[i][j] = str.charAt(j);
                //보비디안 첫 위치 저장
                if(space[i][j] == 'C'){
                    startX = j;
                    startY = i;
                }
            }
        }
        //초기 중력 ↓로 인한 보비디안 위치 조정(1.)
        startY = moveOfGravity(startX,startY,0);
        if(startY==-1)	//위치 조정할 때 바로 버팔로씨 만난 경우
            bw.write("0");
        else if(startY==Integer.MIN_VALUE)	//위치 조정할 때 우주로 떨어질 때
            bw.write("-1");
        else 		//위치 조정 후 최소값 찾는 bfs 함수 결과 BufferedWriter 저장
            bw.write(bfs() + "");
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //다익스트라 BFS탐색으로 최소 중력 변경으로 버팔로(D)까지 도달하는 값을 탐색하는 함수
    static int bfs(){
        PriorityQueue<position> pq = new PriorityQueue<>();
        boolean[][][] visited = new boolean[N][M][2];
        visited[startY][startX][0] = true;
        pq.add(new position(startX,startY,0, 0));
        while(!pq.isEmpty()){
            position cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int count = cur.count;
            int gravity = cur.gravity;
            //좌우 이동
            for(int i=0;i<2;i++){
                int tempX = x + dx[i];
                if(tempX>=0 && tempX<M){
                    if(space[y][tempX]!='#'){	//빈 셀인 경우
                        int tempY = moveOfGravity(tempX,y,gravity);
                        if(tempY==-1)		//버팔로씨 만난 경우
                            return count;
                        //왼쪽, 오른쪽 이동 후 중력으로 위치 조정된 자리 확인
                        if(tempY!=Integer.MIN_VALUE && !visited[tempY][tempX][gravity]){
                            visited[tempY][tempX][gravity] = true;
                            pq.add(new position(tempX, tempY, count, gravity));
                        }
                    }
                }
            }
            int tempGravity = (gravity+1) % 2;	// 중력 변경
            int tempY = moveOfGravity(x,y,tempGravity);	//중력 변경으로 위치 조정
            if(tempY==-1)	//중력 변경으로 버팔로씨 만난 경우
                return count+1;
            //중력 변경으로 위치 조정된 자리 확인
            if(tempY != Integer.MIN_VALUE && !visited[tempY][x][tempGravity]){
                visited[tempY][x][tempGravity] = true;
                pq.add(new position(x,tempY,count+1, tempGravity));
            }

        }
        return -1;		//버팔로씨에게 도달하지 못할 경우
    }
    //중력방향에 따른 보비디안 위치 조정 함수
    static int moveOfGravity(int x, int y, int gravity){
        if(gravity == 0){		//중력 방향 ↓
            for(int i=y;i<N;i++){
                if(space[i][x]=='#')	//차단된 셀을 만날 때
                    return i-1;
                else if(space[i][x] == 'D')	//버팔로 만날 때
                    return -1;
            }
        }else{		//중력 방향 ↑
            for(int i=y;i>=0;i--){
                if(space[i][x] == '#')	//차단된 셀을 만날 때
                    return i+1;
                else if(space[i][x] == 'D')	//버팔로 만날 때
                    return -1;
            }
        }
        return Integer.MIN_VALUE;		//우주로 날아갈 때
    }
}