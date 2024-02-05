import java.util.*;
class 엄지{
    private int[] umgiLocation;
    
    엄지(String s){
        int[] left = {0,0}; int[] right = {2,0};
        if(s.equals("left")) umgiLocation = left;
        else umgiLocation = right;
    }

    int distance(int x, int y){
        return Math.abs(x - umgiLocation[0]) + Math.abs(y - umgiLocation[1]);
    }

    void moveTo(int x, int y){
        this.umgiLocation[0] = x;   this.umgiLocation[1] = y; 
    }

}
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        boolean leftHand = hand.equals("left") ? true : false;
        
        var nm = new HashMap<Integer,int[]>();
        nm.put(1,new int[] {0,3});  nm.put(2,new int[] {1,3});  nm.put(3,new int[] {2,3});
        nm.put(4,new int[] {0,2});  nm.put(5,new int[] {1,2});  nm.put(6,new int[] {2,2});
        nm.put(7,new int[] {0,1});  nm.put(8,new int[] {1,1});  nm.put(9,new int[] {2,1});
                                    nm.put(0,new int[] {1,0});
        
        엄지 umgiL = new 엄지("left");
        엄지 umgiR = new 엄지("right");
        
        var resultList = new LinkedList<String>();
        for(int num : numbers){
            int x = nm.get(num)[0]; int y = nm.get(num)[1]; 
            if(num == 2 ||num == 5 ||num == 8 ||num == 0){
                if(umgiL.distance(x,y) == umgiR.distance(x,y)){
                    if(hand.equals("left")){
                        resultList.add("L");
                        umgiL.moveTo(x,y);
                    }else{
                        resultList.add("R");
                        umgiR.moveTo(x,y);
                    }
                }else if(umgiL.distance(x,y) > umgiR.distance(x,y)){
                    resultList.add("R");
                    umgiR.moveTo(x,y);
                }else{
                    resultList.add("L");
                    umgiL.moveTo(x,y);
                }
            }else if(num == 1 ||num == 4 ||num == 7){
                resultList.add("L");
                umgiL.moveTo(x,y);
            }else{
                resultList.add("R");
                umgiR.moveTo(x,y);
            }
        }
        answer = String.join("",resultList);
        
        return answer;
    }
}