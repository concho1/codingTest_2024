import java.util.*;
class Solution {
    /*
    * act => 항상 같은 위치에 공을 놓고 쳐서 리스트에 담긴 위치에 놓인 공을 맞춥니다.
    * result => 공이 각각의 목표로한 공에 맞을 때까지 최소 거리
    * 공이 길을 가리는건 고려 X
    * logic: ball을 상,하,좌,우 벽을 기준으로 대칭으로 넘기기
    * newBall = {{x, 2n-y}, {x, -y}, {-x, y}, {2m-x, y}};
    * 이중 {x,y} 와의 거리가 최소인 값을 리턴 
    */
    //거리 구하는 함수
    public int distance(int startX, int startY, int x, int y){
        return ((startX - x)*(startX - x) + (startY - y)*(startY - y));
    }
    //최소 거리 구하는 함수
    public int createNewBall(int startX, int startY, int x, int y, int n, int m){
        int[][] newBall = {{x, 2*n-y}, {x, -y}, {-x, y}, {2*m-x, y}};
        
        int minDistance = Integer.MAX_VALUE;
        // 꼭지점 처리, 기울기 이용 
        // m(n-y) == nx && nx == my
        if(m*(n-startY) == n*startX && m*(n-y) == n*x){     //우상
            if(startX <= x){
                int tmD = distance(startX, startY,  0, 0) + distance(x, y,  0, 0);
                if(tmD < minDistance) minDistance = tmD;
            }else{
                int tmD = distance(startX, startY,  m, n) + distance(x, y,  m, n);
                if(tmD < minDistance) minDistance = tmD;
            }
        }
        else if( (n*startX == m*startY) && (n*x == m*y) ){  //우하
            if(startX <= x){
                int tmD = distance(startX, startY,  0, n) + distance(x, y,  0, n);
                if(tmD < minDistance) minDistance = tmD;
            }else{
                int tmD = distance(startX, startY,  m, 0) + distance(x, y,  m, 0);
                if(tmD < minDistance) minDistance = tmD;
            }
        }
        //공이 겹칠때 처리 x값 차이는 1000 + 1000 => 2000이 최대
        if( y >= startY && x == startX ){      // 상 겹침
            newBall[0][0] = 3000;
            newBall[0][1] = 3000;
        }else if( y <= startY && x == startX ){// 하 겹침
            newBall[1][0] = 3000;
            newBall[1][1] = 3000;
        }else if( x <= startX && y == startY ){// 좌 겹침
            newBall[2][0] = 3000;
            newBall[2][1] = 3000;
        }else if( x >= startX && y == startY ){// 우 겹침
            newBall[3][0] = 3000;
            newBall[3][1] = 3000;
        }
        for(int[] b : newBall){
            int tmD = distance(startX, startY,  b[0], b[1]);
            if(tmD < minDistance) minDistance = tmD;
        }
        return minDistance;
    }
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int i = 0;
        for(int[] b : balls){
            int minDistance = createNewBall(startX,startY,b[0],b[1], n, m);
            answer[i] = minDistance;
            i++;
        }
        
        return answer;
    }
}