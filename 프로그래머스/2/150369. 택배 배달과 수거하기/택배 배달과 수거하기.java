import java.util.*;

class Solution {
    static int[] deliver(int cap, int[] deliveries, int endPoint){
        int tmCap = cap, nextPoint = 0;
        boolean oneS = true, endFalg = false;
        for(int i= endPoint; i >= 0; i--){
            nextPoint = i;
            if(oneS && (deliveries[i] != 0) ){
                endPoint = i;
                oneS = false;
            }
            if(endFalg && deliveries[i] != 0){
                break;
            }
            
            if(deliveries[i] == tmCap){        // 상품 수 == 남은자리
                deliveries[i] = 0;
                tmCap = 0;
                endFalg = true;
            }else if(deliveries[i] > tmCap){   // 상품 수 > 남은자리
                deliveries[i] -= tmCap;
                tmCap = 0;
                break;
            }else{                             // 상품 수 < 남은자리
                tmCap -= deliveries[i];
                deliveries[i] = 0;
            }      

        }
        if(oneS) return new int[]{0,0};
        return new int[]{nextPoint,endPoint};
    }
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int endPointDe = deliveries.length -1;
        int endPointPi = pickups.length -1;
        int[] n_ePointDe = {endPointDe,0, 0};
        int[] n_ePointPi = {endPointPi,0, 0};
        boolean dt = true, pi = true;
        if(Arrays.stream(deliveries).sum() == 0) dt = false;
        if(Arrays.stream(pickups).sum() == 0) pi = false;
        
        int stPic = 0, stDe = 0;
        for(int i=0; i< pickups.length; i++){
            if(deliveries[i] != 0){
                stDe = i;
                break;
            }
        }
        for(int i=0; i< pickups.length; i++){
            if(pickups[i] != 0){
                stPic = i;
                break;
            }
        }
        while(true){
            if(pi && dt){
                n_ePointDe = deliver(cap, deliveries, n_ePointDe[0]);
                n_ePointPi = deliver(cap, pickups, n_ePointPi[0]);
                
                answer += 2 * (Math.max(n_ePointDe[1],n_ePointPi[1]) + 1);
                if(deliveries[stDe] == 0 && pickups[stPic] == 0) break;
                
            }
            else if(dt){
                n_ePointDe = deliver(cap, deliveries, n_ePointDe[0]);
                answer += 2 * (Math.max(n_ePointDe[1],n_ePointPi[1]) + 1);
                if(deliveries[stDe] == 0 && pickups[stPic] == 0) break;
            }else if(pi){
                n_ePointPi = deliver(cap, pickups, n_ePointDe[0]);
                answer += 2 * (Math.max(n_ePointDe[1],n_ePointPi[1]) + 1);
                if(deliveries[stDe] == 0 && pickups[stPic] == 0) break;

            }else{
                return 0;
            }
            
        }
        
        return answer;
    }
}