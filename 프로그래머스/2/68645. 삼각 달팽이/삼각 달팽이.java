/*
*   1
*   2 9
*   3 10 8
*   4 5 6 7
*   하 n개  , 우 n-1개 , 좌상 2, 하 1, 우, 좌상
*   ac = 1: 하,   2: 우,   3: 좌상
*/
class Solution {
    public int[] solution(int n) {
        int[][] map = new int[n][];
        
        for(int i=0; i<n; i++)  map[i] = new int[i+1];
        
        int act = 1, num = 0, i=-1, j=0;
        for(int cnt = n; cnt > 0; cnt--){//찍을 개수
            for(int c=0; c<cnt; c++){
                if(act == 1){
                    map[++i][j] = ++num;
                }else if(act == 2){
                    map[i][++j] = ++num;
                }else{
                    map[--i][--j] = ++num;
                }
            }
            if(++act == 4) act = 1;
        }
        int cnt = -1;
        
        int[] result = new int[num];
        for(int i1=0; i1<map.length; i1++){
            for(int j1=0; j1<map[i1].length; j1++){
                result[++cnt] = map[i1][j1];
            }
        }
        
        return result;
    }
}