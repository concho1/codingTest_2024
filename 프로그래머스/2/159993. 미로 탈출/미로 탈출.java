import java.util.*;
class Node {
    int x;  int y;  int cnt;
    
    Node(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
class Solution {
    static int bfs(boolean[][] visited, char[][] chMaps,int[] start){
        Node startNode = new Node(start[1], start[0], 0);
        var visit = new LinkedList<Node>();
        
        visit.add(startNode);
        visited[startNode.y][startNode.x] = true;
        
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,-1,1};
        while(!visit.isEmpty()){
            Node node = visit.pop();
            
            for(int i=0; i<4; i++){
                Node newNode = new Node(node.x + dx[i], node.y + dy[i], node.cnt + 1);
                if(newNode.x < chMaps[0].length && newNode.y < chMaps.length && newNode.x >= 0 && newNode.y >= 0 ){
                    if(visited[newNode.y][newNode.x] == false){
                        visited[newNode.y][newNode.x] = true;
                        
                        if(chMaps[newNode.y][newNode.x] == 'L'){
                            return newNode.cnt;
                        }else{
                            visit.add(newNode);
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        
        char[][] chMaps = new char[maps.length][maps[0].length()];
        boolean[][] visited1 = new boolean[maps.length][maps[0].length()];
        boolean[][] visited2 = new boolean[maps.length][maps[0].length()];
        int[] start = {0,0};    int[] end = {0,0};
        
        for(int i=0; i<maps.length; i++){
            chMaps[i] = maps[i].toCharArray();
            for(int j=0; j<maps[0].length(); j++){
                
                switch(chMaps[i][j]){
                    case 'S':   
                        start[0] = i;   start[1] = j;                   break;
                    case 'X':
                        visited1[i][j] = true; visited2[i][j] = true;   break;
                    case 'E':
                        end[0] = i;     end[1] = j;                     break;
                }
            }
        }
        int cnt1 = bfs(visited1,chMaps,start), cnt2 = bfs(visited2,chMaps,end);
        
        return (cnt1 == -1 || cnt2 == -1) ? -1 : cnt1 + cnt2;
    }
}