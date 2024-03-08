import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        // 기사 번호의 약수 개수에 해당하는 공격력을 가진 무기 선택
        // 에라토스테네스의 체와 비슷한 알고리즘으로 ㄱㄱ
        int[] arr = new int[number];
        int[] result = new int[number];
        
        for(int i=2; i <= number; i++){
            for(int j = i; j <= number; j += i){
                arr[j-1]++;
            }
        }
        for(int i=0; i < number; i++){
            int n = arr[i];
            if(n+1 > limit){
                answer += power;
            }else{
                answer += n+1;
            }
        }
        
        
        return answer;
    }
}