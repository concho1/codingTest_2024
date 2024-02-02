import java.util.*;

class ChMap{
    HashMap<Character,Integer> chMap = new HashMap<>();
    
    ChMap(char[] chArr){
        for(char c : chArr) {
            if(this.chMap.containsKey(c)) 
                this.chMap.put(c,1+this.chMap.get(c));
            else this.chMap.put(c,1);
        }
    }
    int get(char c){
        return this.chMap.get(c);
    }
}

class Solution {
    
    public String solution(String X, String Y) {
        ChMap xMap = new ChMap(X.toCharArray());
        ChMap yMap = new ChMap(Y.toCharArray());
        
        Set<Character> keys1 = new HashSet<>(xMap.chMap.keySet());
        Set<Character> keys2 = new HashSet<>(yMap.chMap.keySet());
        keys1.retainAll(keys2);
        if(keys1.size() == 0) return "-1";
        
        var numList = new LinkedList<Character>();
        for(char c : keys1){
            for(int i=0; i< ( (xMap.get(c) < yMap.get(c)) ? xMap.get(c) : yMap.get(c) ); i++){
                numList.add(c);
            }
        }
        Collections.sort(numList, Comparator.reverseOrder());
        char[] strArr = new char[numList.size()];
        int i = 0;
        boolean oneShot = true;
        for(char n : numList){
            if(oneShot){
                if(n != '0'){
                    strArr[i++] = n;
                    oneShot = false;
                }
            }else{
                strArr[i++] = n;
            }
        }
        if(oneShot) return "0";
        String answer = new String(strArr);
        //long tm = Long.valueOf(answer);
        //answer = String.valueOf(tm);
        return answer;
    }
}