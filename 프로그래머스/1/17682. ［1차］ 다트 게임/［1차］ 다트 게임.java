import java.util.*;
class Solution {
    static Integer[] scArr;
    
    static void doubleCal(int i){
        scArr[i] = scArr[i]*scArr[i];
    }
    static void tripleCal(int i){
        scArr[i] = scArr[i]*scArr[i]*scArr[i];
    }
    static void achaCal(int i){
        scArr[i] = -scArr[i];
    }
    static void starCal(int i){
        if(i == 0){
            scArr[i] = scArr[i]*2;
        }else if( i >= 1){
            scArr[i] = scArr[i]*2;
            scArr[i-1] = scArr[i-1]*2;
        }
    }
    
    public int solution(String dartResult) {
        int answer = 0;
        scArr = new Integer[dartResult.length()];
        char[] chArr = dartResult.toCharArray();
        Integer number = null;
        int numberCnt = 0;
        for(int i=0; i<chArr.length; i++){
            if('0' <= chArr[i] && chArr[i] <= '9'){   // 숫자일때
                if(number == null){
                    number = chArr[i] - '0';
                }else{
                    number = 10;
                }
            }else{                                  // 문자일때
                if(number != null){
                    // 숫자 완성
                    System.out.println(number);
                    scArr[numberCnt] = number;
                    numberCnt++;
                }
                number = null;
                if(chArr[i] == 'D') doubleCal(numberCnt-1);
                else if(chArr[i] == 'T') tripleCal(numberCnt-1);
                else if(chArr[i] == '*') starCal(numberCnt-1);
                else if(chArr[i] == '#') achaCal(numberCnt-1);
            }
        }
        for(Integer sc : scArr){
            if(sc != null) answer += sc;
        }
        return answer;
    }
}