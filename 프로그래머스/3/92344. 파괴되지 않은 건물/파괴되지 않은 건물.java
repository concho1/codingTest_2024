/*
    y
  x (0,0) (0,1)
    (1,0) (1,1)
    시간복잡도 고려 : 250000* 1000*1000 => 초과
    skill 순회 횟수를 줄일수 있나? => 없음..
    board 순회 횟수를 줄일수 있나? => 한번에 다 더해주면 됨
*/
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] boardTm = new int[board.length+1][board[0].length+1];
        for(int[] sk : skill){
            int degree = sk[0] == 1 ? -sk[5] : sk[5];
            // 마킹해주기
            boardTm[sk[1]][sk[2]]     += degree;
            boardTm[sk[1]][sk[4]+1]   -= degree;
            boardTm[sk[3]+1][sk[4]+1] += degree;
            boardTm[sk[3]+1][sk[2]]   -= degree;
        }
        // 한번에 합 구해주기
        for(int i=0; i<boardTm.length-1; i++){
            for(int j=1; j<boardTm[0].length-1; j++){
                boardTm[i][j] += boardTm[i][j-1];
            }
        }
        for(int i=0; i<boardTm[0].length-1; i++){
            for(int j=0; j<boardTm.length-1; j++){
                if(j==0){
                    if(board[j][i] + boardTm[j][i] > 0) answer++;
                }else{
                    boardTm[j][i] += boardTm[j-1][i];
                    if(board[j][i] + boardTm[j][i] > 0) answer++;
                }
            }
        }
        return answer;
    }
}