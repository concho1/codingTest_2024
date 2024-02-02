import java.util.*;
class 뽑기기계{
    HashMap<Integer,LinkedList<Integer>> container = new HashMap<>();
    
    뽑기기계(int[][] board){
        for(int i=0; i<board.length; i++){
            var tmList = new LinkedList<Integer>();
            for(int j=0; j<board.length; j++){
                int doll = board[j][i];
                if(doll != 0) tmList.add(doll);
            }
            this.container.put(i, tmList);
        }
    }
    // 없을 시 -1 return
    int pickUp(int n){
        if(this.container.get(n-1).isEmpty())   return -1;
        else    return this.container.get(n-1).poll();
    }
}

class 바구니{
    LinkedList<Integer> bag = new LinkedList<>();
    
    // 터짐 : true, 안터짐: false
    boolean putIn(int doll){
        if(this.bag.isEmpty()){
            this.bag.add(doll);
            return false;
        }else{
            if(this.bag.getLast() == doll){
                this.bag.pollLast();
                return true;
            }else{
                this.bag.add(doll);
                return false;
            }
        }
    }
}
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        뽑기기계 mc = new 뽑기기계(board);
        바구니 ba = new 바구니();
        
        for(int i : moves) {
            // 하나 뽑아서(없으면 -1)
            int doll = mc.pickUp(i);
            // 있으면 넣고
            if(doll != -1){
                // 터지면 +2
                if(ba.putIn(doll))  answer+=2;
            }
        }
        return answer;
    }
}