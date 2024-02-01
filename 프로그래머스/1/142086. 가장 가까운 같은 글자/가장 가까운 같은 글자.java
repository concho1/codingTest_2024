import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char[] chArr = s.toCharArray();
        
        var chMap = new HashMap<Character, Integer>();
        
        for(int i=0; i<chArr.length; i++){
            if(chMap.containsKey(chArr[i])){
                answer[i] = i - chMap.get(chArr[i]);
            }else{
                answer[i] = -1;
            }
            chMap.put(chArr[i], i);
        }
        return answer;
    }
}