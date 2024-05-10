import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        var playersMap = new HashMap<String, Integer>();
        for(int i = 0; i<players.length; i++){
            playersMap.put(players[i], i);
        }
        for(String call : callings){
            int i = playersMap.get(call);
            String tm = players[i-1];
            players[i-1] = players[i];
            players[i] = tm;
            playersMap.put(players[i-1], i-1);
            playersMap.put(players[i], i);
        }
        return players;
    }
}