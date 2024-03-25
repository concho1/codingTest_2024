import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        HashMap<Integer, HashSet<Integer>> nodeMap = new HashMap<>();
        HashSet<Integer> allComSet = new HashSet<>();
        for(int i=0; i<computers.length; i++){
            nodeMap.put(i, new HashSet<>());
            allComSet.add(i);
        }
        
        
        for(int i=0; i<computers.length; i++){
            
            for(int j=i; j<computers[0].length; j++){
                // i 번째 컴퓨터와 j 번째 컴퓨터는 인접
                if(computers[i][j] == 1){
                    nodeMap.get(i).add(j);
                    nodeMap.get(j).add(i);
                }
            }
        }
        for(int k : nodeMap.keySet()){
            for(int v : nodeMap.get(k)){
                System.out.print(k+"  "+v);
            }
            System.out.println();
        }
        
        LinkedList<Integer> q = new LinkedList<>();
        HashSet<Integer> visitedComSet = new HashSet<>();
        
        q.add(0);
        visitedComSet.add(0);
        
        while(!allComSet.isEmpty()){
            answer++;
            while(!q.isEmpty()){
                int node = q.pop();
                for(int i : nodeMap.get(node)){
                    if(!visitedComSet.contains(i)){
                        q.add(i);
                        visitedComSet.add(i);
                    }
                }

            }
            allComSet.removeAll(visitedComSet);
            for(int i : allComSet){
                System.out.println(i);
                q.add(i);
                visitedComSet.add(i);
                break;
            }
        }
        return answer;
    }
}