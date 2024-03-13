import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        // 병사 n 명으로 적 enemy[i] 마리 막기
        // 적을 막을 경우 n -= enemy[i] 로 병사 수 감소
        // if(n < enemy[i]) 게임 종료
        // '무조건'(k 개)을 사용한다면 병사의 소모 없이 한 라운드 공겨을 막을 수 있음
        // '무조건'은 많은 적이 왔을 때 쓰는 것이 유리
        
        // 우선순위가 높은 숫자가 먼저 나옴 (큰 숫자)
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        
        long nowN = n;
        
        // 지금 적과 이전에 상대했던 적 중 가장 많은 수의 적을 '무조건'을 쓴거로 취급
        for(int i=0; i<enemy.length; i++){
            if(nowN < enemy[i]){           // 감당 불가능한 적이 몰려오면

                if(k != 0) {                    // 무조건 있으면
                    k--;                            // 무조건 사용
                }else{
                    return i;                     // 끝
                }
                
                if(!pQ.isEmpty() && pQ.peek() > enemy[i]){  // 이전 적이 더 많으면
                    //System.out.println("last " + pQ.peek());
                    nowN += pQ.poll();               // 이전 적에 '무조건' 사용
                    nowN -= enemy[i];
                    pQ.add(enemy[i]);
                }else{
                    //System.out.println("now " + enemy[i]);
                }
            }else{                          // 감당 가능하면
                nowN -= enemy[i];
                pQ.add(enemy[i]);
            }
            
        }
        //System.out.println("끝까지 감");
        return enemy.length;
    }
}