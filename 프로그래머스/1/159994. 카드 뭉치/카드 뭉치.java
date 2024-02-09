import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        var cards1List = new LinkedList<String>();  var cards2List = new LinkedList<String>();
        
        for(String str : cards1){cards1List.add(str);}
        for(String str : cards2){cards2List.add(str);}
        
        for(String str : goal){
            if(cards1List.size() != 0 && cards1List.getFirst().equals(str)){
                cards1List.poll();
            }else if(cards2List.size() != 0 && cards2List.getFirst().equals(str)){
                cards2List.poll();
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}