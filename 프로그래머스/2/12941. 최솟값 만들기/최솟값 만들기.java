import java.util.*;
class Solution{
    public int solution(int[] A, int[] B){
        int answer = 0;
        // 1000! * 1000! 이므로 완전탐색 불가
        Arrays.sort(A);   Arrays.sort(B);
        int j = A.length;
        for(int i=0; i<A.length; i++){
            answer += B[--j] * A[i];
        }
        return answer;
    }
}