class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        // 마트에 a 개의 빈병을 가져다주면 b개의 콜라를 줌, 소지중인 콜라 n
        boolean endPoint = true;    //종료 조건 flag
        while(endPoint){
            if(n >= a){
                int resiveCoke = (n/a)*b;
                n %= a;
                n += resiveCoke;
                answer+= resiveCoke;
            }else{
                endPoint = false;
            }
        }
        return answer;
    }
}