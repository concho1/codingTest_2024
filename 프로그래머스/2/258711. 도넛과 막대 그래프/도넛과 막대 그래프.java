import java.util.*;

class Solution {
    /*
    * 도넛 특징: 노드 = 간선
    * 막대 특징: 노드 - 1 = 간선 => 항상 막힘 => 이동도중 null key 발생
    * 팔자 특징: 노드 + 1 = 간선
    */
    static int tracking(HashMap<Integer, LinkedList<Integer>> map,int start){
        var visit = new LinkedList<Integer>();
        var visited = new HashSet<Integer>();
        int nodeCnt = 0, lineCnt = 0;
        visited.add(start);
        visit.add(start);
        
        while(!visit.isEmpty()){
            var node = visit.pop();
            visited.add(node);
            
            var tm = map.get(node);
            if(tm == null) return 2;
            lineCnt += tm.size();
            for(int n : tm){
                if(!visited.contains(n)){
                    visit.add(n);
                    visited.add(n);
                }
            }
            
        }
        nodeCnt = visited.size();
        if(nodeCnt == lineCnt) return 1;
        return 3;
    }
    public int[] solution(int[][] edges) {
        /*
        * 일단 생성한 정점의 번호 부터 구하자
        * 정점의 특징: 모든 간선이 밖으로 향한다. && 간선이 2 이상이다.
        
        */
        var node = new HashMap<Integer, LinkedList<Integer> >();
        var topNodeSet = new HashSet<Integer>();
        var notTopNode = new HashSet<Integer>();
        for(int[] e : edges){
            int s = e[0], f = e[1];
            notTopNode.add(f);
            if(node.containsKey(s)){
                node.get(s).add(f);
                topNodeSet.add(s);
            }else{
                var tm = new LinkedList<Integer>();
                tm.add(f);
                node.put(s,tm);
            }
        }
        
        int topNode = 0;
        topNodeSet.removeAll(notTopNode);
        for(int tm : topNodeSet) topNode = tm;
        
        int[] answer = {topNode,0,0,0};
        
        for(Integer k : node.get(topNode)) {
            answer[tracking(node, k)]++;
        }
        
        return answer;
    }
}