import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        LinkedList<int[]> numbersQ = new LinkedList<>();
        
        numbersQ.add(new int[] {1,numbers[0]});                         // 깊이, 값
        numbersQ.add(new int[] {1,-numbers[0]});
        
        while(!numbersQ.isEmpty()){
            int[] node = numbersQ.pop();
            if(node[0] < numbers.length){
                numbersQ.add(new int[] {node[0] + 1, node[1] - numbers[node[0]]});
                numbersQ.add(new int[] {node[0] + 1, node[1] + numbers[node[0]]});
            }else{
                if(target == node[1]){
                    answer++;
                }
            }
        }
        return answer;
    }
}